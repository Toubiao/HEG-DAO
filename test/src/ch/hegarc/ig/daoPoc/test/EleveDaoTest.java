package ch.hegarc.ig.daoPoc.test;

import ch.hegarc.ig.daoPOC.dao.db.ElevesDao;
import ch.hegarc.ig.daoPOC.entity.Eleve;
import ch.hegarc.ig.daoPOC.factory.AbstractDaoFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class EleveDaoTest {

    @Test
    public void testFindAllSizeShouldBe2617(){
        List<Eleve> eleves = AbstractDaoFactory.getFactory("db").getEleveDAO().findAll();
        Assertions.assertEquals(eleves.size(),2618);
    }

    @Test
    public void testFindShouldBeStephane(){
        Eleve eleve = ((ElevesDao) AbstractDaoFactory.getFactory("db").getEleveDAO()).find(348);
        String eleveName = "Stephane";
        Assertions.assertTrue(eleve.getPrenom().equals(eleveName));
    }
    @Test
    public void testDeleteShouldBeTrue(){
        Assertions.assertEquals(true,AbstractDaoFactory.getFactory("db").getEleveDAO().delete(4));
    }
    @Test
    public void testFindNextIdShouldBe2620(){
        int nextId = AbstractDaoFactory.getFactory("db").getEleveDAO().findNextId();
        Assertions.assertEquals(nextId,2620);
    }
    @Test
    public void testUpdateEleve(){
        Date now = new Date();
        Eleve obj  = new Eleve(348,"38283","Rossi","Stéphane",now);

        Assertions.assertTrue(AbstractDaoFactory.getFactory("db").getEleveDAO().update(obj));

    }
}
