def print_numbers_with_for_loop():
    print("Numbers from 1 to 5 using a for loop:")
    for number in range(1, 6):
        print(number)


def print_countdown_with_while_loop():
    print("Countdown from 5 using a while loop:")
    number = 5
    while number >= 1:
        print(number)
        number -= 1


def print_triangle_pattern(rows):
    print("Simple triangle pattern:")
    for row in range(1, rows + 1):
        for column in range(row):
            print("*", end="")
        print()


def run_number_patterns():
    print_numbers_with_for_loop()
    print()
    print_countdown_with_while_loop()
    print()
    print_triangle_pattern(5)


if __name__ == "__main__":
    run_number_patterns()
