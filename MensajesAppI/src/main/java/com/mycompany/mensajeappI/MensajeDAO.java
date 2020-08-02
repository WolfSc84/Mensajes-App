package com.mycompany.mensajeappI;

import com.mysql.cj.protocol.Resultset;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public abstract class MensajeDAO {

    public static void crearMensajeDB(Mensaje mensajeReady){
        Conexion dbconnect = new Conexion();
        //Permite preparar el proceso de escritura en la DB para su ejecucion.
        PreparedStatement pse;
        //Preparo la peticion especifica para crear la declaracion
        String query = "INSERT INTO Mensaje_App (message,author_message) VALUES (?,?)";

        try (Connection cnxe = dbconnect.getConnection()) {
            System.out.println("Conexion Exitosa.");
            try {
                //Prepara la declaracion con la peticion especifica
                pse = cnxe.prepareStatement(query);
                //Preparo el dato especifico desde la variable que lo almacena, indicando el index de dicho campo en la fila de la DB donde se almacenara la informacion
                pse.setString(1, mensajeReady.getMessage());
                //Preparo el dato especifico desde la variable que lo almacena, indicando el index de dicho campo en la fila de la DB donde se almacenara la informacion
                pse.setString(2, mensajeReady.getAuthorMessage());
                //Ejecutamos las declaraciones establecidas previamente configuradas
                pse.executeUpdate();
                System.out.println("Mensaje creado correctamente.");
            }catch(SQLException ex) {
                System.out.println("Error!!");
            }
        } catch (Exception throwables) {
            System.out.println("Error en la conexion!!.");
            throwables.printStackTrace();
        }


    }

    public static void leerMensajesDB(){
        Conexion dbconnect = new Conexion();
        //Permite preparar el proceso de escritura en la DB para su ejecucion.
        PreparedStatement psl;
        //Permite traer datos en fila para procesarlos y mostrarlos.
        ResultSet rs;
        //Preparo la peticion especifica para crear la declaracion
        String query = "SELECT * FROM Mensaje_App";

        try (Connection cnxl = dbconnect.getConnection()) {
            System.out.println("Conexion Exitosa.");

            try {
                //Prepara la declaracion con la peticion especifica
                psl = cnxl.prepareStatement(query);
                //Pedimos datos. Ejecutamos la declaracion previamente configurada
                rs = psl.executeQuery();

                while (rs.next()) {
                    System.out.println("\n----------------------------------------------------------\n");
                    System.out.println("ID: " + rs.getInt("id_message"));
                    System.out.println("Autor del mensaje: " + rs.getString("author_message"));
                    System.out.println("Mensaje: " + rs.getString("message"));
                    System.out.println("Fecha de creacion del mensaje: " + rs.getDate("date_message"));
                    System.out.println("\n----------------------------------------------------------\n");
                }
            }catch(SQLException ex){
                System.out.println("Error!! No se pudo recuperar la informacion.");
            }
        } catch (SQLException throwables) {
            System.out.println("Error en la conexion!!.");
            throwables.printStackTrace();
        }

    }

    public static void borrarMensajesDB(int idMensaje){
        Conexion dbconnect = new Conexion();
        //Permite preparar el proceso de escritura en la DB para su ejecucion.
        PreparedStatement psd;
        //Preparo la peticion especifica para crear la declaracion
        String query = "DELETE FROM Mensaje_App WHERE id_message = ?";


        try (Connection cnxd = dbconnect.getConnection()) {
            System.out.println("Conexion Exitosa.");

            try {
                //Prepara la declaracion con la peticion especifica
                psd = cnxd.prepareStatement(query);
                //Indicamos el id del mensaje que se va eliminar
                psd.setInt(1,idMensaje);
                //Procedemos a ejecutar la declaracion establecida con los parametros previamente configurados
                psd.executeUpdate();
                System.out.println("Mensaje eliminado correctamente!");

            }catch(SQLException ex){
                System.out.println("Error!! No se pudo eliminar la informacion.");
            }
        } catch (SQLException throwables) {
            System.out.println("Error en la conexion!!.");
            throwables.printStackTrace();
        }


    }

    public static void actualizarMensajesDB(Mensaje mensaje){
        Conexion dbconnect = new Conexion();
        //Permite preparar el proceso de escritura en la DB para su ejecucion.
        PreparedStatement psm;
        //Preparo la peticion especifica para crear la declaracion
        String query = "UPDATE Mensaje_App SET message = ? WHERE id_message = ?";


        try (Connection cnxm = dbconnect.getConnection()) {
            System.out.println("Conexion Exitosa.");

            try {
                //Prepara la declaracion con la peticion especifica
                psm = cnxm.prepareStatement(query);
                //Preparo el dato especifico desde la variable que lo almacena, indicando el index de dicho campo en la fila de la DB donde se almacenara la informacion
                psm.setString(1, mensaje.getMessage());
                //Preparo el dato especifico desde la variable que lo almacena, indicando el index de dicho campo en la fila de la DB donde se almacenara la informacion
                psm.setInt(2, mensaje.getIdMessage());
                //Ejecutamos las declaraciones establecidas previamente configuradas
                psm.executeUpdate();

                System.out.println("Mensaje modificado correctamente!");

            }catch(SQLException ex){
                System.out.println("Error!! No se pudo modificar la informacion.");
            }
        } catch (SQLException throwables) {
            System.out.println("Error en la conexion!!.");
            throwables.printStackTrace();
        }


    }

}
