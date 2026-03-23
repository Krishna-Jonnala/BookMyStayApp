import java.io.*;
import java.util.*;

// Serializable Reservation class
class Reservation implements Serializable {
    private static final long serialVersionUID = 1L;
    private String reservationId;
    private String guestName;
    private String roomType;

    public Reservation(String reservationId, String guestName, String roomType) {
        this.reservationId = reservationId;
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public String getReservationId() { return reservationId; }
    public String getGuestName() { return guestName; }
    public String getRoomType() { return roomType; }

    @Override
    public String toString() {
        return "Reservation ID: " + reservationId + ", Guest: " + guestName + ", Room: " + roomType;
    }
}

// Serializable Inventory Service
class InventoryService implements Serializable {
    private static final long serialVersionUID = 1L;
    private Map<String, Integer> inventory = new HashMap<>();

    public void addRoom(String type, int count) { inventory.put(type, count); }
    public boolean allocateRoom(String type) {
        int available = inventory.getOrDefault(type, 0);
        if (available > 0) {
            inventory.put(type, available - 1);
            return true;
        }
        return false;
    }
    public void incrementRoom(String type) { inventory.put(type, inventory.getOrDefault(type, 0) + 1); }
    public int getAvailability(String type) { return inventory.getOrDefault(type, 0); }
    public Map<String, Integer> getInventoryMap() { return inventory; }
}

// Serializable BookingHistory
class BookingHistory implements Serializable {
    private static final long serialVersionUID = 1L;
    private Map<String, Reservation> activeReservations = new HashMap<>();

    public void addReservation(Reservation r) { activeReservations.put(r.getReservationId(), r); }
    public Collection<Reservation> getActiveReservations() { return activeReservations.values(); }
}

// Persistence Service
class PersistenceService {
    private static final String FILENAME = "bookings_inventory.ser";

    public static void save(InventoryService inventory, BookingHistory history) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILENAME))) {
            oos.writeObject(inventory);
            oos.writeObject(history);
            System.out.println("State persisted to " + FILENAME);
        } catch (IOException e) {
            System.out.println("Error saving state: " + e.getMessage());
        }
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

    public static Object[] load() {
        File file = new File(FILENAME);
        if (!file.exists()) {
            System.out.println("No persisted data found. Starting fresh.");
            return null;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME))) {
            InventoryService inventory = (InventoryService) ois.readObject();
            BookingHistory history = (BookingHistory) ois.readObject();
            System.out.println("State restored from " + FILENAME);
            return new Object[] { inventory, history };
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading state: " + e.getMessage());
            return null;
        }
    }
}

// Main class
public class UseCase12DataPersistenceRecovery {
    public static void main(String[] args) {

        // Try to restore state
        Object[] restored = PersistenceService.load();
        InventoryService inventory;
        BookingHistory history;

        if (restored == null) {
            inventory = new InventoryService();
            history = new BookingHistory();
        } else {
            inventory = (InventoryService) restored[0];
            history = (BookingHistory) restored[1];
        }

        // Initialize rooms if fresh start
        if (inventory.getInventoryMap().isEmpty()) {
            inventory.addRoom("Single", 2);
            inventory.addRoom("Double", 1);
        }

        // Simulate bookings
        Reservation r1 = new Reservation("RES001", "Alice", "Single");
        if (inventory.allocateRoom(r1.getRoomType())) history.addReservation(r1);

        Reservation r2 = new Reservation("RES002", "Bob", "Double");
        if (inventory.allocateRoom(r2.getRoomType())) history.addReservation(r2);

        System.out.println("\n--- Current Reservations ---");
        for (Reservation r : history.getActiveReservations()) System.out.println(r);

        System.out.println("\n--- Current Inventory ---");
        System.out.println("Single: " + inventory.getAvailability("Single"));
        System.out.println("Double: " + inventory.getAvailability("Double"));

        // Persist state before shutdown
        PersistenceService.save(inventory, history);
    }
}