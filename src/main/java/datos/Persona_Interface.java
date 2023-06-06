package datos;

import domain.PersonaDTO;

import java.util.List;

public interface Persona_Interface {
    public List<PersonaDTO> seleccionar();
    public int insertar(PersonaDTO personaDTO);
    public int actualizar(PersonaDTO personaDTO);
    public int borrar(PersonaDTO personaDTO);

}
