package interfaces;

public class AcademicReport implements Reportable {
    private String studentName;
    private String moduleName;
    private double mark;

    public AcademicReport(String studentName, String moduleName, double mark) {
        this.studentName = studentName;
        this.moduleName = moduleName;
        setMark(mark);
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        if (mark < 0) {
            this.mark = 0;
            return;
        }

        if (mark > 100) {
            this.mark = 100;
            return;
        }

        this.mark = mark;
    }

    public String calculateResult() {
        return mark >= 50 ? "Pass" : "Fail";
    }

    @Override
    public String getReportTitle() {
        return "Academic Progress Report";
    }

    @Override
    public String generateReport() {
        return getReportTitle()
                + "\nStudent: " + studentName
                + "\nModule: " + moduleName
                + "\nMark: " + mark
                + "\nResult: " + calculateResult();
    }

    @Override
    public String toString() {
        return "AcademicReport{studentName='" + studentName + "', moduleName='"
                + moduleName + "', mark=" + mark + ", result='" + calculateResult() + "'}";
    }
}
