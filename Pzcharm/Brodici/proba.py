from main import ispisi_matricu

def ispisi_matricu(matrica):
    for i in range(7):
        for j in range(7):
            print(matrica[i][j], end=" ")
        print()


def generisi_matricu():
    lista = []
    matrica = []
    for i in range(7):
        for j in range(7):
            lista.append(0)
        matrica.append(lista)
        lista = []
    return matrica


if __name__ == "__main__":
    matrica = generisi_matricu()
    ispisi_matricu(matrica)
    matrica[0][0] = 1
    print()
    ispisi_matricu(matrica)
