
package Room;

// Booking.java
public class Booking {
    private Customer customer;
    private java room;

    public Booking(Customer customer, java room) {
        this.customer = customer;
        this.room = room;
    }

    public void displayBookingInfo() {
        System.out.println("Customer: " + customer.getName() + " booked room " + room.getRoomNumber() + " (" + room.getRoomType() + ")");
    }
}
