package test;

import datos.PersonaDAO;
import domain.Persona;

import java.util.List;

public class ManejoPersonas {
    public static void main(String[] args) {
        PersonaDAO personaDAO = new PersonaDAO();
        List<Persona> personas =  personaDAO.seleccionar();
        personas.forEach(System.out::println);

        //Insertando una nueva persona en la BDD

    }
}
