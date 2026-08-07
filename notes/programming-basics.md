# Programming Basics

## Variables

A variable stores a value so the program can use it later.

```python
student_name = "Thapelo"
age = 20
```

## Input And Output

`input()` reads text from the user. `print()` displays output.

```python
name = input("Enter your name: ")
print("Hello", name)
```

## Type Conversion

Input is read as text, so numbers often need conversion.

```python
age = int(input("Enter your age: "))
```

## Conditionals

Conditionals help a program make decisions.

```python
if mark >= 50:
    print("Pass")
else:
    print("Fail")
```

## Loops

Loops repeat work.

```python
for number in range(1, 6):
    print(number)
```

## Functions

Functions group reusable logic.

```python
def add_numbers(first_number, second_number):
    return first_number + second_number
```

## Lists

Lists store multiple values.

```python
marks = [65, 72, 80]
```

## Files

Programs can read data from files. File handling should include error checks because the file may not exist.
