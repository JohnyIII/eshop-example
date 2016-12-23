package cz.pavelchraska.eshop.entity;


import org.hibernate.annotations.Proxy;

import javax.persistence.*;

@Entity
public class OrderedItem {

    @Id
    @GeneratedValue
    private Integer id;

    private int quantity;

    @ManyToOne
    @JoinColumn(name="UserOrder_id")
    private UserOrder userOrder;

    @ManyToOne
    @JoinColumn(name = "Item_id")
    private Item item;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public UserOrder getUserOrder() {
        return userOrder;
    }

    public void setUserOrder(UserOrder userOrder) {
        this.userOrder = userOrder;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
