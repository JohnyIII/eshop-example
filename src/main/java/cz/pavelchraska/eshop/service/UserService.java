package cz.pavelchraska.eshop.service;


import cz.pavelchraska.eshop.dao.UserDao;
import cz.pavelchraska.eshop.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public void save(User user) {
        userDao.save(user);
    }

    public User findByName(String name) {
        return userDao.findByName(name);
    }


}
