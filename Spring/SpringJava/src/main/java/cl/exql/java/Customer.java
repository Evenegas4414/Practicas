package cl.exql.java;

public class Customer {

    private String firstName;

    public Customer() {
        System.out.println("Default constructor");
    }

    public Customer(String firstName) {
        this.firstName = firstName;
        System.out.println("Constructor with firstName");
    }

    public void customInit() {
        System.out.println("customInit method: firstname=" + firstName);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
