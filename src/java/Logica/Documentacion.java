
package Logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Nestor
 */

@Entity
public class Documentacion implements Serializable {
    
    @Basic
    @Id
    private String  idDocume;
    private String  idLegajo;
    private int     idSector;
    @Temporal(TemporalType.DATE)
    private Date    fechaInicio;    
    private Date    fechaFinal;
    private String  vigencia;
    private int     tiempoVigencia;
    private String  tipoDocume;
    private String  tipoEmisor;
    private String  nombreEmisor;
    private String  guardaEn;
    private String  estado;
    private String  firmaPersona;
    private String  firmaResponsable;
    private String  Observaciones;

    public Documentacion() {
    }

    public Documentacion(String idDocume, String idLegajo, int idSector, Date fechaInicio, Date fechaFinal, String vigencia, int tiempoVigencia, String tipoDocume, String tipoEmisor, String nombreEmisor, String guardaEn, String estado, String firmaPersona, String firmaResponsable, String Observaciones) {
        this.idDocume = idDocume;
        this.idLegajo = idLegajo;
        this.idSector = idSector;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.vigencia = vigencia;
        this.tiempoVigencia = tiempoVigencia;
        this.tipoDocume = tipoDocume;
        this.tipoEmisor = tipoEmisor;
        this.nombreEmisor = nombreEmisor;
        this.guardaEn = guardaEn;
        this.estado = estado;
        this.firmaPersona = firmaPersona;
        this.firmaResponsable = firmaResponsable;
        this.Observaciones = Observaciones;
    }

    public String getIdDocume() {
        return idDocume;
    }

    public void setIdDocume(String idDocume) {
        this.idDocume = idDocume;
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

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getVigencia() {
        return vigencia;
    }

    public void setVigencia(String vigencia) {
        this.vigencia = vigencia;
    }

    public int getTiempoVigencia() {
        return tiempoVigencia;
    }

    public void setTiempoVigencia(int tiempoVigencia) {
        this.tiempoVigencia = tiempoVigencia;
    }

    public String getTipoDocume() {
        return tipoDocume;
    }

    public void setTipoDocume(String tipoDocume) {
        this.tipoDocume = tipoDocume;
    }

    public String getTipoEmisor() {
        return tipoEmisor;
    }

    public void setTipoEmisor(String tipoEmisor) {
        this.tipoEmisor = tipoEmisor;
    }

    public String getNombreEmisor() {
        return nombreEmisor;
    }

    public void setNombreEmisor(String nombreEmisor) {
        this.nombreEmisor = nombreEmisor;
    }

    public String getGuardaEn() {
        return guardaEn;
    }

    public void setGuardaEn(String guardaEn) {
        this.guardaEn = guardaEn;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFirmaPersona() {
        return firmaPersona;
    }

    public void setFirmaPersona(String firmaPersona) {
        this.firmaPersona = firmaPersona;
    }

    public String getFirmaResponsable() {
        return firmaResponsable;
    }

    public void setFirmaResponsable(String firmaResponsable) {
        this.firmaResponsable = firmaResponsable;
    }

    public String getObservaciones() {
        return Observaciones;
    }

    public void setObservaciones(String Observaciones) {
        this.Observaciones = Observaciones;
    }



    
    
}
