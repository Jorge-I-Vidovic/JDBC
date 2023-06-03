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
    private static final String SQL_INSERT = "INSERT INTO test.persona (nombre, apellido, email, telefono) VALUES (?,?.?,?)";

    public List<Persona> seleccionar() {
        Connection con;
        PreparedStatement pst;
        ResultSet rs;
        Persona persona;
        List<Persona> personas = new ArrayList<>();

        try {
            con = getConnection();
            pst = con.prepareStatement(SQL_SELECT);
            rs = pst.executeQuery();

            int idPersona;
            String nombre;
            String apellido;
            String email;
            int tlf;

            while (rs.next()) {
                idPersona = rs.getInt("id_persona");
                nombre = rs.getString("nombre");
                apellido = rs.getString("apellido");
                email = rs.getString("email");
                tlf = rs.getInt("telefono");
                persona = new Persona(idPersona, nombre, apellido, email, tlf);
                personas.add(persona);
            }
            close(rs);
            close(pst);
            close(con);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return personas;
    }


    public int insertar(Persona persona) {
        Connection con;
        PreparedStatement pst;
        int registros = 0;

        try {
            con = getConnection();
            pst = con.prepareStatement(SQL_INSERT);
            pst.setString(1, persona.getNombre());
            pst.setString(2, persona.getApellido());
            pst.setString(3, persona.getEmail());
            pst.setInt(4, persona.getTlf());
            registros = pst.executeUpdate();

            close(pst);
            close(con);
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return registros;
    }
}
