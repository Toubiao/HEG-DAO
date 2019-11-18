package ch.hegarc.ig.daoPOC.dao.db;

import ch.hegarc.ig.daoPOC.dao.intf.Dao;
import ch.hegarc.ig.daoPOC.entity.Camp;
import ch.hegarc.ig.daoPOC.manager.ConnectionManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CampsDao implements Dao<Camp> {

    @Override
    public boolean create(Camp obj) {
        return false;
    }

    @Override
    public boolean delete(int nb) {
        return true;
    }

    @Override
    public boolean update(Camp obj) {
        return true;
    }

    @Override
    public Camp find(int id) {
        return null;
    }

    @Override
    public List<Camp> findAll() {
        return null;
    }
}
