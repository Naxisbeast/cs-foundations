#include <iostream>
#include <limits>

using namespace std;

int main() {
    int tableNumber;

    cout << "Multiplication Table" << endl;
    cout << "Enter a positive whole number: ";
    cin >> tableNumber;

    if (cin.fail() || tableNumber <= 0) {
        cout << "Invalid input. I will use 5 for this example." << endl;
        tableNumber = 5;
    }

    cout << endl;
    cout << "Using a for loop:" << endl;
    for (int multiplier = 1; multiplier <= 10; multiplier++) {
        cout << tableNumber << " x " << multiplier << " = " << tableNumber * multiplier << endl;
    }

    cout << endl;
    cout << "Using a while loop:" << endl;
    int multiplier = 1;
    while (multiplier <= 5) {
        cout << tableNumber << " x " << multiplier << " = " << tableNumber * multiplier << endl;
        multiplier++;
    }

    return 0;
}
