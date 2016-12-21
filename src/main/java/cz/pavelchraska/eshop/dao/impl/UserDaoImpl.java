package cz.pavelchraska.eshop.dao.impl;

import cz.pavelchraska.eshop.dao.RoleDao;
import cz.pavelchraska.eshop.dao.UserDao;
import cz.pavelchraska.eshop.entity.Role;
import cz.pavelchraska.eshop.entity.User;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository

public class UserDaoImpl implements UserDao {

    @Autowired
    private RoleDao roleDao;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public User getById(Integer id) {
        Session session = entityManager.unwrap(Session.class);

        return (User) session.createCriteria(User.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
    }

    @Transactional
    public void save(User user) {
        List<Role> roles= new ArrayList<Role>();
        Role role=roleDao.getById(1);
        roles.add(role);
        user.setRoles(roles);
        entityManager.persist(user);
    }

    @Transactional
    public void saveAdmin(User user){
        entityManager.persist(user);
    }

    @Transactional
    public User findByName(String name) {
        Session session = entityManager.unwrap(Session.class);
User user=(User) session.createCriteria(User.class)
        .add(Restrictions.eq("username", name))
        .uniqueResult();
        return (User) session.createCriteria(User.class)
                .add(Restrictions.eq("username", name))
                .uniqueResult();    }
}
