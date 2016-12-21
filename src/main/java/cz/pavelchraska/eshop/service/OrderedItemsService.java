package cz.pavelchraska.eshop.service;

import cz.pavelchraska.eshop.dao.OrderedItemsDao;
import cz.pavelchraska.eshop.entity.OrderedItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderedItemsService {

    @Autowired
    OrderedItemsDao orderedItemsDao;

    public List<OrderedItem> findByOrder(int id){
        return orderedItemsDao.findByOrder(id);
    }

}
