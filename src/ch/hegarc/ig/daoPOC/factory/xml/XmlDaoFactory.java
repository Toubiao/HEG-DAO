package ch.hegarc.ig.daoPOC.factory.xml;

import ch.hegarc.ig.daoPOC.dao.intf.Dao;
import ch.hegarc.ig.daoPOC.dao.xml.XmlCampsDao;
import ch.hegarc.ig.daoPOC.dao.xml.XmlElevesDao;
import ch.hegarc.ig.daoPOC.factory.AbstractDaoFactory;

public class XmlDaoFactory extends AbstractDaoFactory {

    @Override
    public Dao getEleveDAO() {
        return new XmlElevesDao();
    }

    @Override
    public Dao getCampDAO() {
        return new XmlCampsDao();
    }
}
