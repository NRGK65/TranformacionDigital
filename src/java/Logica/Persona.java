
package Logica;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Nestor
 */

@Entity
public class Persona implements Serializable {
 
    @Id
    private String  idLegajo;
    @Basic
    private int     idSector ;
    private String  nombrePersona ;
    private String  domicioPersona;
    private String  codPostal; 
    private String  localidad; 
    private String  CUIL;
    private String  tipoDocu ; 
    private int     numeroDocu;
    private String  telefono1; 
    private String  telefono2;
    private String  correoElectronico;
    private String  rutaGuarda;
    private String  foto;   
    private String  permisoPersona; 
    private String  firmaPersona;

    public Persona() {
    }

    public Persona(String idLegajo, int idSector, String nombrePersona, String domicioPersona, String codPostal, String localidad, String CUIL, String tipoDocu, int numeroDocu, String telefono1, String telefono2, String correoElectronico, String rutaGuarda, String foto, String permisoPersona, String firmaPersona) {
        this.idLegajo = idLegajo;
        this.idSector = idSector;
        this.nombrePersona = nombrePersona;
        this.domicioPersona = domicioPersona;
        this.codPostal = codPostal;
        this.localidad = localidad;
        this.CUIL = CUIL;
        this.tipoDocu = tipoDocu;
        this.numeroDocu = numeroDocu;
        this.telefono1 = telefono1;
        this.telefono2 = telefono2;
        this.correoElectronico = correoElectronico;
        this.rutaGuarda = rutaGuarda;
        this.foto = foto;
        this.permisoPersona = permisoPersona;
        this.firmaPersona = firmaPersona;
    }

    public String getIdLegajo() {
        return idLegajo;
    }

    public void setIdLegajo(String idLegajo) {
        this.idLegajo = idLegajo;
    }

    public int getIdSector() {
        return idSector;
    }

    public void setIdSector(int idSector) {
        this.idSector = idSector;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getDomicioPersona() {
        return domicioPersona;
    }

    public void setDomicioPersona(String domicioPersona) {
        this.domicioPersona = domicioPersona;
    }

    public String getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getCUIL() {
        return CUIL;
    }

    public void setCUIL(String CUIL) {
        this.CUIL = CUIL;
    }

    public String getTipoDocu() {
        return tipoDocu;
    }

    public void setTipoDocu(String tipoDocu) {
        this.tipoDocu = tipoDocu;
    }

    public int getNumeroDocu() {
        return numeroDocu;
    }

    public void setNumeroDocu(int numeroDocu) {
        this.numeroDocu = numeroDocu;
    }

    public String getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getRutaGuarda() {
        return rutaGuarda;
    }

    public void setRutaGuarda(String rutaGuarda) {
        this.rutaGuarda = rutaGuarda;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getPermisoPersona() {
        return permisoPersona;
    }

    public void setPermisoPersona(String permisoPersona) {
        this.permisoPersona = permisoPersona;
    }

    public String getFirmaPersona() {
        return firmaPersona;
    }

    public void setFirmaPersona(String firmaPersona) {
        this.firmaPersona = firmaPersona;
    }
    
  
}
