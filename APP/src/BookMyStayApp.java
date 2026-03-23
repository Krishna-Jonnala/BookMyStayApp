import java.util.*;

class Room {
    String type;
    double price;

    Room(String type, double price) {
        this.type = type;
        this.price = price;
    }
}

public class BookMyStayApp {
    public static void main(String[] args) {

        Map<String, Integer> inventory = new HashMap<>();
        inventory.put("Single", 2);
        inventory.put("Double", 0);
        inventory.put("Suite", 1);

        Map<String, Room> rooms = new HashMap<>();
        rooms.put("Single", new Room("Single", 2000));
        rooms.put("Double", new Room("Double", 3500));
        rooms.put("Suite", new Room("Suite", 5000));

        System.out.println("Available Rooms:");

        for (String type : inventory.keySet()) {
            if (inventory.get(type) > 0) {
                Room r = rooms.get(type);
                System.out.println(type + " - ₹" + r.price + " Available: " + inventory.get(type));
            }
        }
    }
}