package ch.hegarc.ig.daoPOC.dao.db;

import ch.hegarc.ig.daoPOC.dao.intf.Dao;
import ch.hegarc.ig.daoPOC.entity.Camps;
import ch.hegarc.ig.daoPOC.manager.ConnectionManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

    public class CampsDAO implements Dao<Camps> {

        @Override
        public boolean create(Camps obj) {
            return false;
        }

        @Override
        public boolean delete(int nb) {
            try {
                int result = ConnectionManager.getConnection().createStatement(
                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_UPDATABLE).executeUpdate(
                        "DELETE FROM camps WHERE numero = " + nb);
                return 1 == result;

            } catch (SQLException e) {
                e.printStackTrace();
            }
            ConnectionManager.closeConnection();

            return false;
        }

        @Override
        public boolean update(Camps obj) {
            boolean retour = false;
            try {
                int result = ConnectionManager.getConnection().createStatement(
                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_UPDATABLE).executeUpdate("UPDATE camps SET lieu = "+obj.getLieu()+", prix = "+obj.getPrix()+", max_place = "+obj.getMaxPlaces()+
                        " WHERE numero="+obj.getNumber()+")");

                retour = (result ==1);


            } catch (SQLException e) {
                e.printStackTrace();
            }

            return retour;



        }

        @Override
        public Camps find(int id){
            try{
                List<Camps> camps = new ArrayList<>(1);
                ResultSet result = ConnectionManager.getConnection().createStatement(
                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT Numero as \"num\",Lieu as \"lieu\",Prix as \"prix\",Max_place as \"max\" \n" +
                        "FROM Camps WHERE Numero = "+id );

                if (result.first()) {
                    deserializeCamps(camps ,result);
                }
                return camps.get(0);
            } catch (SQLException e){
                e.printStackTrace();
            }
            // On ferme la connection
            ConnectionManager.closeConnection();

            return null;
        }

        @Override
        public List<Camps> findAll() {
            List<Camps> camps = new ArrayList<>();
            try {
                ResultSet result = ConnectionManager.getConnection().createStatement(
                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT Numero as \"num\",Lieu as \"lieu\",Prix as \"prix\",Max_place as \"max\" \n" +
                        "FROM Camps");
                if (result.first()) {
                    deserializeCamps(camps, result);
                    while (result.next()) {
                        deserializeCamps(camps, result);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            ConnectionManager.closeConnection();
            return camps;
        }

        private void deserializeCamps(List<Camps> camps, ResultSet result) throws SQLException {
            Camps aCamps;
            aCamps = new Camps(
                    result.getInt(1),
                    result.getString(2),
                    result.getBigDecimal(3),
                    result.getInt(4)
            );
            camps.add(aCamps);
        }
    }
