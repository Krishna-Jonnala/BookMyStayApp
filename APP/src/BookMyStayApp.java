import java.util.*;

// Reservation class (represents a booking request)
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

// Booking Request Queue Service
class BookingQueueService {
    private Queue<Reservation> bookingQueue;

    public BookingQueueService() {
        bookingQueue = new LinkedList<>();
    }

    // Add booking request (enqueue)
    public void addRequest(Reservation reservation) {
        bookingQueue.offer(reservation);
        System.out.println("Booking request added: " + reservation);
    }

    // Display all requests (without removing → read-only view)
    public void displayRequests() {
        System.out.println("\nCurrent Booking Queue (FIFO Order):");

        if (bookingQueue.isEmpty()) {
            System.out.println("No booking requests in queue.");
            return;
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
    }
}

// Main Class
public class UseCase5BookingRequestQueue {
    public static void main(String[] args) {

        BookingQueueService service = new BookingQueueService();

        // Simulating multiple booking requests
        service.addRequest(new Reservation("Alice", "Single"));
        service.addRequest(new Reservation("Bob", "Double"));
        service.addRequest(new Reservation("Charlie", "Suite"));

        // Display queue (FIFO order)
        service.displayRequests();
    }
}