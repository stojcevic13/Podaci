#!/usr/bin/python

from app.constants import *
from app.record import Record
from app.serial_file import SerialFile
from sys import exit


# binary_file = None


def read_txt(fn):
    rows = []
    with open(fn, "r") as f:
        for line in f.readlines():
            cols = line.split()
            rows.append({
                "id": int(cols[0]),
                "sifra": cols[1],
                "dolazak": cols[2],
                "celija": cols[3],
                "kazna": int(cols[4]),
                "status": 1
            })
    return rows


def main():
    rec = Record(ATTRIBUTES, FMT, CODING)
    fn = "data/sample.dat"
    binary_file = SerialFile(fn, rec, F)
    binary_file.init_file()

    rows = read_txt("data/in.txt")

    for i in range(0, len(rows)):
        rows[i]["status"] = 1
        binary_file.insert_record(rows[i])

    binary_file.print_file()

    print(binary_file.find_by_id(49))
    print(binary_file.find_by_id(35))

    binary_file.delete_by_id(35)
    binary_file.delete_by_id(8)
    binary_file.delete_by_id(28)

    binary_file.print_file()


def initialization():
    global binary_file
    rec = Record(ATTRIBUTES, FMT, CODING)
    fn = "data/sample.dat"
    binary_file = SerialFile(fn, rec, F)
    binary_file.init_file()
    print('Datoteka je inicijalizovana.')


def load_from_txt():
    rows = read_txt("data/in.txt")

    for i in range(0, len(rows)):
        rows[i]["status"] = 1
        binary_file.insert_record(rows[i])

    print('Podaci iz txt datoteke su prebaceni u binarnu.')


def show_all_content():
    binary_file.print_file()


def show_by_id():
    id = int(input('Unesite id: '))
    record = binary_file.get_by_id(id)
    print(record)


def create_new_record():
    id = int(input('Id: '))
    sifra = input('Sifra: ')
    dolazak = input('Dolazak: ')
    celija = input('Celija: ')
    kazna = int(input('Kazna: '))
    status = 1
    new_record = {"id": id, "sifra": sifra, "dolazak": dolazak, "celija": celija, "kazna": kazna, "status": status}
    binary_file.insert_record(new_record)
    print('Dodali ste novog zatvorenika.')


def logical_delete():
    id = int(input('Unesite id: '))
    binary_file.logical_delete(id)
    print('logicki obrisano')


def exit_app():
    print('Izasli ste iz aplikacije.')
    exit()


def update_record():
    id = int(input('Unesite id: '))
    record = binary_file.get_by_id(id)
    new_id = int(input('Novi id: '))
    record['id'] = new_id
    binary_file.update_record(id, record)


def menu():
    functionalities = {
        '1': initialization,
        '2': load_from_txt,
        '3': show_all_content,
        '4': show_by_id,
        '5': create_new_record,
        '6': logical_delete,
        '7': exit_app,
        '8': update_record
    }
    while True:
        print('1 - Inicijalizacija datoteke')
        print('2 - Prenos podataka iz tekstualne datoteke')
        print('3 - Prikaz svih slogova serijske datoteke')
        print('4 - Pretraga datoteke')
        print('5 - Unos novog sloga')
        print('6 - Logicko brisanje sloga')
        print('7 - Izlaz')
        print('8 - Azuriranje sloga')
        option = input('>>>')
        selected_function = functionalities[option]
        selected_function()


if __name__ == "__main__":
    menu()
