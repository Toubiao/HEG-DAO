package ch.hegarc.ig.daoPoc.test;

import ch.hegarc.ig.daoPOC.dao.db.CampsDao;
import ch.hegarc.ig.daoPOC.entity.Camp;
import ch.hegarc.ig.daoPOC.factory.AbstractDaoFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CampDaoTest {

    @Test
    public void testFindAllSizeShouldBe15(){
        List<Camp> camps = AbstractDaoFactory.getFactory("db").getCampDAO().findAll();
        Assertions.assertEquals(camps.size(),15);
    }

    @Test
    public void testFindShouldBeCharmey(){
        Camp camp = ((CampsDao) AbstractDaoFactory.getFactory("db").getCampDAO()).find(1);
        String campLieu = "Charmey";
        Assertions.assertTrue(camp.getLieu().equals(campLieu));
    }
    @Test
    public void testDeleteShouldBeTrue(){
        Assertions.assertEquals(true,AbstractDaoFactory.getFactory("db").getCampDAO().delete(202));
        // Marche si la PK n'est pas contenue dans la table inscrit
    }

    @Test
    public void testUpdateCamp(){
        Camp obj  = new Camp(202,"Les Genevez", BigDecimal.valueOf(120),4);
        Assertions.assertTrue(AbstractDaoFactory.getFactory("db").getCampDAO().update(obj));
    }
}
