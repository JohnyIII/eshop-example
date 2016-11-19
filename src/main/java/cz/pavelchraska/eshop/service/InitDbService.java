package cz.pavelchraska.eshop.service;

import cz.pavelchraska.eshop.dao.ItemDao;
import cz.pavelchraska.eshop.dao.RoleDao;
import cz.pavelchraska.eshop.dao.UserDao;
import cz.pavelchraska.eshop.entity.Item;
import cz.pavelchraska.eshop.entity.Role;
import cz.pavelchraska.eshop.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class InitDbService {

    @Autowired
    private ItemDao itemDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private UserDao userDao;

    @PostConstruct
    public void init() {
        Role roleUser = new Role();
        roleUser.setName("ROLE_USER");
        roleDao.save(roleUser);

        Role roleAdmin = new Role();
        roleAdmin.setName("ROLE_ADMIN");
        roleDao.save(roleAdmin);

        User userAdmin = new User();
        userAdmin.setName("Pavel Chraska");
        List<Role> roles = new ArrayList<Role>();
        roles.add(roleAdmin);
        roles.add(roleUser);
        userAdmin.setRoles(roles);
        userAdmin.setPassword(new BCryptPasswordEncoder().encode("admin"));
        userAdmin.setEnabled(true);
        userAdmin.setEmail("admin@admin.cz");
        userAdmin.setUsername("admin");
        userDao.saveAdmin(userAdmin);

        Item item = new Item();
        item.setName("DMC : Devil may cry");
        item.setDescription("DmC: Devil May Cry is an action-adventure hack and slash video game developed by Ninja Theory " +
                "and published by Capcom for PlayStation 3, Xbox 360 and Microsoft Windows. It is the fifth instalment of the " +
                "Devil May Cry series, serving as a reboot. Announced in late 2010 during the Tokyo Game Show, the game is" +
                " set in an alternate reality in the Devil May Cry series.");
        item.setImage_url("images/DMC.png");
        item.setPrice(155);
        item.setQuantity(5);
        itemDao.save(item);

        Item item2 = new Item();
        item2.setName("Metal gear solid 5 Phantom pain");
        item2.setDescription("Metal Gear Solid V: The Phantom Pain[b] is an open world action-adventure stealth video game" +
                " developed by Kojima Productions and published by Konami for Microsoft Windows, PlayStation 3, PlayStation 4," +
                " Xbox 360 and Xbox One. It was released worldwide on September 1, 2015. It is the ninth and final installment " +
                "in the series directed, written and designed by Hideo Kojima following Metal Gear Solid V: Ground Zeroes, " +
                "a stand-alone prologue released the previous year, as well as his final work prior to his departure from Konami.");
        item2.setImage_url("images/Mgs5.png");
        item2.setPrice(200);
        item2.setQuantity(0);
        itemDao.save(item2);

    }
}
