/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serializacion;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Chris
 */
public class VentanaCRUD extends JFrame {
    /*Instancia de los paneles*/
    private final JPanel panelPrincipal;
    private JPanel panelLeerAlbum;
     private final AlbumDAO albumDAO;
    
      public VentanaCRUD() {
        albumDAO = new AlbumDAO(); // Instancia del DAO que maneja los álbumes

        setTitle("CRUD de Álbumes");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel principal con las opciones del CRUD
        panelPrincipal = new JPanel();
        JButton botonLeer = new JButton("Leer Álbum");

        // Acción al presionar el botón "Leer Álbum"
        botonLeer.addActionListener((ActionEvent e) -> {
            mostrarPanelLeerAlbum();
        });
        panelPrincipal.add(botonLeer);

        // Crear el panel para leer álbum
        crearPanelLeerAlbum();

        // Añadir el panel principal por defecto
        add(panelPrincipal);
    }

    // Método para mostrar el panel de leer álbum
    private void mostrarPanelLeerAlbum() {
        getContentPane().removeAll(); // Quitar el panel actual
        add(panelLeerAlbum);          // Añadir el panel de leer álbum
        revalidate();
        repaint();
    }

    // Método para crear el panel de leer álbum
    private void crearPanelLeerAlbum() {
        panelLeerAlbum = new JPanel();
        panelLeerAlbum.setLayout(new GridLayout(3, 2));

        JLabel labelId = new JLabel("ID del álbum:");
        JTextField inputId = new JTextField(5);
        JButton botonBuscar = new JButton("Buscar");
        JTextArea areaResultado = new JTextArea(5, 20);
        areaResultado.setEditable(false);

        // Botón para volver al panel principal
        JButton botonVolver = new JButton("Volver al menú principal");
        botonVolver.addActionListener((ActionEvent e) -> {
            getContentPane().removeAll();
            add(panelPrincipal);
            revalidate();
            repaint();
        });

        // Acción al presionar el botón "Buscar"
        botonBuscar.addActionListener((ActionEvent e) -> {
            int idLeer = Integer.parseInt(inputId.getText());
            Album albumLeido = albumDAO.select(idLeer);
            if (albumLeido != null) {
                areaResultado.setText("Álbum leído: " + albumLeido);
            } else {
                areaResultado.setText("El álbum con ID " + idLeer + " no existe.");
            }
        });

        // Agregar componentes al panel de leer álbum
        panelLeerAlbum.add(labelId);
        panelLeerAlbum.add(inputId);
        panelLeerAlbum.add(botonBuscar);
        panelLeerAlbum.add(new JLabel());  // Espacio vacío
        panelLeerAlbum.add(areaResultado);
        panelLeerAlbum.add(botonVolver);
    }
    
    
}
