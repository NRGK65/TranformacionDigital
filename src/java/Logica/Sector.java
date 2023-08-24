
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
public class Sector {
    
    @Id
    private int     idSector;
    @Basic
    private String  nombreSector;
    private String  nombreResponsable;
    private String  areaSector;

    public Sector() {
    }

    public Sector(int idSector, String nombreSector, String nombreResponsable, String areaSector) {
        this.idSector = idSector;
        this.nombreSector = nombreSector;
        this.nombreResponsable = nombreResponsable;
        this.areaSector = areaSector;
    }

    public int getIdSector() {
        return idSector;
    }

    public void setIdSector(int idSector) {
        this.idSector = idSector;
    }

    public String getNombreSector() {
        return nombreSector;
    }

    public void setNombreSector(String nombreSector) {
        this.nombreSector = nombreSector;
    }

    public String getNombreResponsable() {
        return nombreResponsable;
    }

    public void setNombreResponsable(String nombreResponsable) {
        this.nombreResponsable = nombreResponsable;
    }

    public String getAreaSector() {
        return areaSector;
    }

    public void setAreaSector(String areaSector) {
        this.areaSector = areaSector;
    }
    
    
    
    
}
