package domain;

public class PersonaDTO {
    private int idPersona;
    private String nombre;
    private String apellido;
    private String email;
    private int tlf;

    public PersonaDTO() {
    }

    public PersonaDTO(int idPersona) {
        this.idPersona = idPersona;
    }

    public PersonaDTO(String nombre, String apellido, String email, int tlf) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.tlf = tlf;
    }

    public PersonaDTO(int idPersona, String nombre, String apellido, String email, int tlf) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.tlf = tlf;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTlf() {
        return tlf;
    }

    public void setTlf(int tlf) {
        this.tlf = tlf;
    }

    @Override
    public String toString() {
        return "PersonaDTO{" +
                "idPersona=" + idPersona +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                ", tlf=" + tlf +
                '}';
    }
}
