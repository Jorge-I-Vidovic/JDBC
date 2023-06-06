package datos;

import domain.PersonaDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import static datos.Conexion.*;

public class PersonaDAO implements Persona_Interface {
    private Connection conexionTransaccional;
    private static final String SQL_SELECT = "SELECT * FROM test.persona";
    private static final String SQL_INSERT = "INSERT INTO test.persona (nombre, apellido, email, telefono) VALUES (?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE test.persona SET nombre = ?, apellido = ?, email = ?, telefono = ? WHERE id_persona = ?";
    private static final String SQL_DELETE = "DELETE FROM test.persona WHERE id_persona = ?";

    public PersonaDAO() {
    }

    public PersonaDAO(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    }

    public List<PersonaDTO> seleccionar() {
        Connection con;
        PreparedStatement pst;
        ResultSet rs;
        PersonaDTO personaDTO;
        List<PersonaDTO> personaDTOS = new ArrayList<>();

        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
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
                personaDTO = new PersonaDTO(idPersona, nombre, apellido, email, tlf);
                personaDTOS.add(personaDTO);
            }
            close(rs);
            close(pst);
            if (this.conexionTransaccional == null) {
                close(con);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return personaDTOS;
    }


    public int insertar(PersonaDTO personaDTO) {
        Connection con;
        PreparedStatement pst;
        int registros = 0;

        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
            pst = con.prepareStatement(SQL_INSERT);
            pst.setString(1, personaDTO.getNombre());
            pst.setString(2, personaDTO.getApellido());
            pst.setString(3, personaDTO.getEmail());
            pst.setInt(4, personaDTO.getTlf());
            registros = pst.executeUpdate();

            close(pst);
            if (this.conexionTransaccional == null) {
                close(con);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return registros;
    }

    public int actualizar(PersonaDTO personaDTO) {
        Connection con;
        PreparedStatement pst;
        int registros = 0;

        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
            pst = con.prepareStatement(SQL_UPDATE);
            pst.setString(1, personaDTO.getNombre());
            pst.setString(2, personaDTO.getApellido());
            pst.setString(3, personaDTO.getEmail());
            pst.setInt(4, personaDTO.getTlf());
            pst.setInt(5, personaDTO.getIdPersona());
            registros = pst.executeUpdate();

            close(pst);
            if (this.conexionTransaccional == null) {
                close(con);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return registros;
    }

    public int borrar(PersonaDTO personaDTO) {
        Connection con;
        PreparedStatement pst;
        int registros = 0;

        try {
            con = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
            pst = con.prepareStatement(SQL_DELETE);
            pst.setInt(1, personaDTO.getIdPersona());
            registros = pst.executeUpdate();

            close(pst);
            if (this.conexionTransaccional == null) {
                close(con);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return registros;
    }
}
