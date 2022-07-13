class Student(object):
    def __init__(self, firstname, lastname, ocjene=None):
        self._firstname = firstname
        self._lastname = lastname
        self._prosjek = 0
        if ocjene == None:
            ocjene = []
        self._ocjene = ocjene

    @property
    def firstname(self):
        return self._firstname

    @property
    def lastname(self):
        return self._lastname

    @firstname.setter
    def firstname(self, firstname):
        self._firstname = firstname

    @lastname.setter
    def lastname(self, lastname):
        self._lastname = lastname

    def upisi_ocjenu(self, ocjena):
        self._ocjene.append(ocjena)
        self._prosjek = sum(self._ocjene) / len(self._ocjene)

    def ponisti_ocjenu(self, ocjena):
        self._ocjene.remove(ocjena)
        self._prosjek = sum(self._ocjene) / len(self._ocjene)

    def ispisi_prosjek(self):
        print("Prosjek: %.2f" % (self._prosjek))

    def introduce_yourself(self):
        print(f"Ja sam {self._firstname} {self._lastname}.")


if __name__ == "__main__":
    stud1 = Student("Nemanja", "Stojcevic")
    stud1.upisi_ocjenu(10)
    stud1.upisi_ocjenu(10)
    stud1.upisi_ocjenu(9)
    stud1.upisi_ocjenu(10)
    stud1.upisi_ocjenu(10)
    stud1.introduce_yourself()
    stud1.ispisi_prosjek()