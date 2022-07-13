class Person(object):
    def __init__(self, name, age):
        self._name = name
        self._age = age

    def get_name(self):
        return self._name

    def get_age(self):
        return self._age

    def set_name(self, name):
        self._name = name

    def set_age(self, age):
        self._age = age

    def introduce_yourself(self):
        print(f"Ja sam {self._name}. Imam {self._age} godina.")


class Student(Person):
    def __init__(self, name, age, grade, year):
        super().__init__(name, age)
        self._grade = grade
        self._year = year

    def get_grade(self):
        return self._grade

    def get_year(self):
        return self._year

    def set_grade(self, grade):
        self._grade = grade

    def set_year(self, year):
        self._year = year

    def introduce_yourself(self):
        print(f"Ja sam {self._name}. {self._year}. sam godina i imam {self._age} godina. Prosjek: {self._grade}")

if __name__ == '__main__':
    stud1 = Student("Nemanja Stojcevic", 19, 9.80, 1)
    stud1.introduce_yourself()
