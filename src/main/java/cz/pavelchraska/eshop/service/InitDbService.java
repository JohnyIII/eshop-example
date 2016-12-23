package cz.pavelchraska.eshop.service;

import cz.pavelchraska.eshop.dao.ItemDao;
import cz.pavelchraska.eshop.dao.RoleDao;
import cz.pavelchraska.eshop.dao.UserDao;
import cz.pavelchraska.eshop.entity.Item;
import cz.pavelchraska.eshop.entity.Role;
import cz.pavelchraska.eshop.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        userAdmin.setRole(roles);
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
        item.setImage_url("resources/DMC.png");
        item.setPrice(155);
        itemDao.save(item);

        Item item2 = new Item();
        item2.setName("Metal gear solid 5 Phantom pain");
        item2.setDescription("Metal Gear Solid V: The Phantom Pain[b] is an open world action-adventure stealth video game" +
                " developed by Kojima Productions and published by Konami for Microsoft Windows, PlayStation 3, PlayStation 4," +
                " Xbox 360 and Xbox One. It was released worldwide on September 1, 2015. It is the ninth and final installment " +
                "in the series directed, written and designed by Hideo Kojima following Metal Gear Solid V: Ground Zeroes, " +
                "a stand-alone prologue released the previous year, as well as his final work prior to his departure from Konami.");
        item2.setImage_url("resources/Mgs5.png");
        item2.setPrice(200);
        itemDao.save(item2);
        Item item3 = new Item();
        item3.setName("Metal Gear Solid 4: Guns of the Patriots");
        item3.setDescription("Metal Gear Solid 4: Guns of the Patriots[a] is an action-adventure stealth video game developed by" +
                " Kojima Productions and published by Konami exclusively for the PlayStation 3 console. It is the sixth Metal Gear game " +
                "directed by Hideo Kojima and was released worldwide on June 12, 2008.");
        item3.setImage_url("resources/Mgs4.jpg");
        item3.setPrice(180);
        itemDao.save(item3);
        Item item4 = new Item();
        item4.setName("The Witcher 3: Wild Hunt");
        item4.setDescription("The Witcher 3: Wild Hunt[a] is an open world action role-playing video game developed by CD Projekt RED." +
                " Announced in February 2013, it was released worldwide for Microsoft Windows, PlayStation 4, and Xbox One on 19 May 2015. " +
                "The game is the third in the series, preceded by The Witcher and The Witcher 2: Assassins of Kings, which are based on the " +
                "series of fantasy novels by Polish author Andrzej Sapkowski.");
        item4.setImage_url("resources/Witcher3.jpg");
        item4.setPrice(280);
        itemDao.save(item4);

    }
}
