package cz.pavelchraska.eshop.dao;

import cz.pavelchraska.eshop.entity.User;


public interface UserDao {

    User getById(Integer id);

    void save(User user);

    void saveAdmin(User user);

    User findByName(String s);
}
