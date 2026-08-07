package inheritance;

public class InheritanceTest {
    public static void main(String[] args) {
        Person generalPerson = new Person("Naledi Khumalo", 28);
        StudentPerson student = new StudentPerson("Sizwe Maseko", 20, "Computer Science", 2);
        Lecturer lecturer = new Lecturer("Dr. Anita Naidoo", 42, "Computer Science", "Object-Oriented Programming");

        generalPerson.introduce();
        student.introduce();
        lecturer.introduce();

        System.out.println(generalPerson);
        System.out.println(student);
        System.out.println(lecturer);
    }
}
