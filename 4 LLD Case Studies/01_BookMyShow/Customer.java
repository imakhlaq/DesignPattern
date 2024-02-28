/*
Its extending user abstract class and inheriting shared attributes between Admin and Customer.
And Customer class adding attributes that are specific to the Customer
*/
public class Customer extends User {
    public Customer(Long id, String name, String address, Integer phoneNo) {
        super(id, name, address, phoneNo);
    }
}
