
package Room;

// HotelManager.java
import java.util.ArrayList;

public class HotelManager {
    private ArrayList<java> rooms;
    private ArrayList<Booking> bookings;

    public HotelManager() {
        rooms = new ArrayList<>();
        bookings = new ArrayList<>();
    }

    public void addRoom(java room) {
        rooms.add(room);
    }

    public java findAvailableRoom(int roomNumber) {
        for (java room : rooms) {
            if (room.getRoomNumber() == roomNumber && !room.isBooked()) {
                return room;
            }
        }
        return null;
    }

    public void addBooking(Customer customer, java room) {
        room.setBooked(true);
        bookings.add(new Booking(customer, room));
    }

    public ArrayList<java> getRooms() {
        return rooms;
    }

    public ArrayList<Booking> getBookings() {
        return bookings;
    }
}
