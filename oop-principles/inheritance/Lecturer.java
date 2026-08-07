package inheritance;

public class Lecturer extends Person {
    private String departmentName;
    private String moduleName;

    public Lecturer(String fullName, int age, String departmentName, String moduleName) {
        super(fullName, age);
        this.departmentName = departmentName;
        this.moduleName = moduleName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    @Override
    public void introduce() {
        System.out.println("Good day, I am " + getFullName() + " and I teach " + moduleName + ".");
    }

    @Override
    public String toString() {
        return "Lecturer{fullName='" + getFullName() + "', age=" + getAge()
                + ", departmentName='" + departmentName + "', moduleName='" + moduleName + "'}";
    }
}
