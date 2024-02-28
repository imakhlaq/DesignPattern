package entities;

/*
Common abstract class for the entities.Customer and admin because they share "some" similar attributes.
 */
public abstract class User {
    //private because we want to access in a class that will extend this class.
    //so child class can access these field's
    protected Long id;
    protected String name;
    protected String Address;
    protected Integer phoneNo;


    //initializing the attributes
    public User(Long id, String name, String address, Integer phoneNo) {
        this.id = id;
        this.name = name;
        Address = address;
        this.phoneNo = phoneNo;
    }

    //getters and setters for access control (encapsulation)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public Integer getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(Integer phoneNo) {
        this.phoneNo = phoneNo;
    }
}
