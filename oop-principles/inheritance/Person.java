package inheritance;

public class Person {
    private String fullName;
    private int age;

    public Person(String fullName, int age) {
        this.fullName = fullName;
        setAge(age);
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) {
            System.out.println("Age cannot be negative. I will store it as 0.");
            this.age = 0;
            return;
        }

        this.age = age;
    }

    public void introduce() {
        System.out.println("Hi, my name is " + fullName + ".");
    }

    @Override
    public String toString() {
        return "Person{fullName='" + fullName + "', age=" + age + "}";
    }
}
