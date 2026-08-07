public class HospitalERSystem {
    private QueueAsMyLinkedList<Patient> patientQueue;
    private StackAsMyLinkedList<Patient> treatmentHistory;

    public HospitalERSystem() {
        patientQueue = new QueueAsMyLinkedList<>();
        treatmentHistory = new StackAsMyLinkedList<>();
    }

    // admit a patient
    public void admitPatient(String name, boolean emergency) {
        Patient p = new Patient(name, emergency);
        if (emergency) {
            patientQueue.enqueuePriority(p);
            System.out.println("Admitted (PRIORITY): " + p);
        } else {
            patientQueue.enqueue(p);
            System.out.println("Admitted: " + p);
        }
    }

    // treat the next patient (dequeue -> push on stack)
    public Patient treatPatient() {
        if (patientQueue.isEmpty()) {
            System.out.println("No patients to treat.");
            return null;
        }
        Patient p = patientQueue.dequeue();
        if (p != null) {
            treatmentHistory.push(p);
            System.out.println("Treated: " + p);
            return p;
        } else {
            System.out.println("Failed to dequeue patient.");
            return null;
        }
    }

    // undo the last treatment (pop -> re-admit as priority)
    public Patient undoLastTreatment() {
        if (treatmentHistory.isEmpty()) {
            System.out.println("No treatment to undo.");
            return null;
        }
        Patient p = treatmentHistory.pop();
        if (p != null) {
            // put patient back at front so they can be treated again quickly
            patientQueue.enqueuePriority(p);
            System.out.println("Undid treatment for: " + p);
            return p;
        } else {
            System.out.println("Failed to undo last treatment.");
            return null;
        }
    }

    // show status
    public void displayStatus() {
        System.out.println("Current queue: " + patientQueue.toString());
        System.out.println("Treatment history (stack): " + treatmentHistory.toString());
        System.out.println("Queue size: " + patientQueue.size() + " | Stack size: " + treatmentHistory.size());
    }

    // convenience getters used in tests
    public boolean queueEmpty() { return patientQueue.isEmpty(); }
    public boolean stackEmpty() { return treatmentHistory.isEmpty(); }
}
