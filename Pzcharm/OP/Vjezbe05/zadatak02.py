
def zadatak2():
    cubic = int(input('Unesite kubikazu vozila: '))
    with open('automobili.txt') as file:
        required_car = file.readline()[:-1].split(' ')
        for line in file.readlines():
            curr_car = line[:-1].split(' ')
            if int(curr_car[1]) <= cubic and int(curr_car[2]) > int(required_car[2]):
                required_car = curr_car

    print(f'Najnoviji automobil kubikaze ne vece od {cubic}:')
    print(f'{required_car[0]}    Kubikaza: {required_car[1]}    Godiste: {required_car[2]}')


if __name__ == '__main__':
    cubic = 2000
    with open('automobili.txt') as file:
        max_car = file.readline()[:-1].split(' ')
        for line in file.readlines():
            car = line[:-1].split(' ')
            if int(car[1]) <= cubic and int(car[2]) > int(max_car[2]):
                max_car = car
    print(max_car)
