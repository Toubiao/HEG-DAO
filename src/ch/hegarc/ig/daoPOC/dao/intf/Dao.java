package ch.hegarc.ig.daoPOC.dao.intf;

import ch.hegarc.ig.daoPOC.entity.Eleve;

import java.util.List;

public interface Dao<T> {

    boolean create(T obj);
    boolean delete(int nb);
    boolean update(T obj);
    T find(int id);
    List<T> findAll();

}
