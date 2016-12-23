package cz.pavelchraska.eshop.entity;


import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany
    private List<UserOrder> userOrders;

    @Email
    private String email;

    @Size(min = 3, message = "Name must be at least 3 characters !")
    private String name;

    @Size(min = 5, message = "Password must be at least 5 characters !")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable
    private List<Role> role;

    // nefunguje chujovina misto user_id bere porad users_id @UniqueUsername(message = "Such username already exists!")
    @Size(min=3, message = "Username must be at least 3 characters !")
    private String username;


    private boolean enabled;

    public boolean isEnabled() {
        return enabled;
    }

    public List<UserOrder> getUserOrders() {
        return userOrders;
    }

    public void setUserOrders(List<UserOrder> userOrders) {
        this.userOrders = userOrders;
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

    public List<Role> getRole() {
        return role;
    }

    public void setRole(List<Role> roles) {
        this.role = roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object obj) {
        return ((User) obj).getId()==this.getId();
    }
}
