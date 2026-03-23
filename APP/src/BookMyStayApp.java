import java.util.*;
import java.util.concurrent.*;

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

// Thread-safe Inventory Service
class InventoryService {
    private final Map<String, Integer> inventory = new HashMap<>();

    public synchronized void addRoom(String type, int count) {
        inventory.put(type, count);
    }

    public synchronized boolean allocateRoom(String type) {
        int available = inventory.getOrDefault(type, 0);
        if (available > 0) {
            inventory.put(type, available - 1);
            return true;
        }
        return false;
    }

    public synchronized void incrementRoom(String type) {
        inventory.put(type, inventory.getOrDefault(type, 0) + 1);
    }

    public synchronized int getAvailability(String type) {
        return inventory.getOrDefault(type, 0);
    }
}

// Booking queue processor
class BookingProcessor implements Runnable {
    private final Queue<Reservation> bookingQueue;
    private final InventoryService inventory;

    public BookingProcessor(Queue<Reservation> bookingQueue, InventoryService inventory) {
        this.bookingQueue = bookingQueue;
        this.inventory = inventory;
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

    @Override
    public void run() {
        while (true) {
            Reservation res;
            synchronized (bookingQueue) {
                res = bookingQueue.poll();
            }
            if (res == null) {
                break; // queue empty
            }

            boolean allocated = inventory.allocateRoom(res.getRoomType());
            if (allocated) {
                System.out.println(Thread.currentThread().getName() + " booked " + res);
            } else {
                System.out.println(Thread.currentThread().getName() + " failed to book " + res + " (No availability)");
            }
        }
    }
}

// Main class
public class UseCase11ConcurrentBookingSimulation {
    public static void main(String[] args) throws InterruptedException {
        InventoryService inventory = new InventoryService();
        inventory.addRoom("Single", 3);
        inventory.addRoom("Double", 2);

        Queue<Reservation> bookingQueue = new LinkedList<>();
        bookingQueue.add(new Reservation("Alice", "Single"));
        bookingQueue.add(new Reservation("Bob", "Single"));
        bookingQueue.add(new Reservation("Charlie", "Double"));
        bookingQueue.add(new Reservation("Diana", "Double"));
        bookingQueue.add(new Reservation("Eve", "Single")); // last Single room

        int numThreads = 3; // Simulate 3 guests processing concurrently
        Thread[] threads = new Thread[numThreads];

        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Thread(new BookingProcessor(bookingQueue, inventory), "Thread-" + (i + 1));
            threads[i].start();
        }

        for (Thread t : threads) {
            t.join();
        }

        System.out.println("\n--- Final Inventory ---");
        System.out.println("Single: " + inventory.getAvailability("Single"));
        System.out.println("Double: " + inventory.getAvailability("Double"));
    }
}