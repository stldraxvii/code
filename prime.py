from factors import list_factors

def find_primes(num):
    factors = list_factors(num)
    primes = []
    for j in factors:
        if factors[j] == 'Prime':
            primes.append(j)
    return primes

def main():
    num = input("Enter a number:")
    num = int(num)
    print(find_primes(num))

if __name__ == '__main__':
    main()
