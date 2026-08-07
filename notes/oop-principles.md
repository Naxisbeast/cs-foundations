# OOP Principles

## Overview

Object-Oriented Programming is a way to structure programs around objects. An object can store data and perform actions through methods.

In Java, OOP helps keep code organised by grouping related fields and methods inside classes.

## Encapsulation

Encapsulation means keeping data protected inside a class and controlling access through methods.

In this repository, `BankAccount` demonstrates encapsulation by keeping `balance` private and only changing it through `deposit` and `withdraw`.

```java
private double balance;

public double getBalance() {
    return balance;
}
```

This helps prevent invalid changes, such as withdrawing more money than the account has.

## Inheritance

Inheritance means one class can reuse and extend another class.

In this repository:

- `Person` is the superclass.
- `StudentPerson` and `Lecturer` are subclasses.

The subclasses reuse common fields such as `fullName` and `age`, then add their own fields.

```java
public class StudentPerson extends Person {
    // StudentPerson inherits from Person.
}
```

## Polymorphism

Polymorphism means the same method call can behave differently depending on the object.

In this repository, `Payment` is an abstract superclass. `CardPayment` and `CashPayment` override `processPayment`.

```java
Payment payment = new CardPayment(250.00, "1234");
payment.processPayment();
```

Even though the reference type is `Payment`, Java runs the `CardPayment` version of the method.

## Method Overloading

Method overloading happens when a class has methods with the same name but different parameters.

The `Payment` class has two `printReceipt` methods to demonstrate this.

## Abstraction

Abstraction means focusing on what an object should do without exposing every detail immediately.

In this repository, `Vehicle` is an abstract class. It defines methods such as `startEngine` and `describeMovement`, but each subclass decides how to implement them.

## Interfaces

An interface defines behaviour that a class promises to implement.

In this repository:

- `Reportable` is an interface.
- `AcademicReport` implements it.

This means `AcademicReport` must provide methods such as `generateReport` and `getReportTitle`.

## Summary Table

| Concept | Meaning | Repo Example |
|---|---|---|
| Encapsulation | Protecting data inside a class | `BankAccount` |
| Inheritance | Reusing superclass behaviour | `Person`, `StudentPerson`, `Lecturer` |
| Polymorphism | Same method call, different behaviour | `Payment`, `CardPayment`, `CashPayment` |
| Abstraction | Hiding details behind required behaviour | `Vehicle`, `Car`, `Motorcycle` |
| Interface | Contract that a class implements | `Reportable`, `AcademicReport` |
