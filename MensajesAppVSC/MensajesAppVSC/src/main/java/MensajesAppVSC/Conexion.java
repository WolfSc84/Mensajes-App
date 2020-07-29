package MensajesAppVSC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author bw84
 */

public class Conexion {

    public Connection get_connection(){
        Connection conection = null;

        String url = "jdbc:mysql://localhost:8889/Mensaje_App";
        String user = "root";
        String password = "root";

        try{
            conection = DriverManager.getConnection(url, user, password);
            if(conection != null){
                System.out.println("Conexion exitosa");
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println(throwables);
        }
        return conection;
    }
}

