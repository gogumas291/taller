package Paneles;

import Servicios.ListaSimple;
import Modelos.Paciente;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Registro_Pacientes extends JPanel{
    
    ListaSimple lista = new ListaSimple();
    int aux = 0;
    JPanel jPanel;
    JLabel lblTitulo;
    JLabel lblCedula;
    JLabel lblNombre;
    JLabel lblCama;
    
    JTextField txtCedula;
    JTextField txtNombre;
    JTextField txtCama;
    
    JButton btnRegistro;    
    JButton btnListado; 
    JButton btnModificar;
    JButton btnEliminar; 
     
    
    public Registro_Pacientes(){
        this.inicializador();
        this.inicializadorObjetos();
        this.inicializadorEventos();
        
    }

    private void inicializador() {
        this.setLayout(new BorderLayout());
        this.setBackground(Color.LIGHT_GRAY);
        
        
    }

    private void inicializadorObjetos() {
        
        jPanel = new JPanel();
        jPanel.setLayout(null);
        
        lblTitulo = new JLabel("------------------------------------- "
                + "REGISTRO DE PACIENTES "
                + "-------------------------------------");
        lblTitulo.setBounds(50, 15, 2000, 20);
        jPanel.add(lblTitulo);
                
        lblCedula = new JLabel("Cedula");
        lblCedula.setBounds(50, 50, 100, 20);
        jPanel.add(lblCedula);
        
        txtCedula = new JTextField();
        txtCedula.setBounds(170, 50, 150, 20);
        jPanel.add(txtCedula);
        
        lblNombre = new JLabel("Nombre");
        lblNombre.setBounds(50, 80, 100, 20);
        jPanel.add(lblNombre);
        
        txtNombre = new JTextField();
        txtNombre.setBounds(170, 80, 150, 20);
        jPanel.add(txtNombre);
        
        lblCama = new JLabel("Cama");
        lblCama.setBounds(50, 110, 100, 20);
        jPanel.add(lblCama);
        
        txtCama = new JTextField();
        txtCama.setBounds(170, 110, 150, 20);
        jPanel.add(txtCama);
        
        btnRegistro = new JButton("Registrar");
        btnRegistro.setBounds(50, 160, 100, 20);
        jPanel.add(btnRegistro);
        
        btnListado = new JButton("Listado");
        btnListado.setBounds(170, 160, 100, 20);
        jPanel.add(btnListado);
        
        btnModificar = new JButton("Modificar");
        btnModificar.setBounds(290, 160, 100, 20);
        jPanel.add(btnModificar);
        
        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(410, 160, 100, 20);
        jPanel.add(btnEliminar);
        
        this.add(jPanel);
        
    }

    private void inicializadorEventos() {
        ActionListener listen_btnRegistro = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onClickbtnRegistro();
            }
        };
        btnRegistro.addActionListener(listen_btnRegistro);
        
         ActionListener listen_btnListado = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onClickbtnListado();
            }
        };
        btnListado.addActionListener(listen_btnListado);
        
         ActionListener listen_btnModificar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onClickbtnModificar();
            }
        };
        btnModificar.addActionListener(listen_btnModificar);
        
         ActionListener listen_btnEliminar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onClickbtnEliminar();
            }
        };
        btnEliminar.addActionListener(listen_btnEliminar);
     
    }
    
    public void onClickbtnRegistro(){
        int cedula = 0;
        try {
            String Stringcedula = txtCedula.getText();
            cedula = Integer.parseInt(Stringcedula);
            String nombre = txtNombre.getText();
            String cama = txtCama.getText();
            Paciente paciente = new Paciente(cedula,nombre,cama);
            lista.insertar(paciente);

            txtCedula.setText(null);
            txtNombre.setText(null);
            txtCama.setText(null);
        } catch (NumberFormatException numberFormatException) {
        }

        if (cedula != 0) {
            JOptionPane.showMessageDialog(null, "Dato ingresado correctamente");
        }else{
        JOptionPane.showMessageDialog(null, "La cedula debe ser un numero y no puede estar vacia");
        }
       
    }  
    
    public void onClickbtnListado(){
       lista.listar();     
    }  
    public void onClickbtnModificar(){
        
        if (aux == 0) {
            String Stringcedula = txtCedula.getText();
        
        int cedula = 0;
        try {
            cedula = Integer.parseInt(Stringcedula);
            lista.buscar(cedula);
            
            txtCedula.setText(null);
            txtNombre.setText(null);
            txtCama.setText(null);
            JOptionPane.showMessageDialog(null, "Ingrese los nuevos datos");
        } catch (NumberFormatException numberFormatException) {
            JOptionPane.showMessageDialog(null, "La cedula debe ser un numero y no puede estar vacia");
        }
        aux++;
        }else{
        int cedula = 0;
        try {
            String Stringcedula = txtCedula.getText();
            cedula = Integer.parseInt(Stringcedula);
            String nombre = txtNombre.getText();
            String cama = txtCama.getText();
            Paciente paciente = new Paciente(cedula,nombre,cama);
            
            lista.modificar(paciente);

            txtCedula.setText(null);
            txtNombre.setText(null);
            txtCama.setText(null);
        } catch (NumberFormatException numberFormatException) {
        }

        if (cedula != 0) {
            JOptionPane.showMessageDialog(null, "Dato modificado correctamente");
        }else{
        JOptionPane.showMessageDialog(null, "La cedula debe ser un numero y no puede estar vacia");
        }    
            
            
            
        aux--;
        }
        
        
        
    } 
    public void onClickbtnEliminar(){
        String Stringcedula = txtCedula.getText();
        
        int cedula = 0;
        try {
            cedula = Integer.parseInt(Stringcedula);
        } catch (NumberFormatException numberFormatException) {
            JOptionPane.showMessageDialog(null, "La cedula debe ser un numero y no puede estar vacia");
        }
        lista.eliminar(cedula);
    } 

   

}