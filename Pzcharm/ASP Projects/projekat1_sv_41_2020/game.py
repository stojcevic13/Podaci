from state import State
import time
from tree import Tree, TreeNode
from hashmap import ChainedHashMap


class Game(object):

    def __init__(self):
        self._current_state = State()
        self._not_possible_moves = 0
        self._game_tree = Tree(self._current_state)
        self._heuristics = ChainedHashMap()
        self._num_of_turns = 0

    @staticmethod
    def valid_coordinate_input(possible_inputs=None):
        while True:
            x = input('Unesite x koordinatu: ')
            y = input('Unesite y koordinatu: ')
            try:
                if (int(x), int(y)) in possible_inputs:
                    return int(x), int(y)
                else:
                    print('Neispravan unos! Unesite neki od mogućih poteza.\n')
            except ValueError:
                print('Neispravan unos! Unesite neki od mogućih poteza.\n')

    def _computer_turn(self):
        self._game_tree.root = TreeNode(self._current_state, None)
        move, future_root = self.next_move(self._game_tree.root)
        if move:
            self._num_of_turns += 1
            self._not_possible_moves = 0
            print('Potez kompjutera: ' + str(move))
            self._game_tree.root = future_root
            self._current_state = self._game_tree.root.state
        else:
            print('Kompjuter je ostao bez poteza.')
            self._not_possible_moves += 1

    def _player_turn(self):
        possible_moves = self._current_state.find_possible_moves_2('C')
        if possible_moves:
            self._num_of_turns += 1
            self._not_possible_moves = 0
            print('Mogući potezi: ' + ', '.join(str(move) for move in possible_moves))
            x, y = self.valid_coordinate_input(possible_moves)
            self._current_state.refresh_the_board(x, y, 'C')
        else:
            print('Ostali ste bez poteza.')
            self._not_possible_moves += 1

    def _calculate_depth(self):
        if self._num_of_turns <= 1 or self._num_of_turns >= 51:
            depth = 8
        elif self._num_of_turns <= 3 or (self._num_of_turns in [49, 50]):
            depth = 7
        elif self._num_of_turns <= 9 or (self._num_of_turns in [45, 46, 47, 48]):
            depth = 6
        elif self._num_of_turns <= 13:
            depth = 5
        else:
            depth = 5
        return depth

    def next_move(self, node):
        best_move, future_root = None, None
        alpha = -1001
        possible_moves = node.state.find_possible_moves_2('B')
        depth = self._calculate_depth()

        for move in possible_moves:
            new_board = node.state.copy_current_board()
            new_stable_fields = node.state.copy_stable_fields()
            new_state = State(new_board, node.state.num_of_b, node.state.num_of_c, new_stable_fields)
            new_state.refresh_the_board(move[0], move[1], 'B')
            child = TreeNode(new_state, move)
            node.add_child(child)

            evalue = self.min(child, depth-1, alpha, 1001)
            if evalue > alpha:
                alpha = evalue
                best_move = child.move
                future_root = child
            if alpha >= 1000:
                break

        print('DUBINA: ' + str(depth))
        return best_move, future_root

    def max(self, node, depth, alpha, beta):
        if depth <= 0:
            try:
                heuristic = self._heuristics[str(node.state.board)]
            except KeyError:
                self._heuristics[str(node.state.board)] = node.state.table_heuristic('B')
                heuristic = self._heuristics[(str(node.state.board))]
            return heuristic

        possible_moves = node.state.find_possible_moves_2('B')

        # terminal
        if not possible_moves:
            return node.state.table_heuristic('B')

        for move in possible_moves:
            new_board = node.state.copy_current_board()
            new_stable_fields = node.state.copy_stable_fields()
            new_state = State(new_board, node.state.num_of_b, node.state.num_of_c, new_stable_fields)
            new_state.refresh_the_board(move[0], move[1], 'B')
            child = TreeNode(new_state, move)
            node.add_child(child)

            evalue = self.min(child, depth-1, alpha, beta)
            alpha = max(alpha, evalue)
            if alpha >= beta:
                return beta
        return alpha

    def min(self, node, depth, alpha, beta):
        if depth <= 0:
            try:
                heuristic = self._heuristics[str(node.state.board)]
            except KeyError:
                self._heuristics[str(node.state.board)] = node.state.table_heuristic('B')
                heuristic = self._heuristics[(str(node.state.board))]
            return heuristic

        possible_moves = node.state.find_possible_moves_2('C')

        # terminal
        if not possible_moves:
            return node.state.table_heuristic('B')

        for move in possible_moves:
            new_board = node.state.copy_current_board()
            new_stable_fields = node.state.copy_stable_fields()
            new_state = State(new_board, node.state.num_of_b, node.state.num_of_c, new_stable_fields)
            new_state.refresh_the_board(move[0], move[1], 'C')
            child = TreeNode(new_state, move)
            node.add_child(child)

            evalue = self.max(child, depth-1, alpha, beta)
            beta = min(beta, evalue)
            if alpha >= beta:
                return alpha
        return beta

    def play(self):
        while True:
            print(self._current_state)

            self._player_turn()
            print(self._current_state)

            if self._not_possible_moves == 2:
                break

            start = time.time()
            self._computer_turn()
            end = time.time()
            print('Vrijeme trajanja: {}s'.format(round(end - start, 7)))

            if self._not_possible_moves == 2:
                break
        self.end_game()

    def end_game(self):
        num_of_b, num_of_c = self._current_state.num_of_b, self._current_state.num_of_c
        print()

        if num_of_b > num_of_c:
            print('Pobjednik je igrač B.')
        elif num_of_b < num_of_c:
            print('Pobjednik je igrač C.')
        else:
            print('Rezultat je nerijerešen.')
