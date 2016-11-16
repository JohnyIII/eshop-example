package cz.pavelchraska.eshop.dao;

import cz.pavelchraska.eshop.entity.Role;


public interface RoleDao {
    void save(Role roleUser);

    Role getById(int i);
}
