package ch.hegarc.ig.daoPoc.test;

import ch.hegarc.ig.daoPOC.entity.Eleve;
import ch.hegarc.ig.daoPOC.factory.AbstractDaoFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.List;

public class EleveDaoTest {

    @Test
    public void testFindAllSizeShouldBe2617(){
        List<Eleve> eleves = AbstractDaoFactory.getFactory("db").getEleveDAO().findAll();
        Assertions.assertEquals(eleves.size(),2617);
    }

    @Test
    public void testDeleteShouldBeTrue(){
        Assertions.assertEquals(true,AbstractDaoFactory.getFactory("db").getEleveDAO().delete(3));

    }
}
