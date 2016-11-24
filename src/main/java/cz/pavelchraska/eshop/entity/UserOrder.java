package cz.pavelchraska.eshop.entity;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class UserOrder {

    @Id
    @GeneratedValue
    private int id;

    @OneToMany(cascade = {CascadeType.ALL})
    private List<OrderedItem> orderedItems;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user ;

    @Size(min = 2)
    private String city;

    @Size(min = 5,max = 6)
    private String zipCode;

    @Size(min = 5)
    private String street;

    @Size(min = 4)
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
