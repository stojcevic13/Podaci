import pickle


if __name__ == '__main__':
    with open('zad4.csv', 'r') as file:
        temps = []
        for line in file.readlines():
            temps.append(line[:-1].split(', '))

    with open('temps.bin', 'wb') as out:
        pickle.dump(temps, out)

    with open('temps.bin', 'rb') as inn:
        temps2 = pickle.load(inn)
        print(temps == temps2)
