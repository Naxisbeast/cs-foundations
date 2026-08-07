public class TestHospitalER {
    public static void main(String[] args) {
        HospitalERSystem er = new HospitalERSystem();

        // admit normal patients
        er.admitPatient("John", false);
        er.admitPatient("Alice", false);
        er.displayStatus();
        System.out.println();

        // admit an emergency
        er.admitPatient("Chris", true);
        er.displayStatus();
        System.out.println();

        // treat two patients
        er.treatPatient(); // should treat Chris (emergency)
        er.treatPatient(); // should treat John (next)
        er.displayStatus();
        System.out.println();

        // undo last treatment (John)
        er.undoLastTreatment();
        er.displayStatus();
        System.out.println();

        // treat remaining patients until empty
        while (!er.queueEmpty()) {
            er.treatPatient();
        }
        er.displayStatus();
        System.out.println();

        // attempt to treat when empty
        er.treatPatient();

        // attempt to undo when there may still be treatments to undo
        System.out.println();
        // undo all treatments in stack one by one
        while (!er.stackEmpty()) {
            er.undoLastTreatment();
        }
        // now stack empty, try undo again
        er.undoLastTreatment();
    }
}
