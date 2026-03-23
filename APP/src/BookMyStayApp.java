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

// Inventory Service
class InventoryService {
    private Map<String, Integer> inventory = new HashMap<>();

    public void addRoom(String type, int count) {
        inventory.put(type, count);
    }

    public void increment(String type) {
        inventory.put(type, inventory.getOrDefault(type, 0) + 1);
    }

    public void decrement(String type) throws Exception {
        int available = inventory.getOrDefault(type, 0);
        if (available <= 0) {
            throw new Exception("No rooms available for: " + type);
        }
        inventory.put(type, available - 1);
    }

    public int getAvailability(String type) {
        return inventory.getOrDefault(type, 0);
    }
}

// Booking History
class BookingHistory {
    private Map<String, Reservation> activeReservations = new HashMap<>();
    private Stack<String> cancelledReservations = new Stack<>();

    public void addReservation(Reservation r) {
        activeReservations.put(r.getReservationId(), r);
        System.out.println("Reservation confirmed: " + r);
    }

    public boolean exists(String reservationId) {
        return activeReservations.containsKey(reservationId);
    }

    public Reservation cancelReservation(String reservationId) {
        if (!activeReservations.containsKey(reservationId)) {
            return null;
        }
        Reservation r = activeReservations.remove(reservationId);
        cancelledReservations.push(reservationId);
        System.out.println("Reservation cancelled: " + r);
        return r;
    }

    public Collection<Reservation> getActiveReservations() {
        return activeReservations.values();
    }
}

// Cancellation Service
class CancellationService {
    private InventoryService inventory;
    private BookingHistory history;

    public CancellationService(InventoryService inventory, BookingHistory history) {
        this.inventory = inventory;
        this.history = history;
    }
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

    public void cancel(String reservationId) {
        if (!history.exists(reservationId)) {
            System.out.println("Cannot cancel: Reservation ID " + reservationId + " does not exist.");
            return;
        }

        Reservation r = history.cancelReservation(reservationId);
        inventory.increment(r.getRoomType());
        System.out.println("Inventory updated: " + r.getRoomType() + " now has " + inventory.getAvailability(r.getRoomType()) + " rooms available.\n");
    }
}

// Main Class
public class UseCase10BookingCancellation {
    public static void main(String[] args) throws Exception {

        InventoryService inventory = new InventoryService();
        inventory.addRoom("Single", 2);
        inventory.addRoom("Double", 1);

        BookingHistory history = new BookingHistory();
        CancellationService cancellationService = new CancellationService(inventory, history);

        // Simulate bookings
        Reservation r1 = new Reservation("RES001", "Alice", "Single");
        Reservation r2 = new Reservation("RES002", "Bob", "Double");

        inventory.decrement(r1.getRoomType());
        history.addReservation(r1);

        inventory.decrement(r2.getRoomType());
        history.addReservation(r2);

        System.out.println("\n--- Active Reservations Before Cancellation ---");
        for (Reservation r : history.getActiveReservations()) {
            System.out.println(r);
        }

        // Cancel a booking
        System.out.println("\n--- Cancelling RES001 ---");
        cancellationService.cancel("RES001");

        // Attempt to cancel non-existent reservation
        System.out.println("\n--- Cancelling RES003 (Invalid) ---");
        cancellationService.cancel("RES003");

        System.out.println("\n--- Active Reservations After Cancellation ---");
        for (Reservation r : history.getActiveReservations()) {
            System.out.println(r);
        }
    }
}