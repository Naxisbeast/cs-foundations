def show_menu():
    print()
    print("Simple Banking Menu")
    print("1. Deposit")
    print("2. Withdraw")
    print("3. Check balance")
    print("4. Exit")


def read_amount(prompt):
    amount_text = input(prompt).strip()

    try:
        amount = float(amount_text)
    except ValueError:
        print("Invalid amount. Please enter a number.")
        return None

    if amount <= 0:
        print("Amount must be greater than zero.")
        return None

    return amount


def run_simple_banking_menu():
    balance = 500.00
    running = True

    while running:
        show_menu()
        choice = input("Choose an option: ").strip()

        if choice == "1":
            amount = read_amount("Enter deposit amount: ")
            if amount is not None:
                balance += amount
                print("Deposit successful. New balance: R", round(balance, 2))

        elif choice == "2":
            amount = read_amount("Enter withdrawal amount: ")
            if amount is not None:
                # I check the balance before allowing a withdrawal.
                if amount > balance:
                    print("Withdrawal declined. You cannot withdraw more than the balance.")
                else:
                    balance -= amount
                    print("Withdrawal successful. New balance: R", round(balance, 2))

        elif choice == "3":
            print("Current balance: R", round(balance, 2))

        elif choice == "4":
            print("Goodbye.")
            running = False

        else:
            print("Invalid option. Please choose 1, 2, 3, or 4.")


if __name__ == "__main__":
    run_simple_banking_menu()
