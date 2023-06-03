package datos;

import domain.Persona;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import static datos.Conexion.*;

public class PersonaDAO {
    private static final String SQL_SELECT = "SELECT * FROM test.persona";

    public List<Persona> seleccionar() {
        Persona persona;
        List<Persona> personas = new ArrayList<>();

        try{
            Connection con = getConnection();
            PreparedStatement pst = con.prepareStatement(SQL_SELECT);
            ResultSet rs = pst.executeQuery();
            int idPersona = rs.getInt("id_persona");
            String nombre = rs.getString("nombre");
            String apellido = rs.getString("apellido");
            String email = rs.getString("email");
            int tlf = rs.getInt("telefono");

            while (rs.next()){
                persona = new Persona(idPersona, nombre, apellido, email, tlf);
                personas.add(persona);
            }
            Conexion.close(con);
        } catch (SQLException ex){
            ex.printStackTrace(System.out);
        }
        return personas;
    }
}
