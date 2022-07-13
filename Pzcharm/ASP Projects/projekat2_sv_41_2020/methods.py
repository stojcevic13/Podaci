from datetime import datetime
from difflib import SequenceMatcher


def get_date_str(date):
    return datetime.strftime(date, '%d.%m.%Y %H:%M:%S')


def get_date(date_str):
    return datetime.strptime(date_str, '%d.%m.%Y %H:%M:%S')


def get_time(time_str):
    return datetime.strptime(time_str, '%H:%M:%S')


def get_time_str(time_time):
    return datetime.strftime(time_time, '%H:%M:%S')


def similar(a, b):
    return SequenceMatcher(None, a, b).ratio()


def input_option(a, b):
    while True:
        option = input('>>> ')
        if len(option) == 1 and ord(option) in range(ord(a), ord(b)+1):
            return option
        print('Pogrešan unos. Pokušajte ponovo.\n')


def valid_phone_input(message):
    while True:
        start_phone = input(message).replace(' ', '').replace('-', '')
        try:
            int(start_phone.replace('*', ''))
            return start_phone
        except ValueError:
            print('Pogrešan unos. Napomena: kao separatore koristite - i razmak.\nPokušajte ponovo.\n')


def create_table(date_time_list, history):
    print('\n{:^15}{:30}{:20}{:20}{:20}'.format('REDNI BROJ', 'DATUM I VRIJEME', 'POZIVALAC', 'PRIMALAC', 'TRAJANJE'))
    print('-' * 95)
    for date_time in date_time_list:
        red_br = str(date_time_list.index(date_time) + 1)
        date_str = get_date_str(date_time)
        call_info = history[date_str]
        print('{:^15}{:30}{:20}{:20}{:20}'.format(red_br, date_str, call_info[0], call_info[1], call_info[2]))


def create_phones_table(popularity_list, phone_numbers):
    print('\n{:^15}{:^12}{:20}{:15}'.format('REDNI BROJ', 'IME', 'PREZIME', 'BROJ TELEFONA'))
    print('-' * 70)
    for popularity in reversed(popularity_list):
        red_br = str(list(reversed(popularity_list)).index(popularity) + 1)
        phone_info = phone_numbers[popularity]
        print('{:^15}{:^12}{:20}{:15}'.format(red_br, phone_info[0], phone_info[1], phone_info[2]))
