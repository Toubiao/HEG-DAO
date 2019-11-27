package ch.hegarc.ig.daoPoc.test;

import ch.hegarc.ig.daoPOC.entity.Eleve;
import ch.hegarc.ig.daoPOC.factory.AbstractDaoFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

public class EleveXmlDaoTest {

    @Test
    public void testFindAllSizeShouldBe2618(){
        List<Eleve> eleves = AbstractDaoFactory.getFactory("xml").getEleveDAO().findAll();
        Assertions.assertEquals(eleves.size(),2618);
    }

    @Test
    public void testFind(){
        Eleve eleve = (Eleve) AbstractDaoFactory.getFactory("xml").getEleveDAO().find(2611);
        Assertions.assertEquals(eleve.getPrenom(),"Marianne");
    }

    @Test void testUpdate() {
        Date now = new Date();
        Eleve obj  = new Eleve(332,"38283","Montagnon","Gilbert",now);

        AbstractDaoFactory.getFactory("xml").getEleveDAO().update(obj);

        Assertions.assertTrue(AbstractDaoFactory.getFactory("xml").getEleveDAO().update(obj));
    }

    @Test void testCreate(){
        Date now = new Date();
        Eleve obj  = new Eleve(2618,"38283","Rossi","Stéphane",now);
        Assertions.assertTrue(AbstractDaoFactory.getFactory("xml").getEleveDAO().create(obj));
    }

    @Test void testDelete(){
        Assertions.assertTrue(AbstractDaoFactory.getFactory("xml").getEleveDAO().delete(689));
        testFindAllSizeShouldBe2618();
    }
}
