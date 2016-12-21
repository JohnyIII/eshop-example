package cz.pavelchraska.eshop.dao.impl;

import cz.pavelchraska.eshop.dao.OrderedItemsDao;
import cz.pavelchraska.eshop.dao.UserDao;
import cz.pavelchraska.eshop.dao.UserOrderDao;
import cz.pavelchraska.eshop.entity.OrderedItem;
import cz.pavelchraska.eshop.entity.User;
import cz.pavelchraska.eshop.entity.UserOrder;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.Order;

import java.util.List;

@Repository

public class UserOrderDaoImpl implements UserOrderDao {

@Autowired
private UserDao userDao;

@Autowired
private OrderedItemsDao orderedItemDao;

    @PersistenceContext
    private EntityManager entityManager;

	@Transactional
    public void save(UserOrder userOrder) {
        entityManager.persist(userOrder);
    }
	@Transactional
	public List<UserOrder> findByUsername(String name) {
        Session session = entityManager.unwrap(Session.class);
        User user=userDao.findByName(name);
        List<UserOrder> list=session.createCriteria(UserOrder.class).add(Restrictions.eq("user",user)).setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY).list();
        return list;
    }
	@Transactional
	public UserOrder findById(int id) {
		 Session session = entityManager.unwrap(Session.class);
		 return (UserOrder)session.createCriteria(UserOrder.class).add(Restrictions.eq("id", id)).uniqueResult();
			}
	@Transactional
	public UserOrder findByIdWithItems(int id) {
		 Session session = entityManager.unwrap(Session.class);
		 UserOrder order= (UserOrder) session.createCriteria(UserOrder.class).add(Restrictions.eq("id", id)).uniqueResult();
		return order;
	}
	
}
