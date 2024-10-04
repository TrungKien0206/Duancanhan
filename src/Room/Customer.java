
package Room;

// Customer.java
public class Customer {
    private String name;
    private String phone;
    private String idCard;

    public Customer(String name, String phone, String idCard) {
        this.name = name;
        this.phone = phone;
        this.idCard = idCard;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getIdCard() {
        return idCard;
    }
}
