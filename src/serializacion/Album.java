package serializacion;

import java.io.Serializable;
import java.util.List;

public class Album implements Serializable {
    
    
    /** 
     * Identificador de versión para la serialización. 
     */
    private static final long serialVersionUID = 1L;
     /** 
     * Identificador único del álbum. 
     */
    private Integer id;
    /** 
     * Nombre del álbum. 
     */
    private String nombre;
    /** 
     * Artista que creó el álbum. 
     */
    private String artista;
    /** 
     * Año de lanzamiento del álbum. 
     */
    private Integer anio;
    /** 
     * Lista de canciones incluidas en el álbum. 
     */
    private List<Cancion> canciones;
    
    /**
     * Constructor que inicializa los campos de un álbum.
     *
     * @param id Identificador del álbum.
     * @param nombre Nombre del álbum.
     * @param artista Artista que lanzó el álbum.
     * @param anio Año de lanzamiento.
     */

    public Album(Integer id, String nombre, String artista, Integer anio) {
        this.id = id;
        this.nombre = nombre;
        this.artista = artista;
        this.anio = anio;
    }
    /** 
     * Obtiene el ID del álbum.
     * @return ID del álbum. 
     */
    public Integer getId() {
        return id;
    }
    /** 
     * Establece el ID del álbum.
     * @param id El nuevo ID del álbum. 
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

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public List<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(List<Cancion> canciones) {
        this.canciones = canciones;
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
        Album other = (Album) obj;
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
        return "Album{id=" + id + ", nombre=" + nombre + ", artista=" + artista + ", anio=" + anio + ", canciones=" + canciones + "}";
    }
}
