package tc.ferguev.contactos.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB{
    public ConnectionDB(){
        
    }

    public static Connection createConnection(){
        Connection connection = null;
        try{
            connection = DriverManager.getConnection("jdbc:mariadb://localhost/mustache", "root", null);
        }catch(Exception exception){

        }
        return connection;
    }
}