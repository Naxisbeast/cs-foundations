// Inventory manager - structs, arrays, search, and a low-stock report.
// Finding an item by id is a linear search, which is what an unsorted
// array costs (O(n)); the low-stock report is just a filter over the
// array. Small, but it puts the structured-programming ideas together.
#include <iostream>
#include <string>

using namespace std;

struct Item {
    int id;
    string name;
    int quantity;
};

void displayInventory(const Item items[], int size) {
    cout << endl << "Inventory:" << endl;
    for (int index = 0; index < size; index++) {
        cout << items[index].id << ". " << items[index].name
             << " - " << items[index].quantity << " in stock" << endl;
    }
}

void findItem(const Item items[], int size, int id) {
    for (int index = 0; index < size; index++) {
        if (items[index].id == id) {
            cout << "Found: " << items[index].name
                 << " (" << items[index].quantity << " in stock)" << endl;
            return;
        }
    }
    cout << "Item " << id << " not found." << endl;
}

void lowStockReport(const Item items[], int size, int threshold) {
    cout << endl << "Low stock (below " << threshold << "):" << endl;
    bool any = false;
    for (int index = 0; index < size; index++) {
        if (items[index].quantity < threshold) {
            cout << "  " << items[index].name
                 << " - " << items[index].quantity << endl;
            any = true;
        }
    }
    if (!any) {
        cout << "  None." << endl;
    }
}

int main() {
    const int size = 5;
    Item items[size] = {
        {1, "Laptop", 12},
        {2, "Mouse", 3},
        {3, "Keyboard", 5},
        {4, "USB Cable", 0},
        {5, "Monitor", 8}
    };

    cout << "Inventory System" << endl;
    displayInventory(items, size);
    findItem(items, size, 3);
    findItem(items, size, 99);
    lowStockReport(items, size, 5);
    return 0;
}
