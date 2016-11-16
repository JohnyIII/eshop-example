package cz.pavelchraska.eshop.dao;

import cz.pavelchraska.eshop.entity.Item;

import java.util.List;

public interface ItemDao {

    void save(Item item);

    List<Item> findAll();
}