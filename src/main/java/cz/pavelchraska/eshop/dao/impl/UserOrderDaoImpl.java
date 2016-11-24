package cz.pavelchraska.eshop.dao.impl;

import cz.pavelchraska.eshop.dao.UserDao;
import cz.pavelchraska.eshop.dao.UserOrderDao;
import cz.pavelchraska.eshop.entity.OrderedItem;
import cz.pavelchraska.eshop.entity.User;
import cz.pavelchraska.eshop.entity.UserOrder;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class UserOrderDaoImpl implements UserOrderDao {

@Autowired
private UserDao userDao;
    @PersistenceContext
    private EntityManager entityManager;

    public void save(UserOrder userOrder) {

        entityManager.persist(userOrder);

    }

    public List<UserOrder> findByUsername(String name) {
        Session session = entityManager.unwrap(Session.class);
        User user=userDao.findByName(name);
        List<UserOrder> list=session.createCriteria(UserOrder.class).add(Restrictions.eq("user",user)).list();
        return list;
    }
}
