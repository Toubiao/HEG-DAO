package ch.hegarc.ig.daoPoc.test;

import ch.hegarc.ig.daoPOC.dao.db.CampsDao;
import ch.hegarc.ig.daoPOC.entity.Camp;
import ch.hegarc.ig.daoPOC.factory.AbstractDaoFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CampDaoTest {

    @Test
    public void testFindAllSizeShouldBe?(){
        List<Camp> eleves = AbstractDaoFactory.getFactory("db").getEleveDAO().findAll();
        Assertions.assertEquals(eleves.size(),?);
    }

    @Test
    public void testFindShouldBe?(){
        Camp camp = ((CampsDao) AbstractDaoFactory.getFactory("db").getCampDAO()).find(12);
        String campLieu = "?";
        Assertions.assertTrue(camp.getLieu().equals(campLieu));
    }
    @Test
    public void testDeleteShouldBeTrue(){
        Assertions.assertEquals(true,AbstractDaoFactory.getFactory("db").getCampDAO().delete(3));
    }

    @Test
    public void testUpdateCamp(){
        Date now = new Date();
        Camp obj  = new Camp();

        Assertions.assertTrue(AbstractDaoFactory.getFactory("db").getCampDAO().update(obj));

    }
}
