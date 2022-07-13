# 1 - NUMERICKA INTEGRACIJA
#
# Integral je povrsina ispod neke funkcije.
# Odredjeni integral je povrsina na nekom intervalu.
#
# 1. TRAPEZNA METODA - Vjezbe8
# - Aproksimira polinomom prvog stepena
# 2. SIMPSONOVA METODA
# - Aproksimira pominomom drugog stepena
# integrate_simpson(f, a, b, intervals, plotSpeed)
#                         koliko intervala npr. 100

# povrsina izmedju f i g: integral(abs(f(x) - g(x)))
# zapremina rotacijom f oko x-ose: Pi * integral(f(x)**2)
# povrsina rotacijom oko y-ose: integral(f-1(x))


# 2 - ODJ, PPV - Vjezbe9
#
# Ako u jednacini imamo n-ti izvod, moramo znati sve n-1 izvoda u poc. tacki
#
# 1. OJLEROV METOD
# - Koristi prva dva clana Tejlorovog reda
# 2. Runge-Kutta metoda (rk4)
# - Koristi prva tri clana Tejlorovog reda i kombinuje
#   neke koef. da bi dobili sledecu vrijednost
#
# euler(a, b, h, fx0, dfx)
# interval, pomjeraj, poc. uslov, izvod func.
# euler(a, b, h, nfx0, dnfx)
# ...     [x, fx, f_1, f_2..](nfx0)   najveci izvod (dnfx)

# Na lijevoj strani mora biti najveci izvod, a na desnoj ostatak


# 3 - ODJ, PGU - Vjezbe10
#
# Posmatramo slucajeve do 2. reda
# Kod PPV smo imali 2+ reda i dato je f(0), df(0), ddf(0)..
# Kod PGU imamo 2- reda i dato je f(a) i f(b) - granice
#
# Pretvaramo diferencijalnu jednacinu u alg.
# Lijevo ide f(x) i izvode, a desno samo x.
#
# Idi na 100 tacaka kod h
#
# finiteDifference(left, right, x1, fx1, x2, fx2, h)

# p = lsquares(x, fx, 7)
# px = np.polyval()
# p_diff = np.polyder(p) - izvod od p
