#include <iomanip>
#include <iostream>
#include <limits>
#include <string>

using namespace std;

int main() {
    string studentName;
    string programmeName;
    int yearOfStudy;
    double averageMark;

    cout << "Student Profile Example" << endl;
    cout << "Enter a fictional student name: ";
    getline(cin, studentName);

    cout << "Enter a programme name: ";
    getline(cin, programmeName);

    cout << "Enter year of study: ";
    cin >> yearOfStudy;

    if (cin.fail() || yearOfStudy < 1) {
        cin.clear();
        cin.ignore(numeric_limits<streamsize>::max(), '\n');
        cout << "Invalid year. I will use year 1 for this example." << endl;
        yearOfStudy = 1;
    }

    cout << "Enter average mark: ";
    cin >> averageMark;

    if (cin.fail() || averageMark < 0 || averageMark > 100) {
        cin.clear();
        cin.ignore(numeric_limits<streamsize>::max(), '\n');
        cout << "Invalid mark. I will use 0 for this example." << endl;
        averageMark = 0;
    }

    cout << endl;
    cout << "Profile Summary" << endl;
    cout << "Name: " << studentName << endl;
    cout << "Programme: " << programmeName << endl;
    cout << "Year of study: " << yearOfStudy << endl;
    cout << fixed << setprecision(2);
    cout << "Average mark: " << averageMark << "%" << endl;

    return 0;
}
