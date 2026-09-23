import java.util.Random;
import java.util.Scanner;
import java.util.function.Predicate;

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

        event.addAttendee(attendee);

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

        boolean removed = event.removeAttendee(
                attendee -> attendee.getIdNumber().equals(id) || attendee.getEmail().equals(email));

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

        boolean removed = event.removeAttendee(attendee -> attendee.getSeatNumber().equals(seat));

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

        int choice;
        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
            return;
        }

        String prompt = switch (choice) {
            case 1 -> "Enter ID Number: ";
            case 2 -> "Enter Name: ";
            case 3 -> "Enter Contact Number: ";
            case 4 -> "Enter Email: ";
            default -> null;
        };
        if (prompt == null) {
            System.out.println("Invalid choice.");
            return;
        }

        System.out.print(prompt);
        String searchTerm = scanner.nextLine().trim();

        Predicate<Attendee> predicate = switch (choice) {
            case 1 -> attendee -> attendee.getIdNumber().equals(searchTerm);
            case 2 -> attendee -> attendee.getName().equals(searchTerm) || attendee.getSurname().equals(searchTerm);
            case 3 -> attendee -> attendee.getContactNumber().equals(searchTerm);
            case 4 -> attendee -> attendee.getEmail().equals(searchTerm);
            default -> attendee -> false;
        };

        Attendee found = event.findAttendee(predicate);
        if (found != null) {
            System.out.println("Booking found in event " + eventID);
            System.out.println(found);
        } else {
            System.out.println("Booking not found. Would you like to book instead? (Y/N)");
            String response = scanner.nextLine().trim();
            if (response.equalsIgnoreCase("Y")) {
                bookTicket();
            }
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

            // Traverse the linked list directly instead of splitting a string.
            for (Attendee attendee : event.getAttendees()) {
                System.out.println(attendee);
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

        for (Event event : events) {
            System.out.println(event);
        }
    }

    private static Event findEvent(String id) {
        return events.findFirst(event -> event.getEventID().equals(id));
    }

    private static boolean isAlreadyBooked(Event event, String id, String email, String contact) {
        return event.findAttendee(attendee ->
                attendee.getIdNumber().equals(id)
                        || attendee.getEmail().equals(email)
                        || attendee.getContactNumber().equals(contact)) != null;
    }

    private static String spinPrize() {
        String[] prizes = {"VIP Pass Upgrade", "Free Festival T-Shirt",
                "Backstage Access", "Food Voucher"};
        return prizes[random.nextInt(prizes.length)];
    }
}
