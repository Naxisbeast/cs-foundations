# Structured Programming

## What Is Structured Programming?

Structured programming is a way of writing programs using clear steps, decisions, loops, and functions.

The goal is to make programs easier to read, test, and understand.

## Sequence

Sequence means instructions run in order from top to bottom.

```cpp
cout << "Enter a number: ";
cin >> number;
cout << "You entered: " << number;
```

## Selection

Selection means the program chooses between different paths.

```cpp
if (mark >= 50) {
    cout << "Pass";
} else {
    cout << "Fail";
}
```

## Iteration

Iteration means repeating a block of code using a loop.

```cpp
for (int number = 1; number <= 5; number++) {
    cout << number << endl;
}
```

## Modularity

Modularity means breaking a program into smaller functions.

Functions help because they:

- Reduce repeated code
- Make programs easier to read
- Make testing smaller parts easier
- Give each part of the program a clear purpose

## Why Functions Matter

Functions are important in structured programming because they keep the program organised without needing object-oriented design.

In this repository, examples such as the calculator and library menu use functions to split the program into smaller steps.
