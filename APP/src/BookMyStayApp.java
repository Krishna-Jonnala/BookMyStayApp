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