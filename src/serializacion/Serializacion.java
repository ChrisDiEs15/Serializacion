/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package serializacion;

import java.util.ArrayList;
import java.util.List;

public class Serializacion {

    public static void main(String[] args) {
        AlbumDAO albumDAO = new AlbumDAO();

        // Create albums for Metallica
        List<Album> metallicaAlbums = new ArrayList<>();

        // Album 1: "Kill 'Em All"
        List<Cancion> killEmAllSongs = new ArrayList<>();
        killEmAllSongs.add(new Cancion(1, "Hit the Lights"));
        killEmAllSongs.add(new Cancion(2, "The Four Horsemen"));
        killEmAllSongs.add(new Cancion(3, "Motorbreath"));
        Album killEmAll = new Album(1, "Kill 'Em All", "Metallica", 1983);
        killEmAll.setCanciones(killEmAllSongs);
        metallicaAlbums.add(killEmAll);

        // Album 2: "Ride the Lightning"
        List<Cancion> rideTheLightningSongs = new ArrayList<>();
        rideTheLightningSongs.add(new Cancion(1, "Fight Fire with Fire"));
        rideTheLightningSongs.add(new Cancion(2, "Ride the Lightning"));
        rideTheLightningSongs.add(new Cancion(3, "For Whom the Bell Tolls"));
        Album rideTheLightning = new Album(2, "Ride the Lightning", "Metallica", 1984);
        rideTheLightning.setCanciones(rideTheLightningSongs);
        metallicaAlbums.add(rideTheLightning);

        // Album 3: "Master of Puppets"
        List<Cancion> masterOfPuppetsSongs = new ArrayList<>();
        masterOfPuppetsSongs.add(new Cancion(1, "Battery"));
        masterOfPuppetsSongs.add(new Cancion(2, "Master of Puppets"));
        masterOfPuppetsSongs.add(new Cancion(3, "The Thing That Should Not Be"));
        Album masterOfPuppets = new Album(3, "Master of Puppets", "Metallica", 1986);
        masterOfPuppets.setCanciones(masterOfPuppetsSongs);
        metallicaAlbums.add(masterOfPuppets);

        // Insert albums into the DAO
        for (Album album : metallicaAlbums) {
            albumDAO.insert(album);
        }

        // Retrieve and print each album
        for (Album album : metallicaAlbums) {
            Album retrievedAlbum = albumDAO.select(album.getId());
            System.out.println("Retrieved Album: " + retrievedAlbum);
        }

        // List all album IDs
        System.out.println("All Album IDs: " + albumDAO.list());

        // Update an album
        killEmAll.setNombre("Kill 'Em All - Remastered");
        albumDAO.update(killEmAll);
        System.out.println("Updated Album: " + albumDAO.select(killEmAll.getId()));

        // Delete an album
        albumDAO.delete(masterOfPuppets.getId());
        System.out.println("Album IDs after deletion: " + albumDAO.list());
    }
}
