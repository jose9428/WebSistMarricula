package beans;

public class Alumno extends Usuario{
    private int idAlumno;
    private String nombreAlumno;
    private String apePAlumno;
    private String apeMAlumno;
    private String fechaNac;
    private String direccion;
    private String telefono;
    private String email;
    private String documento;
    private int estado;
    private String apoderado;
    
    public String NomCompleto(){
        return nombreAlumno + " "+apePAlumno + " "+apeMAlumno;
    }
    
    public String NomEstado(){
        return estado == 1 ? "Activo" : "Inactivo";
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public String getApePAlumno() {
        return apePAlumno;
    }

    public void setApePAlumno(String apePAlumno) {
        this.apePAlumno = apePAlumno;
    }

    public String getApeMAlumno() {
        return apeMAlumno;
    }

    public void setApeMAlumno(String apeMAlumno) {
        this.apeMAlumno = apeMAlumno;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getApoderado() {
        return apoderado;
    }

    public void setApoderado(String apoderado) {
        this.apoderado = apoderado;
    }
    
    
}
