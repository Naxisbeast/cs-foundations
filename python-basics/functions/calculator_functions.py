def add_numbers(first_number, second_number):
    return first_number + second_number


def subtract_numbers(first_number, second_number):
    return first_number - second_number


def multiply_numbers(first_number, second_number):
    return first_number * second_number


def divide_numbers(first_number, second_number):
    if second_number == 0:
        return None
    return first_number / second_number


def run_calculator_examples():
    first_number = 12
    second_number = 4

    print("Calculator Function Examples")
    print("First number:", first_number)
    print("Second number:", second_number)
    print("Addition:", add_numbers(first_number, second_number))
    print("Subtraction:", subtract_numbers(first_number, second_number))
    print("Multiplication:", multiply_numbers(first_number, second_number))

    division_result = divide_numbers(first_number, second_number)
    if division_result is None:
        print("Division: cannot divide by zero")
    else:
        print("Division:", division_result)


if __name__ == "__main__":
    run_calculator_examples()
