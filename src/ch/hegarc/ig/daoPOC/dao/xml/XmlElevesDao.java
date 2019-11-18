package ch.hegarc.ig.daoPOC.dao.xml;

import ch.hegarc.ig.daoPOC.dao.intf.Dao;
import ch.hegarc.ig.daoPOC.entity.Eleve;

import java.util.List;

public class XmlElevesDao implements Dao<Eleve> {

    @Override
    public boolean create(Eleve obj) {
        return false;
    }

    @Override
    public boolean delete(int nb) {
        return false;
    }

    @Override
    public boolean update(Eleve obj) {
        return false;
    }

    @Override
    public Eleve find(int id) {
        return null;
    }

    @Override
    public List<Eleve> findAll() {
        return null;
    }

    @Override
    public int findNextId(){return 0;};
}
