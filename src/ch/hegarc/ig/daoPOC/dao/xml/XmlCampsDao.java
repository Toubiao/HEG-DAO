package ch.hegarc.ig.daoPOC.dao.xml;

import ch.hegarc.ig.daoPOC.dao.intf.Dao;
import ch.hegarc.ig.daoPOC.entity.Camps;
import ch.hegarc.ig.daoPOC.entity.Eleve;

import java.util.List;

public class XmlCampsDao implements Dao<Camps> {

    @Override
    public boolean create(Camps obj) {
        return false;
    }

    @Override
    public boolean delete(int nb) {
        return false;
    }

    @Override
    public boolean update(Camps obj) {
        return false;
    }

    @Override
    public Camps find(int id) {
        return null;
    }

    @Override
    public List<Camps> findAll() {
        return null;
    }
}
