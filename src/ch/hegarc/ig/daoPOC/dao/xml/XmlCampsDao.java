package ch.hegarc.ig.daoPOC.dao.xml;

import ch.hegarc.ig.daoPOC.dao.intf.Dao;
import ch.hegarc.ig.daoPOC.entity.Camp;

import java.util.List;

public class XmlCampsDao implements Dao<Camp> {

    @Override
    public boolean create(Camp obj) {
        return false;
    }

    @Override
    public boolean delete(int nb) {
        return false;
    }

    @Override
    public boolean update(Camp obj) {
        return false;
    }

    @Override
    public Camp find(int id) {
        return null;
    }

    @Override
    public List<Camp> findAll() {
        return null;
    }
    @Override
    public int findNextId() {
        return 0;
    }
}
