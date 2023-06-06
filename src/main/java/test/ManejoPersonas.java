package test;

import datos.Conexion;
import datos.PersonaDAO;
import datos.Persona_Interface;
import domain.PersonaDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ManejoPersonas {
    public static void main(String[] args) {
        //Manejo transaccional
        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }
            Persona_Interface personaDAO = new PersonaDAO(conexion);
            List<PersonaDTO> personas = personaDAO.seleccionar();
            for (PersonaDTO persona:personas){
                System.out.println(persona);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Entramos en el rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }
    }
}
