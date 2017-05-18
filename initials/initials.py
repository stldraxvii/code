def get_initials(fullname):
    t = fullname.count(" ")
    initials = ""
    for i in range (t+1):
        n = fullname.find(" ")
        name = fullname[:n]
        first = name[0]
        initials = initials + first
        fullname = fullname[n+1:]
        initials = initials.upper()
    return initials

def main():
    fullname = input("What is your full name?")
    x = get_initials(fullname)
    print (x)

if __name__ == '__main__':
    main()
