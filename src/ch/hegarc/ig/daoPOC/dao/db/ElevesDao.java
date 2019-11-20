package ch.hegarc.ig.daoPOC.dao.db;


import ch.hegarc.ig.daoPOC.dao.intf.Dao;
import ch.hegarc.ig.daoPOC.entity.Eleve;
import ch.hegarc.ig.daoPOC.manager.ConnectionManager;

import javax.xml.transform.Result;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ElevesDao implements Dao<Eleve> {

    @Override
    public boolean create(Eleve obj) {
        try {
            DateFormat dt1 = new SimpleDateFormat("dd.MM.yy");
            int result = ConnectionManager.getConnection().createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeUpdate( "INSERT INTO Eleves (numero, matricule, nom, prenom, Date_Naiss, num_clas) VALUES (" + obj.getNumber() + ",\'" + obj.getMatricule() + "\',\'" + obj.getNom() + "\',\'" + obj.getPrenom() + "\',\'" + dt1.format(obj.getDateNaiss())+"\',\'2\'   )");
            return result == 1;

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public int findNextId() {
        ResultSet result;
        try {
            PreparedStatement pStmnt = ConnectionManager.getConnection().prepareStatement(
                "SELECT max(numero)+1 as \"next\" FROM eleves"
            );
            result = pStmnt.executeQuery();
            return result.getInt(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        ConnectionManager.closeConnection();
        return 0;
    }


    @Override
    public boolean delete(int nb) {
        try {
            int result = ConnectionManager.getConnection().createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE).executeUpdate(
                    "DELETE FROM eleves WHERE numero = " + nb);
            return 1 == result;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        ConnectionManager.closeConnection();

        return false;
    }

    @Override
    public boolean update(Eleve obj) {
        boolean retour = false;
        int result;
        try {
            DateFormat dt1 = new SimpleDateFormat("dd.MM.yy");
            PreparedStatement pStmnt = ConnectionManager.getConnection().prepareStatement("UPDATE eleves SET matricule = ?, nom = ?, prenom =?, date_naiss = ? WHERE numero=?");
            pStmnt.setString(1,obj.getMatricule());
            pStmnt.setString(2,obj.getNom());
            pStmnt.setString(3,obj.getPrenom());
            pStmnt.setString(4,dt1.format(obj.getDateNaiss()));
            pStmnt.setInt(5,obj.getNumber());
            result = pStmnt.executeUpdate();
            retour = (result == 1);
            return retour;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return retour;



    }

    @Override
    public Eleve find(int id) {
        Eleve eleve = new Eleve();
        try {
            ResultSet result;
            PreparedStatement pStmnt = ConnectionManager.getConnection().prepareStatement("SELECT E.Numero as \"num\",E.Matricule as \"matr\",E.Nom as \"nom\",E.Prenom as \"pren\",E.Date_Naiss as \"datenaiss\" \n" +
                    "FROM Eleves e WHERE E.Numero = ? ");
            pStmnt.setInt(1, id);
            result = pStmnt.executeQuery();

            if (result.first()) {
                return newEleve(result);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        // On ferme la connection
        ConnectionManager.closeConnection();

        return eleve;
    }

    @Override
    public List<Eleve> findAll() {
        List<Eleve> eleves = new ArrayList<>();
        try {
            ResultSet result;
            PreparedStatement pStmnt = ConnectionManager.getConnection().prepareStatement(
                    "SELECT E.Numero as \"num\",E.Matricule as \"matr\",E.Nom as \"nom\",E.Prenom as \"pren\",E.Date_Naiss as \"datenaiss\" \n" +
                    "FROM Eleves e");
            result = pStmnt.executeQuery();

            if (result.first()) {
                deserializeEleve(eleves, result);
                while (result.next()) {
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
        eleve = newEleve(result);
        eleves.add(eleve);
    }

    private Eleve newEleve(ResultSet result) throws SQLException {
        Eleve eleve;
        eleve = new Eleve(
                result.getInt(1),
                result.getString(2),
                result.getString(3),
                result.getString(4),
                result.getDate(5)
        );
        return eleve;
    }

}
