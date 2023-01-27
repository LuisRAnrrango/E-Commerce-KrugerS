package kruger.star.eccomerce.msvcnegocios.models.entity;


import jakarta.persistence.*;

//import javax.persistence.Entity;

@Entity
@Table(name="negocios")
public class Negocio {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   private String nombreNeg;
   private String rucNeg;
   private String descripNeg;
   private  String objtNeg;
   private  String historiaNeg;
   private String direccionWebNeg;
   private String direccionNeg;
   private  String telefonoNeg;
   private String emailNeg;

    public Negocio(){

    }
    public Negocio(String nombreNeg, String rucNeg, String descripNeg, String objtNeg, String historiaNeg, String direccionWebNeg, String direccionNeg, String telefonoNeg, String emailNeg) {
        this.nombreNeg = nombreNeg;
        this.rucNeg = rucNeg;
        this.descripNeg = descripNeg;
        this.objtNeg = objtNeg;
        this.historiaNeg = historiaNeg;
        this.direccionWebNeg = direccionWebNeg;
        this.direccionNeg = direccionNeg;
        this.telefonoNeg = telefonoNeg;
        this.emailNeg = emailNeg;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreNeg() {
        return nombreNeg;
    }

    public void setNombreNeg(String nombreNeg) {
        this.nombreNeg = nombreNeg;
    }

    public String getRucNeg() {
        return rucNeg;
    }

    public void setRucNeg(String rucNeg) {
        this.rucNeg = rucNeg;
    }

    public String getDescripNeg() {
        return descripNeg;
    }

    public void setDescripNeg(String descripNeg) {
        this.descripNeg = descripNeg;
    }

    public String getObjtNeg() {
        return objtNeg;
    }

    public void setObjtNeg(String objtNeg) {
        this.objtNeg = objtNeg;
    }

    public String getHistoriaNeg() {
        return historiaNeg;
    }

    public void setHistoriaNeg(String historiaNeg) {
        this.historiaNeg = historiaNeg;
    }

    public String getDireccionWebNeg() {
        return direccionWebNeg;
    }

    public void setDireccionWebNeg(String direccionWebNeg) {
        this.direccionWebNeg = direccionWebNeg;
    }

    public String getDireccionNeg() {
        return direccionNeg;
    }

    public void setDireccionNeg(String direccionNeg) {
        this.direccionNeg = direccionNeg;
    }

    public String getTelefonoNeg() {
        return telefonoNeg;
    }

    public void setTelefonoNeg(String telefonoNeg) {
        this.telefonoNeg = telefonoNeg;
    }

    public String getEmailNeg() {
        return emailNeg;
    }

    public void setEmailNeg(String emailNeg) {
        this.emailNeg = emailNeg;
    }
}
