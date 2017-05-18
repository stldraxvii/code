def list_factors(num):
    factors = {}
    for i in range(1,num+1):
        factors[i] = []
    for j in factors:
        for x in range(1,j+1):
            if j%x == 0:
                factors[j].append(x)
        if len(factors[j]) <= 2:
            factors[j] = 'Prime'
    return factors

def main():
    num = input("Enter a number:")
    num = int(num)
    print(list_factors(num))

if __name__ == '__main__':
    main()
