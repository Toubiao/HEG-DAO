package ch.hegarc.ig.daoPOC.factory.db;

import ch.hegarc.ig.daoPOC.dao.db.CampsDao;
import ch.hegarc.ig.daoPOC.dao.db.ElevesDao;
import ch.hegarc.ig.daoPOC.dao.intf.Dao;
import ch.hegarc.ig.daoPOC.factory.AbstractDaoFactory;

public class DaoFactory extends AbstractDaoFactory {

    @Override
    public Dao getEleveDAO() {
        return new ElevesDao();
    }

    @Override
    public Dao getCampDAO() {
        return new CampsDao();
    }
}
