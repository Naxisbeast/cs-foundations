#include <iostream>
#include <string>

using namespace std;

struct StudentRecord {
    string name;
    string programme;
    int yearOfStudy;
    double averageMark;
};

void displayStudent(const StudentRecord &student) {
    cout << "Name: " << student.name << endl;
    cout << "Programme: " << student.programme << endl;
    cout << "Year: " << student.yearOfStudy << endl;
    cout << "Average mark: " << student.averageMark << "%" << endl;
}

void displayAllStudents(const StudentRecord students[], int size) {
    for (int index = 0; index < size; index++) {
        cout << endl;
        cout << "Student " << index + 1 << endl;
        displayStudent(students[index]);
    }
}

double calculateClassAverage(const StudentRecord students[], int size) {
    double total = 0;

    for (int index = 0; index < size; index++) {
        total += students[index].averageMark;
    }

    return total / size;
}

int main() {
    const int size = 3;
    StudentRecord students[size] = {
        {"Amo Mokoena", "Computer Science", 1, 72.5},
        {"Lebo Nkosi", "Electronics", 2, 68.0},
        {"Mila Jacobs", "Information Systems", 1, 81.5}
    };

    cout << "Student Record System" << endl;
    displayAllStudents(students, size);

    cout << endl;
    cout << "Class average: " << calculateClassAverage(students, size) << "%" << endl;

    return 0;
}
