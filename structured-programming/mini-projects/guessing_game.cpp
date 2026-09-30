// Number guessing game with session stats - loops, conditionals, functions,
// and cin validation. Tracks how many guesses each round took and a running
// average, so it is a little bit of state sitting on top of the game loop.
#include <cstdlib>
#include <ctime>
#include <iostream>
#include <limits>
#include <string>

using namespace std;

int playRound(int target) {
    int guesses = 0;
    while (true) {
        int guess;
        cout << "Guess the number (1-100): ";
        cin >> guess;

        if (cin.fail()) {
            cin.clear();
            cin.ignore(numeric_limits<streamsize>::max(), '\n');
            cout << "Enter a number." << endl;
            continue;
        }

        guesses++;
        if (guess < target) {
            cout << "Higher." << endl;
        } else if (guess > target) {
            cout << "Lower." << endl;
        } else {
            return guesses;
        }
    }
}

int main() {
    srand(static_cast<unsigned>(time(nullptr)));

    int rounds = 0;
    int totalGuesses = 0;
    bool playing = true;

    cout << "Number Guessing Game" << endl;

    while (playing) {
        int target = rand() % 100 + 1;
        int guesses = playRound(target);
        rounds++;
        totalGuesses += guesses;

        cout << "Correct! It took you " << guesses << " guesses." << endl;
        cout << "Average guesses per round so far: " << (totalGuesses / rounds) << endl;

        cout << "Play again? (y/n): ";
        string answer;
        cin >> answer;
        if (answer != "y" && answer != "Y") {
            playing = false;
        }
    }

    cout << "Played " << rounds << " rounds with " << totalGuesses
         << " total guesses. Goodbye!" << endl;
    return 0;
}
