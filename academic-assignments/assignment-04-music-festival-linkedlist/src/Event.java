class Event {
    private String eventID;
    private String date;
    private String location;
    private String stage;
    private int maxTickets;
    private int attendeeCount;
    private MyLinkedList<Attendee> attendees;

    public Event(String eventID, String date, String location, String stage, int maxTickets) {
        this.eventID = eventID;
        this.date = date;
        this.location = location;
        this.stage = stage;
        this.maxTickets = maxTickets;
        this.attendeeCount = 0;
        this.attendees = new MyLinkedList<>();
    }

    public String getEventID() { return eventID; }
    public String getDate() { return date; }
    public String getLocation() { return location; }
    public String getStage() { return stage; }
    public int getMaxTickets() { return maxTickets; }
    public int getAttendeeCount() { return attendeeCount; }
    public MyLinkedList<Attendee> getAttendees() { return attendees; }

    /** Add an attendee and keep the booked-count in sync. */
    public void addAttendee(Attendee attendee) {
        attendees.append(attendee);
        attendeeCount++;
    }

    /** Remove the first attendee matching the predicate and keep the count in sync. */
    public boolean removeAttendee(java.util.function.Predicate<Attendee> predicate) {
        boolean removed = attendees.removeFirstMatch(predicate);
        if (removed) {
            attendeeCount--;
        }
        return removed;
    }

    /** Find the first attendee matching the predicate, or null. */
    public Attendee findAttendee(java.util.function.Predicate<Attendee> predicate) {
        return attendees.findFirst(predicate);
    }

    @Override
    public String toString() {
        return String.format("Event: %s | %s | %s | %s | Tickets: %d/%d",
                eventID, date, location, stage, attendeeCount, maxTickets);
    }
}