import numpy as np


def stocks_share(years, total_stocks):
    stocks_per_year = total_stocks / sum(years)
    stocks = []
    for n in years:
        stocks.append(round(n*stocks_per_year))
    return stocks


if __name__ == '__main__':
    years = [2, 3, 4, 6, 1, 2, 4, 8]
    print(stocks_share(years, 1000))
