"""Hangman - guess the word before you run out of lives.

Small, fun, and it exercises a few fundamentals at once: sets for the
guessed letters, list/string traversal to render the word, and a while
loop for the game loop. The words are all CS vocabulary on purpose.
"""

import random

WORDS = ["python", "java", "stack", "queue", "recursion", "binary",
         "pointer", "compile", "inference"]


def choose_word():
    return random.choice(WORDS)


def render(word, guessed):
    return " ".join(letter if letter in guessed else "_" for letter in word)


def main():
    word = choose_word()
    guessed = set()
    lives = 6
    print("Hangman - guess the word, one letter at a time.")

    while lives > 0:
        print("\n" + render(word, guessed))
        print(f"Lives left: {lives}  Guessed: {sorted(guessed)}")

        guess = input("Letter: ").strip().lower()
        if len(guess) != 1 or not guess.isalpha():
            print("One letter at a time.")
            continue
        if guess in guessed:
            print("Already guessed that one.")
            continue

        guessed.add(guess)
        if guess in word:
            print("Correct!")
            if all(letter in guessed for letter in word):
                print(f"\n{render(word, guessed)}\nYou won - the word was {word}!")
                return
        else:
            lives -= 1
            print("Nope.")

    print(f"\nGame over. The word was {word}.")


if __name__ == "__main__":
    main()
