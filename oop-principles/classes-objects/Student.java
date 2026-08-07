package classes_objects;

public class Student {
    private String name;
    private String courseName;
    private int yearOfStudy;

    public Student(String name, String courseName, int yearOfStudy) {
        this.name = name;
        this.courseName = courseName;
        setYearOfStudy(yearOfStudy);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(int yearOfStudy) {
        if (yearOfStudy < 1) {
            System.out.println("Year of study must be at least 1. I will keep it as 1.");
            this.yearOfStudy = 1;
            return;
        }

        this.yearOfStudy = yearOfStudy;
    }

    public void displayStudentInfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', courseName='" + courseName + "', yearOfStudy=" + yearOfStudy + "}";
    }
}
