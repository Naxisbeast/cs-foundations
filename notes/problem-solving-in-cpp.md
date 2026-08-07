# Problem Solving In C++

## My Beginner C++ Problem-Solving Approach

When solving a C++ problem, I try to understand the task before typing code.

## 1. Understand The Problem

I first rewrite the task in simple words.

Example: "The program must classify a number as positive, negative, or zero."

## 2. Identify Inputs

Inputs are the values the program needs from the user or from a fixed dataset.

Examples:

- A number to classify
- A mark to analyse
- A menu option

## 3. Identify Outputs

Outputs are what the program should display.

Examples:

- A classification result
- An average mark
- A list of available books

## 4. Break The Task Into Steps

I split the problem into smaller actions:

1. Get input.
2. Validate input.
3. Process the value.
4. Display the result.

## 5. Write Pseudocode

Pseudocode helps me plan before writing C++ syntax.

```text
Ask for number
If number is greater than zero, print positive
Else if number is less than zero, print negative
Else print zero
Check whether the number is even or odd
```

## 6. Test Normal Cases

Normal cases are expected inputs, such as:

- A positive number
- A passing mark
- A valid menu choice

## 7. Test Edge Cases

Edge cases are values that may expose mistakes:

- Zero
- Negative numbers
- Very large numbers
- Invalid input
- Empty arrays
- Trying to borrow a book that is already borrowed

## C++ Input Issues To Remember

C++ input can fail if the user types text when the program expects a number. For beginner examples, I use simple checks with `cin.fail()` where useful.
