#include <iostream>
#include <limits>

using namespace std;

int main() {
    int number;

    cout << "Number Classifier" << endl;
    cout << "Enter a whole number: ";
    cin >> number;

    if (cin.fail()) {
        cout << "Invalid input. Please enter a whole number next time." << endl;
        return 1;
    }

    if (number > 0) {
        cout << "The number is positive." << endl;
    } else if (number < 0) {
        cout << "The number is negative." << endl;
    } else {
        cout << "The number is zero." << endl;
    }

    if (number == 0) {
        cout << "Zero is neither odd nor even in this beginner example." << endl;
    } else if (number % 2 == 0) {
        cout << "The number is even." << endl;
    } else {
        cout << "The number is odd." << endl;
    }

    return 0;
}
