package com.mycompany.mensajeappI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author bw84
 */

public class Conexion {

    /**
     * Forma de implemmentar el llamado al metodo getConnection.
     *
        Conexion conexions = new Conexion();

        try(Connection cnx = conexions.getConnection()){

        } catch (Exception throwables) {
            throwables.printStackTrace();
            System.out.println(throwables);
        }
    */

    public Connection getConnection(){
        Connection conection = null;

        String url = "jdbc:mysql://localhost:8889/Mensaje_App";
        String user = "root";
        String password = "root";

        try{
            conection = DriverManager.getConnection(url, user, password);
            if(conection != null){
                System.out.println("Preparando Conexion.");
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conection;
    }
}

