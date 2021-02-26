package beans;

public class Usuario {

    private int idUsuario;
    private String perfil;
    private String usuario;
    private String contraseia;
    private String fechaCreacion;
    private int codigo;
    private String nombreCompleto;
    private int estado;

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", perfil=" + perfil + ", usuario=" + usuario + ", contraseia=" + contraseia + ", fechaCreacion=" + fechaCreacion + ", codigo=" + codigo + ", nombreCompleto=" + nombreCompleto + ", estado=" + estado + '}';
    }
    
    

    public Usuario() {
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseia() {
        return contraseia;
    }

    public void setContraseia(String contraseia) {
        this.contraseia = contraseia;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    
    
}

