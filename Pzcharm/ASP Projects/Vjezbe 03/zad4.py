class Player(object):
    def __init__(self, health, mana):
        self._health = health
        self._mana = mana

    @property
    def health(self):
        return self._health

    @property
    def mana(self):
        return self._mana

    @health.setter
    def health(self, health):
        self._health = health

    @mana.setter
    def mana(self, mana):
        self._mana = mana

    def __str__(self):
        return  f"Health: {self._health}. Mana: {self._mana}."
import abc
class Item(abc.ABC):
    def __init__(self, value):
        self._value = value

    @property
    def value(self):
        return self._value

    @value.setter
    def value(self, value):
        self._value = value

    def __str__(self):
        return f"Value: {self._value}"

    @abc.abstractmethod
    def use(self, player):
        pass

class Food(Item):
    def use(self, player):
        player.health += self.value

class Potion(Item):
    def __init__(self, value, type):
        super().__init__(value)
        #self._value = value
        self._type = type

    @property
    def type(self):
        return self._type

    def __str__(self):
        return f"Value: {self.value}. Type: {self._type}"

    def use(self, player):
        if self._type == "health":
            player.health += self.value
        else:
            player.mana += self.value

if __name__ == "__main__":
    player1 = Player(100.0, 100.0)
    print(player1)
    food1 = Food(100.0)
    potion1 = Potion(200.0, "health")
    potion2 = Potion(300.0, "mana")
    lista = [food1, potion1, potion2]

    for item in lista:
        print()
        print(item)
        item.use(player1)
        print(player1)