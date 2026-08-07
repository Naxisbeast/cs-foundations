#include <iostream>
#include <limits>
#include <string>

using namespace std;

struct Book {
    int id;
    string title;
    bool isBorrowed;
};

void displayMenu() {
    cout << endl;
    cout << "Library Menu System" << endl;
    cout << "1. Display books" << endl;
    cout << "2. Borrow book" << endl;
    cout << "3. Return book" << endl;
    cout << "4. Exit" << endl;
}

void displayBooks(const Book books[], int size) {
    cout << endl;
    cout << "Book List" << endl;
    for (int index = 0; index < size; index++) {
        cout << books[index].id << ". " << books[index].title << " - ";
        cout << (books[index].isBorrowed ? "Borrowed" : "Available") << endl;
    }
}

int findBookIndexById(const Book books[], int size, int bookId) {
    for (int index = 0; index < size; index++) {
        if (books[index].id == bookId) {
            return index;
        }
    }

    return -1;
}

int readBookId() {
    int bookId;
    cout << "Enter book ID: ";
    cin >> bookId;

    if (cin.fail()) {
        cin.clear();
        cin.ignore(numeric_limits<streamsize>::max(), '\n');
        return -1;
    }

    return bookId;
}

void borrowBook(Book books[], int size) {
    int bookId = readBookId();
    int bookIndex = findBookIndexById(books, size, bookId);

    if (bookIndex == -1) {
        cout << "Book not found." << endl;
        return;
    }

    if (books[bookIndex].isBorrowed) {
        cout << "This book is already borrowed." << endl;
        return;
    }

    books[bookIndex].isBorrowed = true;
    cout << "Book borrowed successfully." << endl;
}

void returnBook(Book books[], int size) {
    int bookId = readBookId();
    int bookIndex = findBookIndexById(books, size, bookId);

    if (bookIndex == -1) {
        cout << "Book not found." << endl;
        return;
    }

    if (!books[bookIndex].isBorrowed) {
        cout << "This book was not borrowed." << endl;
        return;
    }

    books[bookIndex].isBorrowed = false;
    cout << "Book returned successfully." << endl;
}

int main() {
    const int size = 4;
    Book books[size] = {
        {1, "Programming Basics", false},
        {2, "Digital Logic Notes", false},
        {3, "Introduction To Databases", true},
        {4, "Problem Solving With C++", false}
    };

    bool running = true;

    while (running) {
        int choice;
        displayMenu();
        cout << "Choose an option: ";
        cin >> choice;

        if (cin.fail()) {
            cin.clear();
            cin.ignore(numeric_limits<streamsize>::max(), '\n');
            cout << "Invalid option. Please enter a number." << endl;
            continue;
        }

        if (choice == 1) {
            displayBooks(books, size);
        } else if (choice == 2) {
            borrowBook(books, size);
        } else if (choice == 3) {
            returnBook(books, size);
        } else if (choice == 4) {
            cout << "Goodbye." << endl;
            running = false;
        } else {
            cout << "Invalid option. Please choose 1, 2, 3, or 4." << endl;
        }
    }

    return 0;
}
