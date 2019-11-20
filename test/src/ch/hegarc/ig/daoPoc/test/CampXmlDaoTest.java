package ch.hegarc.ig.daoPoc.test;

import ch.hegarc.ig.daoPOC.dao.db.CampsDao;
import ch.hegarc.ig.daoPOC.entity.Camp;
import ch.hegarc.ig.daoPOC.factory.AbstractDaoFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class CampXmlDaoTest {

    @Test
    public void testFindAllSizeShouldBe15(){
        List<Camp> camps = AbstractDaoFactory.getFactory("xml").getCampDAO().findAll();
        Assertions.assertEquals(camps.size(),15);
    }

    @Test
    public void testFindShouldBeCharmey(){
        Camp camp = (Camp) AbstractDaoFactory.getFactory("xml").getCampDAO().find(1);
        Assertions.assertEquals(camp.getLieu(),"Charmey");
    }

    @Test void testUpdate() {
        Camp obj  = new Camp(202,"Les Genevez", BigDecimal.valueOf(120),4);

        AbstractDaoFactory.getFactory("xml").getCampDAO().update(obj);

        Assertions.assertTrue(AbstractDaoFactory.getFactory("xml").getCampDAO().update(obj));
    }

    @Test void testCreate(){
        Date now = new Date();
        Camp obj  = new Camp(250,"Neuchatel", BigDecimal.valueOf(110),5);
        Assertions.assertTrue(AbstractDaoFactory.getFactory("xml").getCampDAO().create(obj));
    }
}
