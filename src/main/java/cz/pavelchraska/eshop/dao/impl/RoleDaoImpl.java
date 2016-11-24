package cz.pavelchraska.eshop.dao.impl;


import cz.pavelchraska.eshop.dao.RoleDao;
import cz.pavelchraska.eshop.entity.Role;
import cz.pavelchraska.eshop.entity.User;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Role roleUser) {
        entityManager.persist(roleUser);
    }

    public Role getById(int id) {
        Session session = entityManager.unwrap(Session.class);

        return (Role) session.createCriteria(Role.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
    }
}
