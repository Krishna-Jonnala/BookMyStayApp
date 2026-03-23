import java.util.*;

// Custom Exception for invalid bookings
class InvalidBookingException extends Exception {
    public InvalidBookingException(String message) {
        super(message);
    }
}

// Reservation class
class Reservation {
    private String guestName;
    private String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }

    @Override
    public String toString() {
        return "Guest: " + guestName + ", Room Type: " + roomType;
    }
}

// Inventory service
class InventoryService {
    private Map<String, Integer> inventory = new HashMap<>();

    public void addRoom(String type, int count) {
        inventory.put(type, count);
    }

    public int getAvailability(String type) throws InvalidBookingException {
        if (!inventory.containsKey(type)) {
            throw new InvalidBookingException("Invalid room type: " + type);
        }
        return inventory.get(type);
    }

    public void decrement(String type) throws InvalidBookingException {
        int available = getAvailability(type);
        if (available <= 0) {
            throw new InvalidBookingException("No rooms available for: " + type);
        }
        inventory.put(type, available - 1);
    }
}

// Booking service with validation
class BookingService {
    private InventoryService inventory;

    public BookingService(InventoryService inventory) {
        this.inventory = inventory;
    }

    public void bookRoom(Reservation reservation) {
        try {
            // Validate room type
            if (reservation.getRoomType() == null || reservation.getRoomType().isEmpty()) {
                throw new InvalidBookingException("Room type cannot be empty");
            }

            // Validate guest name
            if (reservation.getGuestName() == null || reservation.getGuestName().isEmpty()) {
                throw new InvalidBookingException("Guest name cannot be empty");
            }

            // Check availability and allocate
            inventory.decrement(reservation.getRoomType());

            // Confirm booking
            System.out.println("Booking successful: " + reservation);
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

        } catch (InvalidBookingException e) {
            System.out.println("Booking failed: " + e.getMessage());
        }
    }
}

// Main class
public class UseCase9ErrorHandlingValidation {
    public static void main(String[] args) {

        InventoryService inventory = new InventoryService();
        inventory.addRoom("Single", 2);
        inventory.addRoom("Double", 1);

        BookingService bookingService = new BookingService(inventory);

        // Test cases
        bookingService.bookRoom(new Reservation("Alice", "Single")); // valid
        bookingService.bookRoom(new Reservation("Bob", "Double"));    // valid
        bookingService.bookRoom(new Reservation("Charlie", "Double")); // should fail, no room left
        bookingService.bookRoom(new Reservation("", "Single"));       // should fail, invalid guest
        bookingService.bookRoom(new Reservation("Diana", "Suite"));   // should fail, invalid room type
    }
}