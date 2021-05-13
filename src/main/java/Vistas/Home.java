
package Vistas;

import Paneles.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;


public class Home extends JFrame {
    
    Registro_Pacientes registro_pacientes;
//    Panel_Listar panel_listar;
//    Panel_Modificar panel_modificar;
//    Panel_Eliminar panel_eliminar;
    
    
    JMenuBar barra;
    JMenu menuArchivo;
    JMenuItem menuItemListar;
    JMenuItem menuItemRegistrar;
    JMenuItem menuItemModificar;
    JMenuItem menuItemEliminar;
    JMenuItem menuItemSalir;
    
    public Home() {
        this.inicilizador();
        this.inicilizadorObjetos();
        this.inicilizadorEventos();
    }

    private void inicilizador() {
        this.setSize(550, 500);
        this.setTitle("Inicio");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
  
    }

    private void inicilizadorObjetos() {
        
        barra = new JMenuBar();
        
        menuArchivo = new JMenu("Archivo"); 
        menuItemRegistrar = new JMenuItem("Registrar");
//        menuItemListar = new JMenuItem("Listar");
//        menuItemModificar = new JMenuItem("Modificar");
//        menuItemEliminar = new JMenuItem("Eliminar");     
        menuItemSalir = new JMenuItem("Salir");
//        menuArchivo.add(menuItemListar);
          menuArchivo.add(menuItemRegistrar);
//        menuArchivo.add(menuItemModificar);
//        menuArchivo.add(menuItemEliminar);   
        menuArchivo.add(menuItemSalir);
        barra.add(menuArchivo);
        
        this.setJMenuBar(barra);
        
        registro_pacientes = new Registro_Pacientes();
        this.getContentPane().add(registro_pacientes);
    }

    private void inicilizadorEventos() {
        
        ActionListener listen_menuItemRegistrar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onMenuItemRegistrar();
            }
        };
        menuItemRegistrar.addActionListener(listen_menuItemRegistrar);
        
//        ActionListener listen_menuItemListar = new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                onMenuItemListar();
//            }
//        };
//        menuItemListar.addActionListener(listen_menuItemListar);
//        
//        ActionListener listen_menuItemModificar = new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                onMenuItemModificar();
//            }
//        };
//        menuItemModificar.addActionListener(listen_menuItemModificar);
//        
//        ActionListener listen_menuItemEliminar = new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                onMenuItemEliminar();
//            }
//        };
//        menuItemEliminar.addActionListener(listen_menuItemEliminar);
        
        ActionListener listen_menuItemSalir = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onMenuItemSalir();
            }
        };
        menuItemSalir.addActionListener(listen_menuItemSalir);
       
    }
    
    private void ocultarPaneles() {
        this.registro_pacientes.setVisible(false);
//        this.panel_listar.setVisible(false);
//        this.panel_modificar.setVisible(false);
//        this.panel_eliminar.setVisible(false);
    }
    
    private void onMenuItemRegistrar() {
        this.ocultarPaneles();
        this.registro_pacientes.setVisible(true);
        this.getContentPane().add(registro_pacientes);
    }
    
//      private void onMenuItemListar() {
//        this.ocultarPaneles();
//        this.panel_listar.setVisible(true);
//        this.getContentPane().add(panel_listar);
//    }
//    
//      private void onMenuItemModificar() {
//        this.ocultarPaneles();
//        this.panel_modificar.setVisible(true);
//        this.getContentPane().add(panel_modificar);
//    }
//    
//      private void onMenuItemEliminar() {
//        this.ocultarPaneles();
//        this.panel_eliminar.setVisible(true);
//        this.getContentPane().add(panel_eliminar);
//    }
    
    private void onMenuItemSalir() {
        this.dispose();
    }

}
