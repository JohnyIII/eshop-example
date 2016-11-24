package cz.pavelchraska.eshop.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Order {


    @Id
    @GeneratedValue
    private int id;

    @OneToMany
    private List<OrderedItem> orderedItems;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user ;

    private String city;

    private String zipCode;

    private String street;

    private String state;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<OrderedItem> getOrderedItems() {
        return orderedItems;
    }

    public void setOrderedItems(List<OrderedItem> orderedItems) {
        this.orderedItems = orderedItems;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
