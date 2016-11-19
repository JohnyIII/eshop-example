package cz.pavelchraska.eshop.domain;

import cz.pavelchraska.eshop.entity.Item;
import cz.pavelchraska.eshop.entity.OrderedItem;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;

public class Basket implements Serializable {

    private HashMap<Integer, OrderedItem> items = new HashMap<Integer, OrderedItem>();

    public void add(Item item, int quantity) {
        int id = item.getId();
        if (items.containsKey(id)) {
            OrderedItem orderedItem = items.get(id);
            orderedItem.setQuantity(orderedItem.getQuantity() + quantity);
        } else {
            OrderedItem orderedItem = new OrderedItem();
            orderedItem.setQuantity(quantity);
            orderedItem.setItem(item);
            items.put(item.getId(), orderedItem);
        }
    }

    public Collection<OrderedItem> getItems() {
        return items.values();
    }

    public void remove(int id) {
        items.remove(id);
    }

    public void clear() {
        items.clear();
    }
}
