package serializacion;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AlbumDAO {

    private final String PATH_FOLDER = "C:/uaemex/paradigmas1/musica/albumes";

    public AlbumDAO() {
        // Ensure the directory exists
        File folder = new File(PATH_FOLDER);
        if (!folder.exists()) {
            folder.mkdirs();
        }
    }

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

    public void update(Album album) {
        insert(album); // Reuse insert logic to handle update
    }

    public void delete(Integer id) {
        File file = new File(PATH_FOLDER + File.separator + id + ".txt");
        if (file.delete()) {
            System.out.println("Album deleted: " + id);
        } else {
            System.err.println("Error deleting album with id: " + id);
        }
    }
}