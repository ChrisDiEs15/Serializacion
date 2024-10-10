package serializacion;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Maneja las operaciones CRUD (Crear, Leer, Actualizar, Eliminar) 
 * sobre objetos Album en el sistema de archivos.
 */

public class AlbumDAO {
    /**
     * Ruta del directorio donde se guardarán los álbumes serializados.
     */

    private final String PATH_FOLDER = "C:/uaemex/paradigmas1/musica/albumes";
    /**
     * Constructor de AlbumDAO.
     * Verifica si el directorio para almacenar los álbumes existe, 
     * y lo crea si es necesario.
     */
    public AlbumDAO() {
        // Ensure the directory exists
        File folder = new File(PATH_FOLDER);
        if (!folder.exists()) {
            folder.mkdirs();
        }
    }
    /**
     * Inserta un álbum en el almacenamiento serializando el objeto.
     *
     * @param album El álbum a insertar.
     */
    public void insert(Album album) {
        File file = new File(PATH_FOLDER + File.separator + album.getId() + ".txt");
        try (FileOutputStream fileOut = new FileOutputStream(file);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(album);
            System.out.println("Album saved: " + album);
        } catch (IOException e) {
            System.err.println("Error inserting album: " + e.getMessage());
            e.printStackTrace();
        }
    }
     /**
     * Selecciona un álbum del almacenamiento basado en su ID.
     *
     * @param id El ID del álbum a buscar.
     * @return El álbum encontrado o null si no se encuentra.
     */
    public Album select(Integer id) {
        Album album = null;
        File file = new File(PATH_FOLDER + File.separator + id + ".txt");
        try (FileInputStream fileIn = new FileInputStream(file);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            album = (Album) in.readObject();
            System.out.println("Album read: " + album);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error selecting album: " + e.getMessage());
            e.printStackTrace();
        }
        return album;
    }
    /**
     * Lista todos los IDs de los álbumes almacenados.
     * 
     * @return Lista de IDs de álbumes.
     */
    public List<Integer> list() {
        List<Integer> ids = new ArrayList<>();
        File folder = new File(PATH_FOLDER);
        String[] pathnames = folder.list();
        if (pathnames != null) {
            for (String pathname : pathnames) {
                try {
                    Integer id = Integer.parseInt(pathname.replace(".txt", ""));
                    ids.add(id);
                    System.out.println("Found album ID: " + id);
                } catch (NumberFormatException e) {
                    System.err.println("Invalid file name: " + pathname);
                }
            }
        }
        return ids;
    }
/**
     * Actualiza un álbum en el almacenamiento serializándolo de nuevo.
     *
     * @param album El álbum con los cambios a actualizar.
     */
    public void update(Album album) {
        insert(album); // Reuse insert logic to handle update
    }
    /**
     * Elimina un álbum del almacenamiento basado en su ID.
     *
     * @param id El ID del álbum a eliminar.
     */

    public void delete(Integer id) {
        File file = new File(PATH_FOLDER + File.separator + id + ".txt");
        if (file.delete()) {
            System.out.println("Album deleted: " + id);
        } else {
            System.err.println("Error deleting album with id: " + id);
        }
    }
}