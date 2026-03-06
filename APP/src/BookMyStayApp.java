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