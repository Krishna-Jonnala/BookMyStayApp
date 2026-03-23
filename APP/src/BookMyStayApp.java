import java.util.*;

// Reservation class
class Reservation {
    private String reservationId;
    private String guestName;
    private String roomType;

    public Reservation(String reservationId, String guestName, String roomType) {
        this.reservationId = reservationId;
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public String getReservationId() {
        return reservationId;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }

    @Override
    public String toString() {
        return "Reservation ID: " + reservationId + ", Guest: " + guestName + ", Room: " + roomType;
    }
}

// Booking History (stores confirmed bookings)
class BookingHistory {
    private List<Reservation> confirmedBookings = new ArrayList<>();

    // Add confirmed reservation
    public void addReservation(Reservation r) {
        confirmedBookings.add(r);
        System.out.println("Added to booking history: " + r);
    }

    // Retrieve all bookings
    public List<Reservation> getAllReservations() {
        return Collections.unmodifiableList(confirmedBookings); // read-only
    }
}

// Reporting Service
class BookingReportService {
    public void generateReport(BookingHistory history) {
        System.out.println("\n--- Booking Report ---");
        List<Reservation> reservations = history.getAllReservations();

        if (reservations.isEmpty()) {
            System.out.println("No bookings found.");
            return;
        }

        Map<String, Integer> roomSummary = new HashMap<>();

        for (Reservation r : reservations) {
            System.out.println(r);
            roomSummary.put(r.getRoomType(), roomSummary.getOrDefault(r.getRoomType(), 0) + 1);
        for (AddOnService s : services) {
            System.out.println("- " + s);
            totalCost += s.getCost();
            } else {
                System.out.println("Booking Failed! No rooms available for: " + type);
            }
        for (Reservation r : bookingQueue) {
            System.out.println(r);
        for (String type : inventory.keySet()) {
            if (inventory.get(type) > 0) {
                Room r = rooms.get(type);
                System.out.println(type + " - ₹" + r.price + " Available: " + inventory.get(type));
            }
import java.util.HashMap;
import java.util.Map;


public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("====================================");
        System.out.println("        Book My Stay System         ");
        System.out.println("       Hotel Booking v3.1           ");
        System.out.println("====================================");

        // Initialize inventory
        RoomInventory inventory = new RoomInventory();

        // Display inventory
        inventory.displayInventory();

        // Check availability
        int singleRooms = inventory.getAvailability("Single Room");
        System.out.println("\nSingle Rooms Available: " + singleRooms);

        // Update availability after booking
        inventory.updateAvailability("Single Room", singleRooms - 1);

        System.out.println("\nAfter booking one Single Room:");
        inventory.displayInventory();
    }
}

class RoomInventory {

    private Map<String, Integer> inventory;

    public RoomInventory() {

        inventory = new HashMap<>();

        inventory.put("Single Room", 5);
        inventory.put("Double Room", 3);
        inventory.put("Suite Room", 2);
    }

    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    public void updateAvailability(String roomType, int count) {
        inventory.put(roomType, count);
    }

    public void displayInventory() {

        System.out.println("\nCurrent Room Inventory:");

        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        System.out.println("\n--- Room Type Summary ---");
        for (Map.Entry<String, Integer> entry : roomSummary.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " bookings");
        }
    }
}

// Main Class
public class UseCase8BookingHistoryReport {
    public static void main(String[] args) {

        BookingHistory history = new BookingHistory();
        BookingReportService reportService = new BookingReportService();

        // Simulate confirmed reservations
        history.addReservation(new Reservation("RES001", "Alice", "Single"));
        history.addReservation(new Reservation("RES002", "Bob", "Double"));
        history.addReservation(new Reservation("RES003", "Charlie", "Suite"));
        history.addReservation(new Reservation("RES004", "Diana", "Single"));

        // Admin requests report
        reportService.generateReport(history);
    }
}