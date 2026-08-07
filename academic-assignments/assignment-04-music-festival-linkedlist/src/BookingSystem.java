import java.util.Random;
import java.util.Scanner;

public class BookingSystem {
    private static MyLinkedList<Event> events = new MyLinkedList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    public static void main(String[] args) {
        // Preload multiple events so user can see options
        events.append(new Event("E001", "2025-09-01", "Cape Town", "Main Stage", 5));
        events.append(new Event("E002", "2025-09-05", "Johannesburg", "Rock Arena", 5));
        events.append(new Event("E003", "2025-09-10", "Durban", "Beach Stage", 5));
        events.append(new Event("E004", "2025-09-15", "Pretoria", "Jazz Corner", 5));
        events.append(new Event("E005", "2025-09-20", "Bloemfontein", "HipHop Stage", 5));

        System.out.println("=== Music Festival Ticket Booking System ===");

        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Book Ticket");
            System.out.println("2. Cancel Booking");
            System.out.println("3. Check Booking");
            System.out.println("4. Display Attendees");
            System.out.println("5. View Events");
            System.out.println("6. Exit");
            System.out.print("Choose: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1 -> bookTicket();
                    case 2 -> cancelBooking();
                    case 3 -> checkBooking();
                    case 4 -> displayAttendees();
                    case 5 -> viewEvents();
                    case 6 -> { System.out.println("Goodbye!"); return; }
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    private static void bookTicket() {
        viewEvents();
        System.out.print("Enter Event ID: ");
        String eventID = scanner.nextLine().trim();

        Event event = findEvent(eventID);
        if (event == null) {
            System.out.println("Event not found.");
            return;
        }

        // Check if event has available tickets
        if (event.getAttendeeCount() >= event.getMaxTickets()) {
            System.out.println("Sorry, this event is fully booked.");
            return;
        }

        System.out.println("Event found: " + event);
        System.out.println("Available tickets: " + (event.getMaxTickets() - event.getAttendeeCount()));

        // Get attendee details
        System.out.print("Enter ID Number: ");
        String id = scanner.nextLine().trim();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine().trim();
        System.out.print("Enter Surname: ");
        String surname = scanner.nextLine().trim();
        System.out.print("Enter Contact Number: ");
        String contact = scanner.nextLine().trim();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine().trim();

        // Validate inputs
        if (id.isEmpty() || name.isEmpty() || surname.isEmpty() || contact.isEmpty() || email.isEmpty()) {
            System.out.println("All fields are required. Booking cancelled.");
            return;
        }

        // Check if this attendee already booked for this event
        if (isAlreadyBooked(event, id, email, contact)) {
            System.out.println("This attendee already has a booking for this event.");
            return;
        }

        // Generate seat number
        int seatNumber = event.getAttendeeCount() + 1;
        String seat = "S" + seatNumber;

        // Create attendee and add to event
        Attendee attendee = new Attendee(id, name, surname, contact, email, seat);
        String prize = spinPrize();
        attendee.setPrize(prize);

        // Add to event's attendee list
        event.getAttendees().append(attendee);

        System.out.println("\nBooking successful!");
        System.out.println("Event: " + event.getEventID() + " - " + event.getStage());
        System.out.println("Attendee: " + name + " " + surname);
        System.out.println("Seat: " + seat);
        System.out.println("Prize won: " + prize);
    }

    private static void cancelBooking() {
        System.out.println("Cancel by: 1. Attendee Details 2. Event ID + Seat Number");
        System.out.print("Choose: ");

        try {
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                cancelByAttendeeDetails();
            } else if (choice == 2) {
                cancelBySeatNumber();
            } else {
                System.out.println("Invalid choice.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        }
    }

    private static void cancelByAttendeeDetails() {
        System.out.print("Enter Event ID: ");
        String eventID = scanner.nextLine().trim();
        Event event = findEvent(eventID);

        if (event == null) {
            System.out.println("Event not found.");
            return;
        }

        System.out.print("Enter ID Number: ");
        String id = scanner.nextLine().trim();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine().trim();

        // Create a dummy attendee for searching
        Attendee searchAttendee = new Attendee(id, "", "", "", email, "");

        // Use the delete method which works with compareTo
        boolean removed = event.getAttendees().delete(searchAttendee);

        if (removed) {
            System.out.println("Booking cancelled successfully.");
        } else {
            System.out.println("Booking not found. Would you like to book instead? (Y/N)");
            String response = scanner.nextLine().trim();
            if (response.equalsIgnoreCase("Y")) {
                bookTicket();
            }
        }
    }

    private static void cancelBySeatNumber() {
        System.out.print("Enter Event ID: ");
        String eventID = scanner.nextLine().trim();
        Event event = findEvent(eventID);

        if (event == null) {
            System.out.println("Event not found.");
            return;
        }

        System.out.print("Enter Seat Number: ");
        String seat = scanner.nextLine().trim();

        // For seat-based cancellation, we need to search manually
        // since our compareTo only uses ID for comparison

        // Convert the linked list to string and search for the seat
        String attendeesStr = event.getAttendees().toString();
        if (attendeesStr.contains("Seat: " + seat)) {
            // Extract the ID from the string and use it to delete
            int seatIndex = attendeesStr.indexOf("Seat: " + seat);
            int idStart = attendeesStr.lastIndexOf("ID: ", seatIndex) + 4;
            int idEnd = attendeesStr.indexOf(",", idStart);
            String id = attendeesStr.substring(idStart, idEnd).trim();

            // Create dummy attendee and delete using ID
            Attendee toRemove = new Attendee(id, "", "", "", "", "");
            event.getAttendees().delete(toRemove);
            System.out.println("Booking cancelled successfully.");
        } else {
            System.out.println("Booking not found. Would you like to book instead? (Y/N)");
            String response = scanner.nextLine().trim();
            if (response.equalsIgnoreCase("Y")) {
                bookTicket();
            }
        }
    }

    private static void checkBooking() {
        System.out.print("Enter Event ID: ");
        String eventID = scanner.nextLine().trim();
        Event event = findEvent(eventID);

        if (event == null) {
            System.out.println("Event not found.");
            return;
        }

        System.out.println("Search by: 1. ID Number 2. Name 3. Contact Number 4. Email");
        System.out.print("Choose: ");

        try {
            int choice = Integer.parseInt(scanner.nextLine());
            String searchTerm = "";

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter ID Number: ");
                    searchTerm = scanner.nextLine().trim();
                }
                case 2 -> {
                    System.out.print("Enter Name: ");
                    searchTerm = scanner.nextLine().trim();
                }
                case 3 -> {
                    System.out.print("Enter Contact Number: ");
                    searchTerm = scanner.nextLine().trim();
                }
                case 4 -> {
                    System.out.print("Enter Email: ");
                    searchTerm = scanner.nextLine().trim();
                }
                default -> {
                    System.out.println("Invalid choice.");
                    return;
                }
            }

            // Convert to string and search
            String attendeesStr = event.getAttendees().toString();
            boolean found = attendeesStr.contains(searchTerm);

            if (found) {
                System.out.println("Booking found in event " + eventID);
                // Extract and display the specific booking details
                int startIndex = attendeesStr.indexOf(searchTerm);
                int endIndex = attendeesStr.indexOf(")", startIndex) + 1;
                if (startIndex != -1 && endIndex != -1) {
                    System.out.println(attendeesStr.substring(startIndex, endIndex));
                }
            } else {
                System.out.println("Booking not found. Would you like to book instead? (Y/N)");
                String response = scanner.nextLine().trim();
                if (response.equalsIgnoreCase("Y")) {
                    bookTicket();
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        }
    }

    private static void displayAttendees() {
        System.out.print("Enter Event ID: ");
        String eventID = scanner.nextLine().trim();
        Event event = findEvent(eventID);

        if (event == null) {
            System.out.println("Event not found.");
            return;
        }

        if (event.getAttendeeCount() == 0) {
            System.out.println("No attendees booked for this event yet.");
        } else {
            System.out.println("\nAttendees for " + event.getEventID() + " - " + event.getStage() + ":");
            System.out.println("Total: " + event.getAttendeeCount() + "/" + event.getMaxTickets());
            System.out.println("----------------------------------------");

            // Display the string representation which shows all attendees
            String attendeesStr = event.getAttendees().toString();
            // Remove the brackets and split by commas
            attendeesStr = attendeesStr.substring(1, attendeesStr.length() - 1);
            String[] attendees = attendeesStr.split(",");

            for (String attendee : attendees) {
                System.out.println(attendee.trim());
            }
        }

        System.out.println("\n1. Return to Menu 2. Make a Booking");
        System.out.print("Choose: ");

        try {
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 2) {
                bookTicket();
            }
        } catch (NumberFormatException e) {
            // Just return to menu if input is invalid
        }
    }

    private static void viewEvents() {
        System.out.println("\nAvailable Events:");
        System.out.println("ID\tDate\t\tLocation\tStage\t\tAvailable");
        System.out.println("----------------------------------------------------------------");

        // Convert events to string and parse it
        String eventsStr = events.toString();
        eventsStr = eventsStr.substring(1, eventsStr.length() - 1);
        String[] eventArray = eventsStr.split(",");

        for (String eventStr : eventArray) {
            System.out.println(eventStr.trim());
        }
    }

    private static Event findEvent(String id) {
        // Convert events to string and search for the ID
        String eventsStr = events.toString();
        if (eventsStr.contains("Event: " + id)) {
            // Extract the event details
            int startIndex = eventsStr.indexOf("Event: " + id);
            int endIndex = eventsStr.indexOf(")", startIndex) + 1;

            if (startIndex != -1 && endIndex != -1) {
                String eventDetails = eventsStr.substring(startIndex, endIndex);
                // Parse the event details to create an event object
                String[] parts = eventDetails.split("\\|");
                if (parts.length >= 4) {
                    String eventID = parts[0].replace("Event: ", "").trim();
                    String date = parts[1].trim();
                    String location = parts[2].trim();
                    String[] stageParts = parts[3].split("Tickets:");
                    String stage = stageParts[0].trim();
                    String[] ticketParts = stageParts[1].split("/");
                    int booked = Integer.parseInt(ticketParts[0].trim());
                    int max = Integer.parseInt(ticketParts[1].replace(")", "").trim());

                    Event event = new Event(eventID, date, location, stage, max);
                    // Set the attendee count
                    event.setAttendeeCount(booked);
                    return event;
                }
            }
        }
        return null;
    }

    private static boolean isAlreadyBooked(Event event, String id, String email, String contact) {
        String attendeesStr = event.getAttendees().toString();
        return attendeesStr.contains("ID: " + id) ||
                attendeesStr.contains("Email: " + email) ||
                attendeesStr.contains("Contact: " + contact);
    }

    private static String spinPrize() {
        String[] prizes = {"VIP Pass Upgrade", "Free Festival T-Shirt",
                "Backstage Access", "Food Voucher"};
        return prizes[random.nextInt(prizes.length)];
    }
}