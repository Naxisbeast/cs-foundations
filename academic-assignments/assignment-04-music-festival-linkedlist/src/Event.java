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
    public void setAttendeeCount(int count) { this.attendeeCount = count; }
    public MyLinkedList<Attendee> getAttendees() { return attendees; }

    @Override
    public String toString() {
        return String.format("Event: %s | %s | %s | %s | Tickets: %d/%d",
                eventID, date, location, stage, attendeeCount, maxTickets);
    }
}