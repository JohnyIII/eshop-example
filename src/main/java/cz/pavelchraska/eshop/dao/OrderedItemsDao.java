package cz.pavelchraska.eshop.dao;

import java.util.List;

import cz.pavelchraska.eshop.entity.OrderedItem;

public interface OrderedItemsDao {

	 List<OrderedItem> findByOrder(int id);


}
