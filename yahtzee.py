import random

def rollDice(num_dice, num_rolls):
    # create a two-dimensional (num_dice by num_rolls) of zeros
    double_list = [[0 for i in range(num_dice)] for j in range(num_rolls)]
    # loop through each row and column, filling it with a random roll
    for roll in range(0, len(double_list)):
      for die in range(0, len(double_list[roll])):
          double_list[roll][die] = (int)(random.random()*6 + 1)
    return double_list


def sumOfRoll(double_list):
    sum_list = [0 for i in range(len(double_list))]
    for i in range(len(double_list)):
        sum = 0
        for j in double_list[i]:
            sum = sum + j
        sum_list[i] = sum
    return sum_list


def yahtzee(double_list):
    yahtzees = 0
    for x in range(len(double_list)):
        sameness = True
        count = 0
        for y in range(len(double_list[x])):
            count = count + double_list[x][y]
            if y > 0:
                if count/(y+1) != double_list[x][y]:
                    sameness = False
                    break
        if sameness == True:
            yahtzees = yahtzees + 1
    return yahtzees


def main():
    dice = int(input("How many dice are you rolling?"))
    rolls = int(input("How many times are you rolling the dice?"))
    list = rollDice(dice, rolls)
    print(list)
    print("Sum of roll:", sumOfRoll(list))
    print("Number of yahtzees:", yahtzee(list))

if __name__ == "__main__":
    main()
