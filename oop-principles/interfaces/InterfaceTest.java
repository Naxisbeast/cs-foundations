package interfaces;

public class InterfaceTest {
    public static void main(String[] args) {
        Reportable report = new AcademicReport("Lerato Maseko", "Object-Oriented Programming", 76.5);

        System.out.println(report.generateReport());
        System.out.println();
        System.out.println("Report title: " + report.getReportTitle());
    }
}
