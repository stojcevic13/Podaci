from random import shuffle
from time import time


class State(object):

    def __init__(self, board=None, num_of_b=None, num_of_c=None, stable_fields=None):
        if board:
            self._board = board
            self._num_of_b = num_of_b
            self._num_of_c = num_of_c
            self._stable_fields = stable_fields
        else:
            self._board = []
            self._initial_state_2()
            self._num_of_b = 2
            self._num_of_c = 2
            self._stable_fields = {
                'B': [],
                'C': []
            }

    @property
    def board(self):
        return self._board

    @property
    def num_of_b(self):
        return self._num_of_b

    @property
    def num_of_c(self):
        return self._num_of_c

    @property
    def stable_fields(self):
        return self._stable_fields

    @staticmethod
    def valid_coordinates(x, y):
        return x >= 0 and x <= 7 and y >= 0 and y <= 7

    @staticmethod
    def rotate_mark(mark):
        return 'C' if mark == 'B' else 'B'

    def _initial_state_2(self):
        row = []
        for x in range(0, 8):
            for y in range(0, 8):
                if (x, y) == (3, 3) or (x, y) == (4, 4):
                    fill = 'C'
                elif (x, y) == (3, 4) or (x, y) == (4, 3):
                    fill = 'B'
                else:
                    fill = '-'
                row.append(fill)
            self._board.append(row)
            row = []

    def copy_current_board(self):
        copy, row = [], []
        for x in range(0, 8):
            for y in range(0, 8):
                row.append(self._board[x][y])
            copy.append(row)
            row = []
        return copy

    def copy_stable_fields(self):
        new_stable_fields = {
            'B': [],
            'C': []
        }
        for field_B in self._stable_fields['B']:
            new_stable_fields['B'].append(field_B)
        for field_C in self._stable_fields['C']:
            new_stable_fields['C'].append(field_C)
        return new_stable_fields

    def _is_possible_move(self, coord_x, coord_y, mark):
        another_mark = self.rotate_mark(mark)
        for inc_i, inc_j in [(0, -1), (0, 1), (-1, 0), (1, 0), (-1, -1), (1, 1), (1, -1), (-1, 1)]:
            x, y = coord_x + inc_i, coord_y + inc_j
            if self.valid_coordinates(x, y) and self._board[x][y] != another_mark:
                continue
            while self.valid_coordinates(x, y) and self._board[x][y] == another_mark:
                x, y = x + inc_i, y + inc_j
            if self.valid_coordinates(x, y) and self._board[x][y] == mark:
                return True

    def find_possible_moves_2(self, mark):
        possible_moves = []
        for x in range(0, 8):
            for y in range(0, 8):
                if self._board[x][y] == '-':
                    if self._is_possible_move(x, y, mark):
                        possible_moves.append((x, y))
        shuffle(possible_moves)
        return possible_moves

    def _rotate_fields(self, mark, taken_fields):
        for field in taken_fields:
            self._board[field] = mark
        if mark == 'C':
            self._num_of_b -= len(taken_fields) - 1
            self._num_of_c += len(taken_fields)
        else:
            self._num_of_b += len(taken_fields)
            self._num_of_c -= len(taken_fields) - 1

    def _get_taken_fields(self, coord_x, coord_y, mark):
        another_mark = self.rotate_mark(mark)
        taken_fields = [(coord_x, coord_y)]
        for inc_i, inc_j in [(0, -1), (0, 1), (-1, 0), (1, 0), (-1, -1), (1, 1), (1, -1), (-1, 1)]:
            taken_fields_line = []
            x, y = coord_x + inc_i, coord_y + inc_j
            if self.valid_coordinates(x, y) and self._board[x][y] != another_mark:
                continue
            while self.valid_coordinates(x, y) and self._board[x][y] == another_mark:
                taken_fields_line.append((x, y))
                x, y = x + inc_i, y + inc_j
            if self.valid_coordinates(x, y) and self._board[x][y] == mark:
                taken_fields += taken_fields_line
        return taken_fields

    def refresh_the_board(self, x, y, mark):
        taken_fields = self._get_taken_fields(x, y, mark)
        for field in taken_fields:
            self._board[field[0]][field[1]] = mark
            if self._stable_field(field[0], field[1], mark):
                self._stable_fields[mark].append(field)

        if mark == 'C':
            self._num_of_b -= len(taken_fields) - 1
            self._num_of_c += len(taken_fields)
        else:
            self._num_of_b += len(taken_fields)
            self._num_of_c -= len(taken_fields) - 1

    def _num_of_corners(self, mark):
        num_of_corners = 0
        for corner in [(0, 0), (0, 7), (7, 0), (7, 7)]:
            num_of_corners += 1 if self._board[corner[0]][corner[1]] == mark else 0
        return num_of_corners

    def _x2square(self, mark):
        our_x2, op_x2 = 0, 0
        x2squares = [(1, 0), (1, 1), (0, 1), (0, 6), (1, 6), (1, 7), (6, 0), (6, 1), (7, 1), (7, 6), (6, 6), (6, 7)]
        for fld in x2squares:
            if fld in [(1, 0), (1, 1), (0, 1)] and self._board[0][0] == '-' and self._board[fld[0]][fld[1]] != '-':
                if self._board[fld[0]][fld[1]] == mark:
                    our_x2 += 1
                else:
                    op_x2 += 1

            if fld in [(0, 6), (1, 6), (1, 7)] and self._board[0][7] == '-' and self._board[fld[0]][fld[1]] != '-':
                if self._board[fld[0]][fld[1]] == mark:
                    our_x2 += 1
                else:
                    op_x2 += 1

            if fld in [(6, 0), (6, 1), (7, 1)] and self._board[7][0] == '-' and self._board[fld[0]][fld[1]] != '-':
                if self._board[fld[0]][fld[1]] == mark:
                    our_x2 += 1
                else:
                    op_x2 += 1

            if fld in [(7, 6), (6, 6), (6, 7)] and self._board[7][7] == '-' and self._board[fld[0]][fld[1]] != '-':
                if self._board[fld[0]][fld[1]] == mark:
                    our_x2 += 1
                else:
                    op_x2 += 1

        return our_x2, op_x2

    def _stable_field(self, x, y, mark):
        fields = self._stable_fields[mark]

        # vertical
        if not (x-1 < 0 or x+1 > 7 or (x-1, y) in fields or (x+1, y) in fields):
            return False
        # horizontal
        if not (y-1 < 0 or y+1 > 7 or (x, y-1) in fields or (x, y+1) in fields):
            return False
        # diagonal
        if not (x-1 < 0 or y-1 < 0 or x+1 > 7 or y+1 > 7 or (x-1, y-1) in fields or (x+1, y+1) in fields):
            return False
        if not (x-1 < 0 or y+1 > 7 or x+1 > 7 or y-1 < 0 or (x-1, y+1) in fields or (x+1, y-1) in fields):
            return False

        return True

    def _get_num_of_corners(self, mark, another_mark):
        our_corners, op_corners = 0, 0
        for corner in [(0, 0), (0, 7), (7, 0), (7, 7)]:
            if self._board[corner[0]][corner[1]] == mark:
                our_corners += 1
            elif self._board[corner[0]][corner[1]] == another_mark:
                op_corners += 1
        return our_corners, op_corners

    def table_heuristic(self, mark):
        another_mark = self.rotate_mark(mark)
        our, opponents = (self._num_of_b, self._num_of_c) if mark == 'B' else (self._num_of_c, self._num_of_b)
        coin_parity_value = 100 * (our - opponents) / (our + opponents)

        # our_moves, op_moves = len(self.find_possible_moves_2(mark)), len(self.find_possible_moves_2(another_mark))
        # mobility_value = 100 * (our_moves - op_moves) / (our_moves + op_moves) if our_moves + op_moves != 0 else 0

        our_corners, op_corners = self._get_num_of_corners(mark, another_mark)
        corners_value = 100 * (our_corners - op_corners) / 4

        our_safe, op_safe = len(self._stable_fields[mark]), len(self._stable_fields[another_mark])
        safety_value = 100 * (our_safe - op_safe) / 10

        our_x2, op_x2 = self._x2square(mark)
        x2_value = 100 * (op_x2 - our_x2) / 12

        heuristic_value = coin_parity_value + 4 * corners_value + 2 * safety_value + 3 * x2_value

        return round(heuristic_value)

    def __str__(self):
        ret = "\n\n    0   1   2   3   4   5   6   7\n  ---------------------------------\n"
        for x in range(0, 8):
            ret += str(x) + " |"
            for y in range(0, 8):

                if self._board[x][y] == '-':
                    ret += "   |"

                else:
                    ret += " %s |" % self._board[x][y]
            ret += "\n  ---------------------------------\n"
        ret += '\n\nB: ' + str(self._num_of_b) + '     C: ' + str(self._num_of_c) + '\n'
        return ret


if __name__ == '__main__':
    state = State()
    time1 = time()
    for i in range(9000):
        new_board = state.copy_current_board()
    time2 = time()
    print((time2 - time1))
