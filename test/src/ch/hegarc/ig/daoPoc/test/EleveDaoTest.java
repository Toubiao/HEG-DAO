package ch.hegarc.ig.daoPoc.test;

import ch.hegarc.ig.daoPOC.entity.Eleve;
import ch.hegarc.ig.daoPOC.factory.AbstractDaoFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class EleveDaoTest {

    @Test
    public void testFindAllSizeShouldBe2617(){
        List<Eleve> eleves = AbstractDaoFactory.getFactory("db").getEleveDAO().findAll();
        Assertions.assertEquals(eleves.size(),2617);
    }

    @Test
    public void testUpdateEleve(){
        Date now = new Date();
        DateFormat dt1 = new SimpleDateFormat("dd.MM.yyyy");
        System.out.println("Format dd.MM.yyyy : " + dt1.format(now));

        Eleve obj = new Eleve(348,"38283","Rossi","Stéphane",now);


        if(AbstractDaoFactory.getFactory("db").getEleveDAO().update(obj)){
            System.out.println("Test successed...");
        }else {
            System.out.println("Test failed...");
        }
    }
}
