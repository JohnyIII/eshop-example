package cz.pavelchraska.eshop.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cz.pavelchraska.eshop.dao.OrderedItemsDao;
import cz.pavelchraska.eshop.dao.UserOrderDao;
import cz.pavelchraska.eshop.entity.OrderedItem;
import cz.pavelchraska.eshop.entity.UserOrder;

@Repository
public class OrderedItemsDaoImpl implements OrderedItemsDao{
	
	@Autowired
	private UserOrderDao userOrderDao;

	 @PersistenceContext
	    private EntityManager entityManager;

	@Transactional
	public List<OrderedItem> findByOrder(int id) {
		 Session session = entityManager.unwrap(Session.class);
		 UserOrder order=userOrderDao.findById(id);
		List<OrderedItem> items=session.createCriteria(OrderedItem.class).add(Restrictions.eq("userOrder",order)).setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY).list();
		return items;
	}

}
