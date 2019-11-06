package ch.hegarc.ig.daoPOC.factory;

import ch.hegarc.ig.daoPOC.dao.intf.Dao;
import ch.hegarc.ig.daoPOC.factory.db.DaoFactory;
import ch.hegarc.ig.daoPOC.factory.xml.XmlDaoFactory;

public abstract class AbstractDaoFactory {

    public static final String DAO_FACTORY = "db";
    public static final String XML_DAO_FACTORY = "xml";

    public abstract Dao getEleveDAO();

    public abstract Dao getCampDAO();

    public static AbstractDaoFactory getFactory(String type){
        switch(type){
            case DAO_FACTORY:
                return new DaoFactory();
            case XML_DAO_FACTORY:
                return new XmlDaoFactory();
            default:
                return null;
        }
    }
}
