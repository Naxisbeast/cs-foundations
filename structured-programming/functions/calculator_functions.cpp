#include <iostream>

using namespace std;

double addNumbers(double firstNumber, double secondNumber) {
    return firstNumber + secondNumber;
}

double subtractNumbers(double firstNumber, double secondNumber) {
    return firstNumber - secondNumber;
}

double multiplyNumbers(double firstNumber, double secondNumber) {
    return firstNumber * secondNumber;
}

bool divideNumbers(double firstNumber, double secondNumber, double &result) {
    if (secondNumber == 0) {
        return false;
    }

    result = firstNumber / secondNumber;
    return true;
}

int main() {
    double firstNumber = 12;
    double secondNumber = 4;
    double divisionResult;

    cout << "Calculator Function Examples" << endl;
    cout << "First number: " << firstNumber << endl;
    cout << "Second number: " << secondNumber << endl;
    cout << "Addition: " << addNumbers(firstNumber, secondNumber) << endl;
    cout << "Subtraction: " << subtractNumbers(firstNumber, secondNumber) << endl;
    cout << "Multiplication: " << multiplyNumbers(firstNumber, secondNumber) << endl;

    if (divideNumbers(firstNumber, secondNumber, divisionResult)) {
        cout << "Division: " << divisionResult << endl;
    } else {
        cout << "Division failed because division by zero is not allowed." << endl;
    }

    return 0;
}
