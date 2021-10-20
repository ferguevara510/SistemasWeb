package tc.ferguev.contactos.model;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import tc.ferguev.contactos.database.ConnectionDB;

public class Contacto {
    public String nombre;
    public String telefono;

    public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public String getTelefono(){
        return this.telefono;
    }

    public void setTelefono(String telefono){
        this.telefono = telefono;
    }

    public static List<Contacto> obtenerContactos(){
        Connection connection = ConnectionDB.createConnection();
        List<Contacto> contactos = new ArrayList<>();
        Contacto contacto = null;
        try {
            PreparedStatement query = connection.prepareStatement("select * from contacto");
            
            ResultSet result = query.executeQuery();
            while(result.next()){
                contacto = new Contacto();
                contacto.setNombre(result.getString("nombre"));
                contacto.setTelefono(result.getString("telefono"));
                contactos.add(contacto);
            }
            result.close();
        } catch (SQLException ex) {
            
        }
        return contactos;
    }
}
