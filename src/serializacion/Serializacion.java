/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package serializacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Serializacion {

    public static void main(String[] args) {
        AlbumDAO albumDAO = new AlbumDAO();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Crear álbum");
            System.out.println("2. Leer álbum");
            System.out.println("3. Listar álbumes");
            System.out.println("4. Actualizar álbum");
            System.out.println("5. Eliminar álbum");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");

            int option = scanner.nextInt();
            scanner.nextLine();  // Limpiar buffer

            switch (option) {
                case 1:
                    // Crear un álbum nuevo
                    System.out.print("ID del álbum: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Limpiar buffer

                    System.out.print("Nombre del álbum: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Artista: ");
                    String artista = scanner.nextLine();

                    System.out.print("Año de lanzamiento: ");
                    int anio = scanner.nextInt();
                    scanner.nextLine(); // Limpiar buffer

                    List<Cancion> canciones = new ArrayList<>();
                    boolean agregarCanciones = true;

                    while (agregarCanciones) {
                        System.out.print("ID de la canción: ");
                        int idCancion = scanner.nextInt();
                        scanner.nextLine(); // Limpiar buffer

                        System.out.print("Nombre de la canción: ");
                        String nombreCancion = scanner.nextLine();

                        canciones.add(new Cancion(idCancion, nombreCancion));

                        System.out.print("¿Agregar otra canción? (s/n): ");
                        String continuar = scanner.nextLine();
                        agregarCanciones = continuar.equalsIgnoreCase("s");
                    }

                    Album nuevoAlbum = new Album(id, nombre, artista, anio);
                    nuevoAlbum.setCanciones(canciones);
                    albumDAO.insert(nuevoAlbum);
                    System.out.println("Álbum creado exitosamente.");
                    break;

                case 2:
                    // Leer un álbum
                    System.out.print("ID del álbum a leer: ");
                    int idLeer = scanner.nextInt();
                    Album albumLeido = albumDAO.select(idLeer);
                    System.out.println("Álbum leído: " + albumLeido);
                    break;

                case 3:
                    // Listar todos los álbumes
                    System.out.println("IDs de álbumes disponibles: " + albumDAO.list());
                    break;

                case 4:
                    // Actualizar un álbum
                    System.out.print("ID del álbum a actualizar: ");
                    int idActualizar = scanner.nextInt();
                    scanner.nextLine(); // Limpiar buffer

                    Album albumActualizar = albumDAO.select(idActualizar);
                    if (albumActualizar != null) {
                        System.out.print("Nuevo nombre del álbum (dejar en blanco para no cambiar): ");
                        String nuevoNombre = scanner.nextLine();
                        if (!nuevoNombre.isBlank()) {
                            albumActualizar.setNombre(nuevoNombre);
                        }

                        System.out.print("Nuevo artista (dejar en blanco para no cambiar): ");
                        String nuevoArtista = scanner.nextLine();
                        if (!nuevoArtista.isBlank()) {
                            albumActualizar.setArtista(nuevoArtista);
                        }

                        System.out.print("Nuevo año de lanzamiento (0 para no cambiar): ");
                        int nuevoAnio = scanner.nextInt();
                        if (nuevoAnio != 0) {
                            albumActualizar.setAnio(nuevoAnio);
                        }

                        scanner.nextLine(); // Limpiar buffer

                        System.out.print("¿Actualizar canciones? (s/n): ");
                        String actualizarCanciones = scanner.nextLine();
                        if (actualizarCanciones.equalsIgnoreCase("s")) {
                            List<Cancion> nuevasCanciones = new ArrayList<>();
                            boolean actualizar = true;
                            while (actualizar) {
                                System.out.print("ID de la nueva canción: ");
                                int idNuevaCancion = scanner.nextInt();
                                scanner.nextLine(); // Limpiar buffer

                                System.out.print("Nombre de la nueva canción: ");
                                String nombreNuevaCancion = scanner.nextLine();

                                nuevasCanciones.add(new Cancion(idNuevaCancion, nombreNuevaCancion));

                                System.out.print("¿Agregar otra canción? (s/n): ");
                                String continuarCanciones = scanner.nextLine();
                                actualizar = continuarCanciones.equalsIgnoreCase("s");
                            }
                            albumActualizar.setCanciones(nuevasCanciones);
                        }
                        albumDAO.update(albumActualizar);
                        System.out.println("Álbum actualizado.");
                    } else {
                        System.out.println("Álbum no encontrado.");
                    }
                    break;

                case 5:
                    // Eliminar un álbum
                    System.out.print("ID del álbum a eliminar: ");
                    int idEliminar = scanner.nextInt();
                    albumDAO.delete(idEliminar);
                    System.out.println("Álbum eliminado.");
                    break;

                case 6:
                    // Salir del programa
                    running = false;
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                    break;
            }
        }
        scanner.close();
    }
}