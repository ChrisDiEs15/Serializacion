package serializacion;

import java.io.Serializable;
/**
 * Representa una canción con su ID y nombre.
 * Implementa Serializable para permitir su serialización.
 */

public class Cancion implements Serializable {
    /** 
     * Identificador de versión para la serialización. 
     */
    private static final long serialVersionUID = 1L;
      /** 
     * Identificador único de la canción. 
     */
    private Integer id;
      /** 
     * Nombre de la canción. 
     */
    private String nombre;

    /**
     * Constructor que inicializa los campos de una canción.
     *
     * @param id Identificador de la canción.
     * @param nombre Nombre de la canción.
     */
    public Cancion(Integer id, String nombre) {
      
        this.id = id;
      
        this.nombre = nombre;
    }
    /** 
     * Obtiene el ID de la canción.
     * @return ID de la canción. 
     */
    
    public Integer getId() {
        return id;
    }
     /** 
     * Establece el ID de la canción.
     * @param id El nuevo ID de la canción. 
     */

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Cancion other = (Cancion) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "\n\tCancion{id=" + id + ", nombre='" + nombre + "'}";
    }
}

