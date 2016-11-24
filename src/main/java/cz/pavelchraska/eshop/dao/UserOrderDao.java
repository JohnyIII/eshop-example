package cz.pavelchraska.eshop.dao;


import cz.pavelchraska.eshop.entity.UserOrder;

import java.util.List;

public interface UserOrderDao {
    void save(UserOrder userOrder);

    List<UserOrder> findByUsername(String name);
}
