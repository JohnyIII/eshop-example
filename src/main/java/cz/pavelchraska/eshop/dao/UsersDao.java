package cz.pavelchraska.eshop.dao;

import cz.pavelchraska.eshop.entity.User;

import java.util.List;

/**
 * Created by Pajut on 12/21/2016.
 */
public interface UsersDao {

    List<User> getAllUsers();

}
