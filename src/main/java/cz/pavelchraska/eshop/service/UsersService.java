package cz.pavelchraska.eshop.service;


import cz.pavelchraska.eshop.dao.UsersDao;
import cz.pavelchraska.eshop.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    @Autowired
    private UsersDao usersDao;

    public List<User> getAllUsers(){
        return usersDao.getAllUsers();
    }

}
