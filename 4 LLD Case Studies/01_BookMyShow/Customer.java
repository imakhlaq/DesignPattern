/*
Its extending user abstract class and inheriting shared attributes between Admin and Customer.
And Customer class adding attributes that are specific to the Customer
*/
public class Customer extends User {
    public Customer(Long id, String name, String address, Integer phoneNo) {
        //calling User abstract class constructor and passing values to desalinized
        //first parent class object is created and then child class
        super(id, name, address, phoneNo);
    }
}
