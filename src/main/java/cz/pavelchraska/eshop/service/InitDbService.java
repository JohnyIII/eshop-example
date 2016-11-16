package cz.pavelchraska.eshop.service;

import cz.pavelchraska.eshop.dao.ItemDao;
import cz.pavelchraska.eshop.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Transactional
@Service
public class InitDbService {

    @Autowired
    private ItemDao itemDao;

    @PostConstruct
    public void init() {
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
        item2.setQuantity(5);
        itemDao.save(item2);

    }
}
