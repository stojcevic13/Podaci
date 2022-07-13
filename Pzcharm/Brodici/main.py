brod = chr(0x2693) + " "
promasaj = chr(0x274C) + " "
slobodno = chr(0x1F7E9)

uneseni = []  # globalna promenljiva koja sadrzi koordinate koje je korisnik unio
br_gresaka, br_pogodaka = 0, 0

matrica_ispis = []  # globala promjenljiva koja u pocetku ima sve zelene, a mijenja se svaki put prilikom unosa koordinata
                    # i na mjesto unosa koordinata se postavlja X ili sidro
matrica_podaci = []  # matrica koja sadrzi podatke o tome na kojoj poziciji je brod a na kojoj nije

brodici = {   # dictionary koji kao kljuc ima velicine broda a vrijednosti se povecavaju za 1 kad se brod ucita iz fajla
    2: 0,
    3: 0,
    4: 0,
    5: 0
}


def generisi_matricu(red, kol):   # generise matricu koja ima sve elemente zelene kocke
    lista = []
    matrica = []
    for i in range(red):
        for j in range(kol):
            lista.append(slobodno)
        matrica.append(lista)
        lista = []
    return matrica


def postavi_brodice(x, y, vel, polozaj):
    global matrica_podaci, brodici
    postavljeno = 0  # brojac - petlja se zaustavlja kad se postavi citav brod tj. kad velicina broda bude jednaka broju postavljenim sidrima
    while postavljeno < vel:
        try:
            if matrica_podaci[x][y] == brod or vel not in range(2, 6):  # ako se brodovi poklapaju ili velicina broda nije 2,3,4 ili 5
                return False
            matrica_podaci[x][y] = brod  # postavlja se brod ako je uslov ispunjen
            brodici[vel] += 1  # azurira se globalna promjenljiva tj. povecava se broj brodova te velicine (jer mogu da budu npr 2 broda velicine 2 pa se oznacava koliko brodova po velicini je postavljeno
            if polozaj == "v":
                x -= 1  # red ide ka gore odnosno x koordinata se smanjuje jer su naopako stavili redove
            else:
                y += 1  # kolone su normalne pa se y povecava za 1
            postavljeno += 1
        except:   # ako je doslo do bilo kakve greske: indeks nije od 1 do 7 ili velicina nije 2,3,4 ili 5
            return False


def pogresan_raspored_brodica():
    global brodici              # zip znaci da istovremeno 'br_brodica' ide kroz kjuceve 'brodici' a 'pravilno' ide kroz listu [2,1,1,1]
    for br_brodica, pravilno in zip(brodici, [2, 1, 1, 1]):  # ako nije postavljeno: tacno 2 * brodica velicine 2, 1 * brodic velicine 3...
        if br_brodica != pravilno:  # ako nije ispostovano pravilo da ima tacno 2 * brodica velicine 2, 1 * brodic velicine 1...
            return False
    return True  # ako je lista prosla bez problema, vrati True


def ucitaj_matricu():
    global matrica_podaci
    matrica_podaci = generisi_matricu(7, 7)  # генерише се матрица са коцкама
    matrica_fajl = open("C:\\brodici.txt", "r")
    for linija in matrica_fajl.readlines():
        y, x, vel, polozaj = linija[:-1].split(",")  # сплит од 3,2,1 прави низ од 3 елемента: 3 2 и 1
        x, y, vel = 6 - int(x), int(y), int(vel)  # претварају се у инт јер кад се учитају из фајла, они су типа стринг, а Х су редови, то су обрнули па зато иде 6 - инт(х)
        if postavi_brodice(x, y, vel, polozaj) == False: #ако се десила нека грешка из функције горе, враћа се фалсе, а сваки фајл који се отвори, мора и да се затвори јер може доћи до губитка података фајла
            matrica_fajl.close()
            return False
    if pogresan_raspored_brodica():  # ако се десила грешка горе, врати фалсе
        return False
    return matrica_podaci  # ако је све прошло како треба, враћа се матрица


def ispisi_matricu(matrica):  # ово конташ :)
    for i in range(7):
        for j in range(7):
            print(matrica[i][j], end="")
        print()


def unesi_brojeve():
    while True:
        try:
            x, y = eval(input("Unesite x i y koordinatu: "))  # евал претвара унос у интегер, али омогућава и унос више бројева одједном
            return x, y
        except NameError:   # ако се унесе шкљмнњ
            print("Pogrešan unos. Pokušajte ponovo. \n")


def unesi_koordinate():
    while True:
        x, y = unesi_brojeve()
        if x in range(7) and y in range(7):  # ако корисник унесе нпр 14,19 а може само од 0 до 6
            if (x, y) not in uneseni:  # ако није унио координате које је већ раније уносио
                uneseni.append((x, y))
                return 6-x, y
        print("Pogrešan unos. Pokušajte ponovo. \n")


def podesi_podatke(x, y):
    global br_pogodaka, br_gresaka, matrica_ispis, matrica_podaci
    if matrica_podaci[x][y] == brod:   # ако је погодио координате брода
        matrica_ispis[x][y] = brod   #матрица на том мјесту добија сидро
        br_pogodaka += 1
    else:
        matrica_ispis[x][y] = promasaj  # ако је промашио, матрица добија Х
        br_gresaka += 1


def ispisi_poruku(br_gresaka):  # И ово знаш :)
    if br_gresaka >= 20:
        print("Igra je završena! Izgubili ste!")
    else:
        print("Čestitamo! Uspješno ste pronašli sve brodove!")
        print(f"Osvojili ste {20 - br_gresaka} bodova!")


def igraj():
    global matrica_ispis, matrica_podaci
    ispisi_matricu(matrica_ispis)  # на почетку испиши 7*7 коцкица
    while br_gresaka < 20 and br_pogodaka < 16:  # број дозвољених грешака је 20, а укупно у матрици има 16 "сидара"
        x, y = unesi_koordinate()
        podesi_podatke(x, y)
        ispisi_matricu(matrica_ispis)   # исписује се промијењена матрица: додато је сидро или Х
    ispisi_poruku(br_gresaka)


def pokreni_igru():
    global matrica_ispis, matrica_podaci
    matrica_ispis = generisi_matricu(7, 7)  # матрица са коцкама
    matrica_podaci = ucitaj_matricu()
    if matrica_podaci == False:  # ако је дошло до било какве грешке у фајлу, матрица има вриједност фалсе и онда се игра уопште не покреће
        print("Došlo je do greške.")
    else:
        igraj()


if __name__ == '__main__':  # __name__ je promjenljiva koja predstavlja naziv fajla(modula), a kad se fajl pokrene, njegovo ime onda postaje __main__ tako da ovo znaci: pokreni_igru() ako se program pokrene
    pokreni_igru()
