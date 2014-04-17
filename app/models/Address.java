package models;

/**
 * Created by pat on 4/6/14.
 */
public class Address {
    public String street;
    public String city;
    public State state;
    public String zipcode;

    public Address() {
        state=new State();
    }

    public Address(String street, String city, State state, String zipcode)
    {
        this.street=street;
        this.city=city;
        this.state=state;
        this.zipcode=zipcode;
    }

}
