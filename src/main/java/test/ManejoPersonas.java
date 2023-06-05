package test;

import datos.PersonaDAO;
import domain.Persona;

import java.util.List;

public class ManejoPersonas {
    public static void main(String[] args) {
        PersonaDAO personaDAO = new PersonaDAO();

        //Insertando una nueva persona en la BDD
/*        Persona persona = new Persona("Pepe", "Rodrigues", "correo@correo.com", 112233445);
        personaDAO.insertar(persona);*/

        //Modificar una persona existente
/*        Persona actualizarPersona = new Persona(1,"Jorge I.", "Vidovic", "correo@correo.com",123456789);
          personaDAO.actualizar(actualizarPersona);*/

        //Eliminar una persona
        //Persona eliminarPersona = new Persona(6);
        //personaDAO.borrar(eliminarPersona);

        //Listar personas
        List<Persona> personas = personaDAO.seleccionar();
        personas.forEach(System.out::println);
    }
}
