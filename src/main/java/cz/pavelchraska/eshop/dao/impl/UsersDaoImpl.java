package cz.pavelchraska.eshop.dao.impl;

import cz.pavelchraska.eshop.dao.UsersDao;
import cz.pavelchraska.eshop.entity.User;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class UsersDaoImpl implements UsersDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List<User> getAllUsers() {
        Session session=entityManager.unwrap(Session.class);

        return session.createCriteria(User.class).setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY).list();
    }
}
