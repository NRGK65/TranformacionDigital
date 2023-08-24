
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
public class DatosDocumentacion implements Serializable {
    
    @Id
    private String  idDocume;
    @Basic
    private String nombreDocume;
    private String fechaInicio;
    private String fechaFinal;
    private String vigencia;
    private String tiempoVigencia;
    private String tipoDocume;
    private String tipoEmisor;
    private String nombreEmisor;

    public DatosDocumentacion() {
    }

    public DatosDocumentacion(String idDocume, String nombreDocume, String fechaInicio, String fechaFinal, String vigencia, String tiempoVigencia, String tipoDocume, String tipoEmisor, String nombreEmisor) {
        this.idDocume = idDocume;
        this.nombreDocume = nombreDocume;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.vigencia = vigencia;
        this.tiempoVigencia = tiempoVigencia;
        this.tipoDocume = tipoDocume;
        this.tipoEmisor = tipoEmisor;
        this.nombreEmisor = nombreEmisor;
    }

    public String getIdDocume() {
        return idDocume;
    }

    public void setIdDocume(String idDocume) {
        this.idDocume = idDocume;
    }

    public String getNombreDocume() {
        return nombreDocume;
    }

    public void setNombreDocume(String nombreDocume) {
        this.nombreDocume = nombreDocume;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getVigencia() {
        return vigencia;
    }

    public void setVigencia(String vigencia) {
        this.vigencia = vigencia;
    }

    public String getTiempoVigencia() {
        return tiempoVigencia;
    }

    public void setTiempoVigencia(String tiempoVigencia) {
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

    
}
