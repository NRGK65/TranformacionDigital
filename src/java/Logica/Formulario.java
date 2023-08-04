
package Logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Nestor
 */

@Entity
public class Formulario implements Serializable {
   
    @Basic
    @Id
    private String  idTipoForm;
    private int     idSector;
    private String  idLegajo;
    @Temporal(TemporalType.DATE)
    private Date    fechaPedido;
    private Date    fechaInicio;
    private Date    fechaFinal;
    private int     dias;
    private String  estado;
    private String  diagnostico;
    private String  domicilio;
    private String  codPostal;
    private String  Localidad;
    private String  telefono;
    private String  correoElectronico;
    private String  permisos;
    private String  observacion;
    private String  firmaPersona; 
    private String  firmaResponsable;
    
    public Formulario() {
    }

    public Formulario(String idTipoForm, int idSector, String idLegajo, Date fechaPedido, Date fechaInicio, Date fechaFinal, int dias, String estado, String diagnostico, String domicilio, String codPostal, String Localidad, String telefono, String correoElectronico, String permisos, String observacion, String firmaPersona, String firmaResponsable ) {
        this.idTipoForm = idTipoForm;
        this.idSector = idSector;
        this.idLegajo = idLegajo;
        this.fechaPedido = fechaPedido;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.dias = dias;
        this.estado = estado;
        this.diagnostico = diagnostico;
        this.domicilio = domicilio;
        this.codPostal = codPostal;
        this.Localidad = Localidad;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.permisos = permisos;
        this.observacion = observacion;
        this.firmaPersona = firmaPersona;
        this.firmaResponsable = firmaResponsable;
        
    }
    
    

    

    public String getIdTipoForm() {
        return idTipoForm;
    }

    public void setIdTipoForm(String idTipoForm) {
        this.idTipoForm = idTipoForm;
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

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
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

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }

    public String getLocalidad() {
        return Localidad;
    }

    public void setLocalidad(String Localidad) {
        this.Localidad = Localidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getPermisos() {
        return permisos;
    }

    public void setPermisos(String permisos) {
        this.permisos = permisos;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
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

        
    
    
    

}
