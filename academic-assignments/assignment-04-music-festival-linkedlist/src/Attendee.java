class Attendee implements Comparable<Attendee> {
    private String idNumber;
    private String name;
    private String surname;
    private String contactNumber;
    private String email;
    private String seatNumber;
    private String prize;

    public Attendee(String idNumber, String name, String surname,
                    String contactNumber, String email, String seatNumber) {
        this.idNumber = idNumber;
        this.name = name;
        this.surname = surname;
        this.contactNumber = contactNumber;
        this.email = email;
        this.seatNumber = seatNumber;
        this.prize = "None";
    }

    public String getIdNumber() { return idNumber; }
    public String getName() { return name; }
    public String getSurname() { return surname; }
    public String getContactNumber() { return contactNumber; }
    public String getEmail() { return email; }
    public String getSeatNumber() { return seatNumber; }
    public String getPrize() { return prize; }
    public void setPrize(String prize) { this.prize = prize; }

    @Override
    public String toString() {
        return String.format("%s, %s (ID: %s, Contact: %s, Email: %s, Seat: %s, Prize: %s)",
                surname, name, idNumber, contactNumber, email, seatNumber, prize);
    }

    @Override
    public int compareTo(Attendee other) {
        // Compare by ID number for the delete method to work
        return this.idNumber.compareTo(other.idNumber);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Attendee)) return false;
        Attendee other = (Attendee) obj;
        return this.idNumber.equals(other.idNumber);
    }

    @Override
    public int hashCode() {
        // Consistent with equals: equality is based on idNumber.
        return idNumber.hashCode();
    }
}