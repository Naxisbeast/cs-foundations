package classes_objects;

public class StudentTest {
    public static void main(String[] args) {
        Student firstStudent = new Student("Karabo Mokoena", "Computer Science", 1);
        Student secondStudent = new Student("Lebo Nkosi", "Electronics", 2);

        firstStudent.displayStudentInfo();
        secondStudent.displayStudentInfo();

        secondStudent.setYearOfStudy(3);
        System.out.println("Updated second student: " + secondStudent);

        System.out.println("First student course: " + firstStudent.getCourseName());
    }
}
