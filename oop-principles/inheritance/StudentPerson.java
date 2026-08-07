package inheritance;

public class StudentPerson extends Person {
    private String courseName;
    private int yearOfStudy;

    public StudentPerson(String fullName, int age, String courseName, int yearOfStudy) {
        super(fullName, age);
        this.courseName = courseName;
        this.yearOfStudy = yearOfStudy;
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
        this.yearOfStudy = yearOfStudy;
    }

    @Override
    public void introduce() {
        System.out.println("Hi, my name is " + getFullName() + " and I study " + courseName + ".");
    }

    @Override
    public String toString() {
        return "StudentPerson{fullName='" + getFullName() + "', age=" + getAge()
                + ", courseName='" + courseName + "', yearOfStudy=" + yearOfStudy + "}";
    }
}
