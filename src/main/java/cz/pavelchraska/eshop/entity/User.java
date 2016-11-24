package cz.pavelchraska.eshop.entity;


import cz.pavelchraska.eshop.annotation.UniqueUsername;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue
    private int id;

    @OneToMany
    private List<Order> orders;

    @Email
    private String email;

    @Size(min = 3, message = "Name must be at least 3 characters !")
    private String name;

    @Size(min = 5, message = "Password must be at least 5 characters !")
    private String password;

    @ManyToMany
    @JoinTable
    private List<Role> roles;

    @UniqueUsername(message = "Such username already exists!")
    @Size(min=3, message = "Username must be at least 3 characters !")
    private String username;


    private boolean enabled;

    public boolean isEnabled() {
        return enabled;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
