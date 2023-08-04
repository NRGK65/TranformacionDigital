
package Logica;

import Persistencia.ControladoraPersistencia;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.Part;

/**
* import javax.servlet.http.HttpSession;
* import javax.servlet.http.HttpServletRequest;
* import javax.servlet.http.HttpServletResponse;   
*/ 


/**
 *
 * @author Nestor
 */




public class Controladora {
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public boolean comprobarIngreso(String legajo, String usuario, String contra) {

        boolean siONo = false;
        List <Usuario> listaUsuarios = new ArrayList <Usuario> ();
        
        listaUsuarios = controlPersis.getUsuarios();
        
        for (Usuario usu:listaUsuarios) {
        
            if (usu.getUsuarioPersona().equals(usuario) && usu.getContraPersona().equals(contra)){
                siONo = true ;
                return siONo;
            }
        }
        return siONo;
    }
    
    
        public boolean comprobarSector(int codigoS, String nombreS, String responS, String areaS) {
              
        boolean siONo = false;
        List <Sector> listaSector = new ArrayList <Sector> ();
        
        listaSector = controlPersis.getSector();
                
        for (Sector sect:listaSector) {
        
            if (sect.getIdSector() == codigoS){
                siONo = true ;
                return siONo;
            } else {
            }
        }
        return siONo;
    }
            

    
    public void crearSector (int codSector, String nomSector, String resSector, String areSector) throws Exception{
    
        Sector sect = new Sector ();
        
        sect.setIdSector(codSector);
        sect.setNombreSector(nomSector);
        sect.setNombreResponsable(resSector);
        sect.setAreaSector(areSector);

        controlPersis.crearSector (sect);
        
    }
    
    public void crearUsuario (String legajo, String usuario, String contra, int permi) throws Exception {

            Usuario usua = new Usuario();
            
            usua.setIdLegajo(legajo);
            usua.setUsuarioPersona(usuario);
            usua.setContraPersona(contra);
            usua.setPermiPersona(permi);
            
            controlPersis.crearUsuario (usua);

        }
        
    
    public void crearDatoDocumento (String idDocume, String nombreDocume, String fechaInicio, String fechaFinal, 
            String vigencia, String tiempoVigencia, String tipoDocume, String tipoEmisor, String nombreEmisor) throws Exception {
    
        DatosDocumentacion datos = new DatosDocumentacion() ;
        
        datos.setIdDocume(idDocume);
        datos.setNombreDocume(nombreDocume);
        datos.setFechaInicio(fechaInicio);
        datos.setFechaFinal(fechaFinal);
        datos.setVigencia(vigencia);
        datos.setTiempoVigencia(tiempoVigencia);
        datos.setTipoDocume(tipoDocume);
        datos.setTipoEmisor(tipoEmisor);
        datos.setNombreEmisor(nombreEmisor);
        
        controlPersis.crearDatoDocumento(datos);
        
        
    }
    
    
    
    
    
    public List<Sector> getListaSector() {
        return (this.controlPersis.getSector());
    }

    public void borrarSector(int id) {
        controlPersis.borrarSector(id);
    }
    

    public Sector buscarSector(int id) {
        return controlPersis.buscarSector(id);
          
    }

    public void modificarSector(Sector sect) throws Exception {
        controlPersis.modificarSector(sect) ;
    }

    public void crearLicenciaAlta(String idDocume, int idSect, String idLegajo, Date tmpfechaP, Date tmpfechaI, Date tmpfechaF, 
            int numDias, String txtEstado, String txtDiagno, String txtDomici, String txtPostal, String txtLocali, String txtTelefo, 
            String txtCorreo, String txtPermis, String txtObser, String txtFirma1, String txtFirma2 ) throws Exception {
        
        Formulario formu = new Formulario() ;
        
        formu.setIdTipoForm(idDocume);
        formu.setIdSector(idSect);
        formu.setIdLegajo(idLegajo);
        formu.setFechaPedido(tmpfechaP);
        formu.setFechaInicio(tmpfechaI);
        formu.setFechaFinal(tmpfechaF);
        formu.setDias(numDias);
        formu.setEstado(txtEstado);
        formu.setDiagnostico(txtDiagno);
        formu.setDomicilio(txtDomici);
        formu.setCodPostal(txtPostal);
        formu.setLocalidad(txtLocali);
        formu.setTelefono(txtTelefo);
        formu.setCorreoElectronico(txtCorreo);
        formu.setPermisos(txtPermis);
        formu.setObservacion(txtObser);
        formu.setFirmaPersona(txtFirma1);
        formu.setFirmaResponsable(txtFirma2);
                
        controlPersis.crearFormulario(formu);
        
        
    }
     
       //MÉTODOS PARA MANEJAR FECHAS Y HORAS
//TodoCode

//Metodo usado para obtener la fecha actual
    //@return Retorna un STRING con la fecha actual formato "dd-MM-yyyy"
    public static String getFechaActual() {
        Date ahora = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy"); //acá pueden cambiar el formato si quieren
        return formatoFecha.format(ahora);
    }
	
	//Metodo usado para obtener la hora actual del sistema
    //@return Retorna un STRING con la hora actual formato "hh:mm"
    public static String getHoraActual() {
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("hh:mm");
        return formateador.format(ahora);
    }
	
	//Convierte un String a un tipo DATE en formato dd-MM-yyyy
    //@return Retorna la fecha en formato Date
    public static synchronized java.util.Date deStringToDate(String fecha) {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy"); //formato guión
        Date fechaEnviar = null;
        try {
            fechaEnviar = df.parse(fecha);
            return fechaEnviar;
        } catch (ParseException ex) {
            ex.printStackTrace();
            return null;
        }
    }
	
	//Convierte un String a un tipo DATE en formato dd/MM/yyyy
    //@return Retorna la fecha en formato Date
	   public static synchronized java.util.Date deStringToDate2(String fecha) {
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd/MM/yyyy"); //formato barra
        Date fechaEnviar = null;
        try {
            fechaEnviar = formatoDelTexto.parse(fecha);
            return fechaEnviar;
        } catch (ParseException ex) {
            ex.printStackTrace();
            return null;
        }
    }
	
	//Convertir Date a String
	 public static String DateAString(Date fecha){
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        return formatoFecha.format(fecha);
    }
	
	//Convertir Hora a String
	  public static Date convertirHoraStringADate (String hora, String minutos) throws ParseException {
      
      String horaString = hora + ":" + minutos;
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm");
        Date horaCompleta = new Date();
          
                horaCompleta = formatoHora.parse(horaString);
            
        System.out.println("La hora es: " + horaCompleta);
      return horaCompleta;
      }

  

}


