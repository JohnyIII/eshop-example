package cz.pavelchraska.eshop.service;

import cz.pavelchraska.eshop.dao.ItemDao;
import cz.pavelchraska.eshop.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ItemService {

    @Autowired
    private ItemDao itemDao;

    public List<Item> findAll() {
        return itemDao.findAll();
    }

    public Item findById(int id) {
        return (Item) itemDao.getById(id);
    }
}
