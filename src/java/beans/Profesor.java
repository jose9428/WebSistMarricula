package beans;

public class Profesor extends Usuario {

    private int idProfesor;
    private String nombreProfesor;
    private String apePaternoProfesor;
    private String apeMaternoProfesor;
    private String documento;
    
       public String NomCompleto(){
        return nombreProfesor + " "+apePaternoProfesor + " "+apeMaternoProfesor;
    }
    

    public int getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }

    public String getNombreProfesor() {
        return nombreProfesor;
    }

    public void setNombreProfesor(String nombreProfesor) {
        this.nombreProfesor = nombreProfesor;
    }

    public String getApePaternoProfesor() {
        return apePaternoProfesor;
    }

    public void setApePaternoProfesor(String apePaternoProfesor) {
        this.apePaternoProfesor = apePaternoProfesor;
    }

    public String getApeMaternoProfesor() {
        return apeMaternoProfesor;
    }

    public void setApeMaternoProfesor(String apeMaternoProfesor) {
        this.apeMaternoProfesor = apeMaternoProfesor;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }
    
    
}
