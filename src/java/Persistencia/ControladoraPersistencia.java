
package Persistencia;

import Logica.DatosDocumentacion;
import Logica.Formulario;
import Logica.Persona;
import Logica.Sector;
import Logica.Usuario;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Nestor
 */


public class ControladoraPersistencia {

        PersonaJpaController persoJPA = new PersonaJpaController();
          
        SectorJpaController sectorJPA = new SectorJpaController();
        
        UsuarioJpaController usuarioJPA = new UsuarioJpaController();

        FormularioJpaController formuJPA = new FormularioJpaController();
        
        DocumentacionJpaController documeJPA = new DocumentacionJpaController();
        
        DatosFormularioJpaController datosFormJPA = new DatosFormularioJpaController();
        
        DatosDocumentacionJpaController datosDocuJPA = new DatosDocumentacionJpaController();   
        
        
        
    public void crearPersona(Persona perso) throws Exception {
            persoJPA.create(perso);
        }

    

        
    public void crearDatoDocumento(DatosDocumentacion datoDocu) throws Exception { 
            datosDocuJPA.create(datoDocu) ;
        }
        
        

    public List<Usuario> getUsuarios() {
        return usuarioJPA.findUsuarioEntities();
    }

    
    public void crearUsuario(Usuario usua) throws Exception {
            usuarioJPA.create(usua);
    }


    public void crearSector(Sector sect) throws Exception {
            sectorJPA.create(sect) ;
    }

    public List<Sector> getSector() {
        return sectorJPA.findSectorEntities();
    }

    public void borrarSector(int id) {
        try {
            sectorJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Sector buscarSector(int id) {
        return sectorJPA.findSector(id);
    }

    public void modificarSector(Sector sect) throws Exception {
        try {
            sectorJPA.edit(sect);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    
    public void crearFormulario(Formulario formu) throws Exception {
            formuJPA.create(formu) ;
            

    }

   
    
}


