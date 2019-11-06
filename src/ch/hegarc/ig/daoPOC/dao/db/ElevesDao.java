package ch.hegarc.ig.daoPOC.dao.db;


import ch.hegarc.ig.daoPOC.dao.intf.Dao;
import ch.hegarc.ig.daoPOC.entity.Eleve;
import ch.hegarc.ig.daoPOC.manager.ConnectionManager;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ElevesDao implements Dao<Eleve> {

    @Override
    public boolean create(Eleve obj) {
        return false;
    }

    @Override
    public boolean delete(Eleve obj) {
        return false;
    }

    @Override
    public boolean update(Eleve obj) {
        boolean retour = false;
        try {
            int result = ConnectionManager.getConnection().createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE).executeUpdate("UPDATE eleves SET matricule = "+obj.getMatricule()+", nom = "+obj.getNom()+", prenom = "+obj.getPrenom()+", date_naiss="+obj.getDateNaiss()+" WHERE numero="+obj.getNumber()+"");

            retour = (result ==1);


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return retour;



    }

    @Override
    public Eleve find(int id) {
        return null;
    }

    @Override
    public List<Eleve> findAll() {
        List<Eleve> eleves = new ArrayList<>();
        try {
            ResultSet result = ConnectionManager.getConnection().createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT E.Numero as \"num\",E.Matricule as \"matr\",E.Nom as \"nom\",E.Prenom as \"pren\",E.Date_Naiss as \"datenaiss\" \n" +
                    "FROM Eleves e");
            if(result.first()) {
                deserializeEleve(eleves, result);
                while (result.next()){
                    deserializeEleve(eleves, result);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ConnectionManager.closeConnection();
        return eleves;
    }

    private void deserializeEleve(List<Eleve> eleves, ResultSet result) throws SQLException {
        Eleve eleve;
        eleve = new Eleve(
                result.getInt(1),
                result.getString(2),
                result.getString(3),
                result.getString(4),
                result.getDate(5)
        );
        eleves.add(eleve);
    }
}
