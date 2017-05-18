def count_chars(text):
    letter_count = {}
    for char in text:
        if char in letter_count:
            letter_count[char] = letter_count[char]+1
        else:
            letter_count[char] = 1
    return letter_count


def main():
    text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc accumsan sem ut ligula scelerisque sollicitudin. Ut at sagittis augue. Praesent quis rhoncus justo. Aliquam erat volutpat. Donec sit amet suscipit metus, non lobortis massa. Vestibulum augue ex, dapibus ac suscipit vel, volutpat eget massa. Donec nec velit non ligula efficitur luctus."
    x = count_chars(text)
    print(x)

if __name__ == '__main__':
    main()
