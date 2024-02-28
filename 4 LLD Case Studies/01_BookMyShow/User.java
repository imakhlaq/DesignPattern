/*
Common abstract class for the Customer and admin because they share "some" similar attributes.
 */
public abstract class User {
    // Private because of encapsulation
    private Long id;
    private String name;
    private String Address;
    private Integer phoneNo;

    public User(Long id, String name, String address, Integer phoneNo) {
        this.id = id;
        this.name = name;
        Address = address;
        this.phoneNo = phoneNo;
    }

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
