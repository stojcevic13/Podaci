import sys
import time
from trie import Trie
from graph1 import Graph
from qsort import rsort
from methods import *


class TelephoneExchange(object):

    __slots__ = '_firstnames_trie', '_lastnames_trie', '_numbers_trie', '_blocked_trie', '_g', 'functions', 'searches'

    def __init__(self):
        self._firstnames_trie = Trie()
        self._lastnames_trie = Trie()
        self._numbers_trie = Trie()
        self._blocked_trie = Trie()
        self._g = Graph()
        self.functions = {}
        self.searches = {}

    @staticmethod
    def _autocomplete(word, trie, index):
        exist, values = trie.starts_with(word)
        if exist:
            i = 0
            while i < 3 and i < (len(values)):
                print(f'{i + 1} - {values[i].split(",")[index]}')
                i += 1
            print(f'{i + 1} - Nazad')
            option = input_option('1', str(i + 1))
            if option != str(i + 1):
                return values[int(option) - 1].split(',')[index]
        else:
            print('Greška u unosu! Nepostojeći podatak.')

    def _did_you_mean(self, phone):
        sim_nums = self._numbers_trie.find_similar(phone)
        if len(sim_nums) > 0:
            print('Broj nije pronađen. Da li ste mislili na neki od sledećih brojeva?')
            i = 0
            for num in sim_nums:
                print(f'{i+1} - {num}')
                i += 1
            print(f'{len(sim_nums) + 1} - Nazad')
            option = input_option('1', str(len(sim_nums) + 1))
            if option != str(len(sim_nums) + 1):
                return sim_nums[int(option) - 1]
        else:
            print("Odabrali ste nepostojeći broj. Napomena: kao separatore koristite - i razmak.\nPokušajte ponovo.\n")

    def _input_name(self, message, is_firstname):
        trie, index = (self._firstnames_trie, 0) if is_firstname else (self._lastnames_trie, 1)
        while True:
            name = input(message).lower()
            if name == '':
                print('Neispravan unos! Pokušajte ponovo.\n')
            elif name[-1] == '*':
                name = self._autocomplete(name[:-1], trie, index)
                if name is not None:
                    return name
                continue
            elif trie.search(name):
                return name
            else:
                print('Ne postoji takav korisnik.')

    def _input_phone(self, message):
        while True:
            phone = valid_phone_input(message).replace(' ', '').replace('-', '')
            if self._numbers_trie.search(phone):
                return phone
            elif phone[-1] == '*' and (phone := self._autocomplete(phone[:-1], self._numbers_trie, 2)) is not None:
                return phone
            elif phone is not None and (phone := self._did_you_mean(phone)) is not None:
                return phone

    def _add_new_call(self, phone1, phone2, call_datetime, duration):
        self._g.insert_edge(phone1, phone2, f'{call_datetime},{duration}')

        print(f'Broj pozivaoca: {phone1}')
        print(f'Broj primaoca: {phone2}')
        print(f'Datum i vrijeme razgovora: {call_datetime}')
        print(f'Trajanje razgovora: {duration}')

        new_call = ', '.join([phone1, phone2, call_datetime, duration]) + '\n'
        calls = open('calls.txt', 'a')
        calls.write(new_call)
        calls.close()

    def live_call_simulation(self):
        phone1 = self._input_phone('Unesite broj pozivaoca: ')
        phone2 = self._input_phone('Unesite broj primaoca: ')

        if self._blocked_trie.search(phone1) or self._blocked_trie.search(phone2):
            print('Greška! Uneseni brojevi ne smiju biti zauzeti.')
        else:
            datetime_start = datetime.now()
            input('Pritisnite enter za kraj poziva')
            datetime_end = datetime.now()
            seconds = (datetime_end - datetime_start).seconds
            duration_str = '{:02}:{:02}:{:02}'.format(seconds // 3600, (seconds % 3600) // 60, seconds % 60)
            print('\nPoziv je završen.\n')
            self._add_new_call(phone1, phone2, get_date_str(datetime_start), duration_str)

    def file_call_simulation(self):
        calls2 = open('zadatak2.txt', 'r')
        print('Izvršeni su sledeći pozivi:\n')
        for line in calls2.readlines():
            phone1, phone2, date, duration = line[:-1].split(', ')
            phone1 = phone1.replace(' ', '').replace('-', '')
            phone2 = phone2.replace(' ', '').replace('-', '')
            self._add_new_call(phone1, phone2, date, duration)
            print()

    def call_history_for_two_numbers(self):
        history = {}
        phone1 = self._input_phone('Unesite 1. broj telefona: ')
        phone2 = self._input_phone('Unesite 2. broj telefona: ')

        if phone1 in self._g.outgoing and phone2 in self._g.outgoing[phone1]:
            for call in self._g.outgoing[phone1][phone2]:
                date_time, duration = call.split(',')
                history[date_time] = [phone1, phone2, duration]
        if phone2 in self._g.outgoing and phone1 in self._g.outgoing[phone2]:
            for call in self._g.outgoing[phone2][phone1]:
                date_time, duration = call.split(',')
                history[date_time] = [phone2, phone1, duration]

        date_time_list = [get_date(date) for date in history.keys()]
        rsort(date_time_list)
        if date_time_list:
            create_table(date_time_list, history)
        else:
            print('Uneseni brojevi nisu nikada komunicirali.')

    def call_history_for_one_number(self):
        phone = self._input_phone('Unesite broj telefona: ')
        history = {}
        if phone in self._g.outgoing and self._g.outgoing[phone]:
            for phone2 in self._g.outgoing[phone]:
                for call in self._g.outgoing[phone][phone2]:
                    date_time, duration = call.split(',')
                    history[date_time] = [phone2, duration]
        if phone in self._g.incoming and self._g.incoming[phone]:
            for phone2 in self._g.incoming[phone]:
                for call in self._g.incoming[phone][phone2]:
                    date_time, duration = call.split(',')
                    history[date_time] = [phone2, duration]

        date_time_list = [get_date(date) for date in history.keys()]
        rsort(date_time_list)
        if date_time_list:
            print('\n{:^15}{:30}{:20}{:20}'.format('REDNI BROJ', 'DATUM I VRIJEME', 'KOMUNICIRAO SA', 'TRAJANJE'))
            print('-' * 75)
            i = 0
            for date_time in date_time_list:
                i += 1
                date_str = get_date_str(date_time)
                print('{:^15}{:30}{:20}{:20}'.format(str(i), date_str, history[date_str][0], history[date_str][1]))
        else:
            print('Sa unesenim brojem niko nije komunicirao.')

    @staticmethod
    def write_search_options():
        print('1 - Pretraga po imenu')
        print('2 - Pretraga po prezimenu')
        print('3 - Pretraga po početnim ciframa broja telefona')
        print('4 - Nazad')

    def _calculate_popularity(self, phone):
        popularity = 0
        total_calls = 0
        if phone in self._g.incoming:
            for phone2 in self._g.incoming[phone]:
                for call_info in self._g.incoming[phone][phone2]:
                    seconds = (get_time(call_info.split(',')[1]) - get_time('00:00:00')).seconds
                    popularity += seconds // 30
                    total_calls += 1
            popularity *= len(self._g.incoming[phone]) * total_calls
        return popularity

    def _search_by_firstname(self):
        name = self._input_name('Unesite ime: ', is_firstname=True)
        if name is not None:
            exist, data = self._firstnames_trie.search(name.lower())
            phone_numbers = {}
            if exist:
                for info in data:
                    first, lastname, phone = info.split(',')
                    popularity_value = self._calculate_popularity(phone)
                    phone_numbers[popularity_value] = [first, lastname, phone]
                popularity_list = [popularity for popularity in phone_numbers.keys()]
                rsort(popularity_list)
                create_phones_table(popularity_list, phone_numbers)
            else:
                print('U imeniku ne postoji osoba sa tim imenom.')

    def _search_by_lastname(self):
        lastname = self._input_name('Unesite prezime: ', is_firstname=False)
        if lastname is not None:
            exist, data = self._lastnames_trie.search(lastname.lower())
            phone_numbers = {}
            if exist:
                for info in data:
                    firstname, lastname, phone = info.split(',')
                    popularity_value = self._calculate_popularity(phone)
                    phone_numbers[popularity_value] = [firstname, lastname, phone]
                popularity_list = [popularity for popularity in phone_numbers.keys()]
                rsort(popularity_list)
                create_phones_table(popularity_list, phone_numbers)

    def _search_by_phone_number(self):
        phone_start = valid_phone_input('Unesite početnih nekoliko cifara broja telefona: ')
        exist, phones = self._numbers_trie.starts_with(phone_start)
        phone_numbers = {}
        if exist:
            for info in phones:
                firstname, lastname, phone = info.split(',')
                popularity_value = self._calculate_popularity(phone)
                phone_numbers[popularity_value] = [firstname, lastname, phone]
            popularity_list = [popularity for popularity in phone_numbers.keys()]
            rsort(popularity_list)
            create_phones_table(popularity_list, phone_numbers)
        else:
            print('U imeniku ne postoji telefon koji počinje tako.')

    def _back(self):
        pass

    def phonebook_search(self):
        self.write_search_options()
        option = input_option('1', '4')
        selected_search = self.searches[option]
        selected_search()

    def phone_statistics(self):
        phone = self._input_phone('Unesite broj telefona: ')
        phones = {}
        total_calls = 0
        total_seconds = 0

        if phone in self._g.outgoing:    # Ako je broj pozivao nekog
            for phone2 in self._g.outgoing[phone]:
                total_calls += len(self._g.outgoing[phone][phone2])
                for call_info in self._g.outgoing[phone][phone2]:
                    total_seconds += (get_time(call_info.split(',')[1]) - get_time('00:00:00')).seconds
                phones[phone2] = ''

        if phone in self._g.incoming:    # Ako je neko zvao ovaj broj
            for phone2 in self._g.incoming[phone]:
                total_calls += len(self._g.incoming[phone][phone2])
                for call_info in self._g.incoming[phone][phone2]:
                    total_seconds += (get_time(call_info.split(',')[1]) - get_time('00:00:00')).seconds
                phones[phone2] = ''

        avg_seconds = total_seconds // total_calls
        average_duration = '{:02}:{:02}:{:02}'.format(avg_seconds // 3600, (avg_seconds % 3600) // 60, avg_seconds % 60)

        print('\nSTATISTIKA TELEFONA\n')
        print(f'Ukupan broj razgovora: {total_calls}')
        print(f'Razgovarao je sa {len(phones)} različitih brojeva.')
        print(f'Prosječno trajanje razgovora: {average_duration}')

    @staticmethod
    def exit_app():
        print('Izašli ste iz aplikacije.')
        sys.exit()

    @staticmethod
    def write_all_functionalities():
        print('\nIzaberite neku od dostupnih opcija:')
        print('1 - Simulacija pozivanja uživo')
        print('2 - Simulacija pozivanja iz fajla')
        print('3 - Istorija poziva za dva broja')
        print('4 - Istorija poziva jednog broja')
        print('5 - Pretraga telefonskog imenika')
        print('6 - Statistika jednog broja')
        print('7 - Izlaz iz aplikacije')

    def _load_phones(self):
        phones = open('phones.txt', 'r')
        self._g.insert_vertex('PhoneNumber')
        for line in phones.readlines():
            full_name, number = line[:-1].split(',')
            firstname, lastname = full_name.split()
            number = number.replace(' ', '').replace('-', '')
            self._g.insert_vertex(number)

            self._firstnames_trie.insert(firstname.lower(), f'{firstname},{lastname},{number}')
            self._lastnames_trie.insert(lastname.lower(), f'{firstname},{lastname},{number}')
            self._numbers_trie.insert(number, f'{firstname},{lastname},{number}')
        phones.close()

    def _load_calls(self):
        calls = open('calls.txt', 'r')
        for line in calls.readlines():
            phone1, phone2, date, duration = line[:-1].split(', ')
            phone1 = phone1.replace(' ', '').replace('-', '')
            phone2 = phone2.replace(' ', '').replace('-', '')

            # if phone1 not in self._g.outgoing:
            #     self._g.insert_vertex(phone1)
            # if phone2 not in self._g.outgoing:
            #     self._g.insert_vertex(phone2)

            self._g.insert_edge(phone1, phone2, f'{date},{duration}')

        calls.close()

    def _load_blocked(self):
        blocked = open('blocked.txt', 'r')
        for line in blocked.readlines():
            number = line[:-1].replace(' ', '').replace('-', '')
            self._blocked_trie.insert(number, None)
        blocked.close()

    def _load_data(self):
        time1 = time.time()
        self._load_phones()
        self._load_calls()
        self._load_blocked()
        time2 = time.time()
        print(f'Vrijeme učitavanja podataka: {time2-time1}')

    def _create_function_maps(self):
        self.functions = {
            '1': self.live_call_simulation,
            '2': self.file_call_simulation,
            '3': self.call_history_for_two_numbers,
            '4': self.call_history_for_one_number,
            '5': self.phonebook_search,
            '6': self.phone_statistics,
            '7': self.exit_app
        }
        self.searches = {
            '1': self._search_by_firstname,
            '2': self._search_by_lastname,
            '3': self._search_by_phone_number,
            '4': self._back
        }

    def start_menu(self):
        self._load_data()
        self._create_function_maps()
        while True:
            self.write_all_functionalities()
            option = input_option('1', '7')
            selected_function = self.functions[option]
            selected_function()
            input('\nPritisnite enter za nastavak')
