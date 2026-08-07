public class Patient implements Comparable<Patient> {
    private static int nextId = 1;
    private final int id;
    private final String name;
    private final boolean emergency;

    public Patient(String name, boolean emergency) {
        this.id = nextId++;
        this.name = name;
        this.emergency = emergency;
    }

    public String getName() { return name; }
    public boolean isEmergency() { return emergency; }
    public int getId() { return id; }

    @Override
    public String toString() {
        return name + " (ID:" + id + (emergency ? ", EMERGENCY" : "") + ")";
    }

    @Override
    public int compareTo(Patient other) {
        return Integer.compare(this.id, other.id);
    }
}
