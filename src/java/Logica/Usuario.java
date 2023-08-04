
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
public class Usuario implements Serializable {
    
    @Id
    private String  idLegajo;
    @Basic
    private String  usuarioPersona ;
    private String  contraPersona;
    private int permiPersona ;

    public Usuario() {
    }
    
    public Usuario(String idLegajo, String usuarioPersona, String contraPersona, int permiPersona) {
        this.idLegajo = idLegajo;
        this.usuarioPersona = usuarioPersona;
        this.contraPersona = contraPersona;
        this.permiPersona = permiPersona;
    }
    

    public String getIdLegajo() {
        return idLegajo;
    }

    public void setIdLegajo(String idLegajo) {
        this.idLegajo = idLegajo;
    }

    public String getUsuarioPersona() {
        return usuarioPersona;
    }

    public void setUsuarioPersona(String usuarioPersona) {
        this.usuarioPersona = usuarioPersona;
    }

    public String getContraPersona() {
        return contraPersona;
    }

    public void setContraPersona(String contraPersona) {
        this.contraPersona = contraPersona;
    }

    public int getPermiPersona() {
        return permiPersona;
    }

    public void setPermiPersona(int permiPersona) {
        this.permiPersona = permiPersona;
    }

      
}
