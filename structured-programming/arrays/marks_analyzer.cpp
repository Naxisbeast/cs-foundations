#include <iostream>

using namespace std;

double calculateAverage(const int marks[], int size) {
    int total = 0;

    for (int index = 0; index < size; index++) {
        total += marks[index];
    }

    return static_cast<double>(total) / size;
}

int findHighestMark(const int marks[], int size) {
    int highest = marks[0];

    for (int index = 1; index < size; index++) {
        if (marks[index] > highest) {
            highest = marks[index];
        }
    }

    return highest;
}

int findLowestMark(const int marks[], int size) {
    int lowest = marks[0];

    for (int index = 1; index < size; index++) {
        if (marks[index] < lowest) {
            lowest = marks[index];
        }
    }

    return lowest;
}

void countPassesAndFails(const int marks[], int size, int &passCount, int &failCount) {
    passCount = 0;
    failCount = 0;

    for (int index = 0; index < size; index++) {
        if (marks[index] >= 50) {
            passCount++;
        } else {
            failCount++;
        }
    }
}

int main() {
    const int size = 6;
    int marks[size] = {72, 48, 65, 81, 39, 90};
    int passCount;
    int failCount;

    cout << "Marks Analyzer" << endl;
    cout << "Marks: ";
    for (int index = 0; index < size; index++) {
        cout << marks[index] << " ";
    }
    cout << endl;

    countPassesAndFails(marks, size, passCount, failCount);

    cout << "Average mark: " << calculateAverage(marks, size) << endl;
    cout << "Highest mark: " << findHighestMark(marks, size) << endl;
    cout << "Lowest mark: " << findLowestMark(marks, size) << endl;
    cout << "Pass count: " << passCount << endl;
    cout << "Fail count: " << failCount << endl;

    return 0;
}
