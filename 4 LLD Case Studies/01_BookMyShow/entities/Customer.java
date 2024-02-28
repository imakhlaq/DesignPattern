package entities;

import entities.User;

/*
Its extending user abstract class and inheriting shared attributes between entities.Admin and entities.Customer.
And entities.Customer class adding attributes that are specific to the entities.Customer
*/
public class Customer extends User {
    public Customer(Long id, String name, String address, Integer phoneNo) {
        //calling entities.User abstract class constructor and passing values to desalinized
        //first parent class object is created and then child class
        super(id, name, address, phoneNo);
    }
}
