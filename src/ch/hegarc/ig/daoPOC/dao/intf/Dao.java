package ch.hegarc.ig.daoPOC.dao.intf;

import ch.hegarc.ig.daoPOC.entity.Eleve;

import java.util.List;

public interface Dao<T> {

    boolean create(Eleve obj);
    boolean delete(Eleve obj);
    boolean update(Eleve obj);
    T find(int id);
    List<T> findAll();

}
