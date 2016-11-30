package cz.pavelchraska.eshop.service;

import cz.pavelchraska.eshop.dao.UserOrderDao;
import cz.pavelchraska.eshop.entity.OrderedItem;
import cz.pavelchraska.eshop.entity.UserOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserOrderService {

    @Autowired
    private UserOrderDao userOrderDao;

    public void save(UserOrder userOrder) {
        userOrderDao.save(userOrder);
    }

    public List<UserOrder> findByUsername(String name) {
        return userOrderDao.findByUsername(name);
    }
    public UserOrder findbyId(int id){
    	return userOrderDao.findById(id);
    }

	public UserOrder findByIdWithItems(int id) {
		return userOrderDao.findByIdWithItems(id);
	}
}
