package entities;

/*
Its extending user abstract class and inheriting shared attributes between entities.Admin and entities.Customer
And entities.Admin class adding attributes that are specific to the entities.Admin
*/
public class Admin extends User {
    // Private because of encapsulation
    private Long employeeId;

    //create constructor and initialize all the values
    public Admin(Long id, String name, String address, Integer phoneNo, Long employeeId) {
        //calling entities.User abstract class constructor and passing values to desalinized
        //first parent class object is created and then child class
        super(id, name, address, phoneNo);
        this.employeeId = employeeId;
    }


    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }


}
