package ch.hegarc.ig.daoPOC.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static final String DBURL = "jdbc:oracle:thin:@db.ig.he-arc.ch:1521:ens";
    private static final String DBUSER = "OUSSAMA_TOUBIA";
    private static final String DBPWD = "OUSSAMA_TOUBIA";
    private static Connection cnn;


    public static void openConnection(){
        try{
            cnn = DriverManager.getConnection(DBURL,DBUSER,DBPWD);
            cnn.setAutoCommit(false);
        } catch (SQLException e) {
            //TODO: log ex
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        openConnection();

        return cnn;
    }


    public static void closeConnection(){
        try {
            cnn.close();
        } catch (SQLException e) {
            //TODO: log ex
            e.printStackTrace();
        }
    }
}
