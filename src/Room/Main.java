package Room;

// HotelManagementGUI.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    private HotelManager hotelManager;
    private JFrame frame;
    private JTextField nameField, phoneField, idField, roomField;
    private JTextArea outputArea;

    public Main() {
        hotelManager = new HotelManager();
        initializeRooms();

        frame = new JFrame("Hotel Management System");
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(6, 2));

        JLabel nameLabel = new JLabel("Customer Name:");
        nameField = new JTextField();

        JLabel phoneLabel = new JLabel("Phone:");
        phoneField = new JTextField();

        JLabel idLabel = new JLabel("ID Card:");
        idField = new JTextField();

        JLabel roomLabel = new JLabel("Room Number:");
        roomField = new JTextField();

        JButton bookButton = new JButton("Book Room");
        outputArea = new JTextArea(100, 100);
        outputArea.setEditable(false);

        bookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bookRoom();
            }
        });

        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(phoneLabel);
        frame.add(phoneField);
        frame.add(idLabel);
        frame.add(idField);
        frame.add(roomLabel);
        frame.add(roomField);
        frame.add(bookButton);
        frame.add(new JLabel()); // Empty label for layout purposes
        frame.add(new JScrollPane(outputArea));

        frame.setVisible(true);
    }

    private void initializeRooms() {
        hotelManager.addRoom(new java(101, "Single"));
        hotelManager.addRoom(new java(102, "Double"));
        hotelManager.addRoom(new java(201, "Suite"));
    }

    private void bookRoom() {
        String name = nameField.getText();
        String phone = phoneField.getText();
        String idCard = idField.getText();
        int roomNumber = Integer.parseInt(roomField.getText());

        java room = hotelManager.findAvailableRoom(roomNumber);

        if (room != null) {
            Customer customer = new Customer(name, phone, idCard);
            hotelManager.addBooking(customer, room);
            outputArea.setText("Booking successful!\n\n"
                    + "Customer Name: " + name + "\n"
                    + "Phone: " + phone + "\n"
                    + "ID Card: " + idCard + "\n"
                    + "Room Number: " + roomNumber + " (" + room.getRoomType() + ")");
        } else {
            outputArea.setText("Room " + roomNumber + " is not available or does not exist.");
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}
