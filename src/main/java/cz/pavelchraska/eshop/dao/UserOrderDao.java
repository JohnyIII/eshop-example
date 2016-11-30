package cz.pavelchraska.eshop.dao;


import cz.pavelchraska.eshop.entity.UserOrder;

import java.util.List;

import javax.persistence.criteria.Order;

public interface UserOrderDao {
    void save(UserOrder userOrder);

    List<UserOrder> findByUsername(String name);

	UserOrder findById(int id);

	UserOrder findByIdWithItems(int id);

}
