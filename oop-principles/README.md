# Object-Oriented Programming — Java

One worked example per OOP principle. Each has a `*Test.java` runner that shows the principle in use.

| Principle | Example |
|---|---|
| Classes & objects | `Student` with validation on year of study |
| Encapsulation | `BankAccount` keeps `balance` private; `deposit`/`withdraw` guard invalid amounts |
| Inheritance | `Person` → `StudentPerson`, `Lecturer` |
| Polymorphism | `Payment` → `CardPayment`, `CashPayment` — one reference type, different behaviour |
| Abstraction | `Vehicle` → `Car`, `Motorcycle` |
| Interfaces | `Reportable` implemented by `AcademicReport` |

## Run

Compile a principle folder and run its test class, e.g. polymorphism:

```bash
javac -d out oop-principles/polymorphism/Payment.java oop-principles/polymorphism/CardPayment.java oop-principles/polymorphism/CashPayment.java oop-principles/polymorphism/PaymentTest.java
java -cp out polymorphism.PaymentTest
```

The same pattern applies to the other folders (`encapsulation.BankAccountTest`, `inheritance.InheritanceTest`, `abstraction.VehicleTest`, `interfaces.InterfaceTest`, `classes_objects.StudentTest`).

## Notes

- The principle each example demonstrates is explained in [`notes/oop-principles.md`](../notes/oop-principles.md).
- These `*Test.java` files print demo output — they demonstrate each principle rather than asserting behaviour. Assertion-based tests are a planned addition.
