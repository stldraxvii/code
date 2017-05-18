def bubble_sort(lst):
    is_sorted = False
    while is_sorted is False:
        nswaps = 0
        for i in range(len(lst)):
            if i < (len(lst)-1):
                if lst[i] > lst[i+1]:
                    lst.insert(i,lst[i+1])
                    del lst[i+2]
                    nswaps = nswaps+1
        if nswaps == 0:
            is_sorted = True
    return lst

def main():
    string = input("Gimme a list!")
    lst = string.split()
    lst = [int(a) for a in lst]
    sorted_list = bubble_sort(lst)
    print(sorted_list)

if __name__ == '__main__':
    main()
