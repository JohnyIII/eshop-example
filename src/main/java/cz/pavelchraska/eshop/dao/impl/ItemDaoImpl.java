package cz.pavelchraska.eshop.dao.impl;

import cz.pavelchraska.eshop.dao.ItemDao;
import cz.pavelchraska.eshop.entity.Item;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ItemDaoImpl implements ItemDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(Item item) {
        entityManager.persist(item);
    }

    @Transactional
    public List<Item> findAll() {
        Session session = entityManager.unwrap(Session.class);
        List<Item> list = session.createCriteria(Item.class)
                .list();
        return list;
    }
}
