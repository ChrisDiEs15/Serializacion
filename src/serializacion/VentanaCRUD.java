/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serializacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 *
 * @author Chris
 */
public class VentanaCRUD extends JFrame {

    /*Instancia de los paneles*/
    private final JPanel panelPrincipal;
    private JPanel panelLeerAlbum, panelCrear, panelActualizar, panelEliminar, panelMostrar;
    private final AlbumDAO albumDAO;

    public VentanaCRUD() {
        albumDAO = new AlbumDAO(); // Instancia del DAO que maneja los álbumes

        setTitle("CRUD de Álbumes");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel principal con las opciones del CRUD
        panelPrincipal = new JPanel();
        //Layout panel principal
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        JButton botonLeer = new JButton("Leer Álbum");
        JButton botonCrear = new JButton("Crear Nuevo Album");
        JButton botonActualizar = new JButton("Actualizar Álbum");
        JButton botonEliminar = new JButton("Eliminar Álbum");
        JButton botonMostrar = new JButton("Mostrar todos los Albumes");

        botonLeer.setAlignmentX(Component.CENTER_ALIGNMENT);
        botonCrear.setAlignmentX(Component.CENTER_ALIGNMENT);
        botonActualizar.setAlignmentX(Component.CENTER_ALIGNMENT);
        botonEliminar.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Acciónes  al presionar los botones
        botonLeer.addActionListener((ActionEvent e) -> {
            mostrarPanelLeerAlbum();
        });
        botonCrear.addActionListener((ActionEvent e) -> {
            mostrarPanelCrear();
        });
        botonActualizar.addActionListener((ActionEvent e) -> {
            mostrarPanelActualizar();
        });
        botonEliminar.addActionListener((ActionEvent e) -> {
            mostrarPanelEliminar();
        });
        botonMostrar.addActionListener((ActionEvent e) -> {
            mostrarPanelMostrar();
        });

        //Agrega botones al panel principal
        panelPrincipal.add(botonLeer);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 10)));
        panelPrincipal.add(botonCrear);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 10)));
        panelPrincipal.add(botonActualizar);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 10)));
        panelPrincipal.add(botonEliminar);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 10)));
        panelPrincipal.add(botonMostrar);

        // Crear Instancias de los albumes
        crearPanelLeerAlbum();
        CrearPanelCrear();

        /**/
        // Añadir el panel principal por defecto
        add(panelPrincipal);
    }

    // Métododos que sobreescriben el panel principal
    private void mostrarPanelLeerAlbum() {
        getContentPane().removeAll(); // Quitar el panel actual
        add(panelLeerAlbum);          // Añadir el panel de leer álbum
        revalidate();
        repaint();
    }

    private void mostrarPanelCrear() {
        getContentPane().removeAll(); // Quitar el panel actual
        add(panelCrear);          // Añadir el panel de leer álbum
        revalidate();
        repaint();
    }

    private void mostrarPanelActualizar() {
        getContentPane().removeAll(); // Quitar el panel actual
        add(panelActualizar);          // Añadir el panel de leer álbum
        revalidate();
        repaint();
    }

    private void mostrarPanelEliminar() {
        getContentPane().removeAll(); // Quitar el panel actual
        add(panelEliminar);          // Añadir el panel de leer álbum
        revalidate();
        repaint();
    }

    private void mostrarPanelMostrar() {
        getContentPane().removeAll(); // Quitar el panel actual
        add(panelMostrar);          // Añadir el panel de leer álbum
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

    //panel
    private void CrearPanelCrear(){
        panelCrear = new JPanel();
        
        
    // Botón para volver al panel principal
        JButton botonVolver = new JButton("Volver al menú principal");
        botonVolver.addActionListener((ActionEvent e) -> {
            getContentPane().removeAll();
            add(panelPrincipal);
            revalidate();
            repaint();
        });
        
        panelCrear.add(botonVolver);
    }
}
