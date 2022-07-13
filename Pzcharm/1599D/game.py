from player import Player
from point import Point
from functionalities import point_to_line_distance, create_line, angle_between_lines


class Game(object):

    def __init__(self):
        self._n = 0
        self._q = 0
        self._players = []
        self._points = []
        self._points2 = []
        self._center_rotation = None

    def _input_data(self):
        self._n = int(input('Koliko mjehurića: '))
        for i in range(self._n):
            x, y = eval(input(f'Unesite koorditate {i+1}. mjehurića: '))
            self._points.append(Point(x, y))
        print()

        self._q = int(input('Koliko igrača: '))
        for i in range(self._q):
            print(f'{i+1}. igrač')
            dxi, dyi, ki = eval(input(f'dxi, dyi, ki= '))
            self._players.append(Player(dxi, dyi, ki))
        print()

    def start(self):
        self._input_data()

        for player in self._players:
            print('Redoslijed bušenja:')
            self._points2 = [point for point in self._points]
            self._find_first_popped(player)
            self._rotation(player)
            print()

    def _find_first_popped(self, player):
        distances = {}
        for point in self._points2:
            distance = point_to_line_distance(point, player.line)
            distances[distance] = point
        min_distance = min(distances.keys())
        popped = distances[min_distance]
        self._point_is_popped(popped, player)
        player.line.n = popped.y - player.line.k * popped.x

    def _point_is_popped(self, popped, player):
        player.popped_bubbles.append(popped)
        self._points2.remove(popped)
        self._center_rotation = popped
        print(popped)

    def _rotation(self, player):
        if len(player.popped_bubbles) >= player.k:
            print(f'Redni broj poslednjeg probušenog: {self._points.index(player.popped_bubbles[-1]) + 1}')
            return
        angles = {}
        for point in self._points2:
            new_line = create_line(point, self._center_rotation)
            angle = angle_between_lines(player.line.k, new_line.k)
            angles[angle] = point
        min_angle = min(angles.keys())
        popped = angles[min_angle]
        player.line = create_line(self._center_rotation, popped)
        self._point_is_popped(popped, player)
        self._rotation(player)
