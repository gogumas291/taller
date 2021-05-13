package Servicios;

import Modelos.Paciente;
import javax.swing.JOptionPane;

public class ListaSimple {
    
    private Nodo inicio;
    private Nodo fin;
   
    public ListaSimple(){
        inicio = null;
        fin = null;
    }
    
    public boolean estaVacia(){
        if (inicio==null) {
            return true;
        }else{
            return false;
        }
    }
   
    public void insertar(Paciente paciente){
        Nodo actual; // hace referencia al dato o elemento actual
        if (estaVacia()) { //si es verdadero no hay elementos en la lista
            actual = new Nodo(paciente, null);
            inicio = actual;
            fin = actual;
        }else{
                actual = new Nodo(paciente, null);
                fin.setSiguiente(actual);
                fin = actual;
            }
    }
    
    public void listar(){
        if (estaVacia()) {
            JOptionPane.showMessageDialog(null, "La lista está vacia");
        }else{
                Nodo temporal;
                temporal = inicio; // permite recorrer la lista sin perder la referencia de inicio
                while(temporal !=null){
                    JOptionPane.showMessageDialog(null, temporal.getDato().toString());
                    temporal = temporal.getSiguiente();
                } 
             }
    }
    
    public void buscar(int cedula){
        if (estaVacia()) {
                JOptionPane.showMessageDialog(null, "La lista está vacia");
            }else{
                    Nodo temporal;
                    temporal = inicio; 
                    while(temporal !=null){
                        //este if permite detener el recorrido cuando encuentra el dato
                        if (cedula==temporal.getDato().getCedula()) {
                            JOptionPane.showMessageDialog(null, temporal.getDato().toString());
                            break;
                        }
                        temporal = temporal.getSiguiente();
                    }
                    if (temporal ==null) {
                JOptionPane.showMessageDialog(null, "No se encuentra el dato");
                
            }
                    
                 }
    }
    public void eliminar(int cedula){
        if (estaVacia()) {
                JOptionPane.showMessageDialog(null, "La lista está vacia");
        }else if (inicio==fin && cedula==inicio.getDato().getCedula()) {
                  inicio=fin=null;
            }else if (cedula==inicio.getDato().getCedula()) {
                  inicio=inicio.getSiguiente();
            
            }else{
                Nodo anterior,temporal;
                anterior=inicio;
                temporal=inicio.getSiguiente();
                
                //se recore la lista buscando la cedula 
                while(temporal !=null && temporal.getDato().getCedula() != cedula){
                    anterior=anterior.getSiguiente();
                    temporal=temporal.getSiguiente();
                }
                if (temporal != null) {
                    anterior.setSiguiente(temporal.getSiguiente());
                    if (temporal == fin) {
                        fin = anterior;
                    }
                }
            }
    }
    public void modificar(Paciente paciente){
        Nodo actual;
        actual = inicio; 
        while(actual !=null){
            //este if permite detener el recorrido cuando encuentra el dato
            if (paciente.getCedula()==actual.getDato().getCedula()) {
                JOptionPane.showMessageDialog(null, actual.getDato().toString());
                actual.setDato(paciente);
                break;
            }
            actual = actual.getSiguiente();
        }
    }
}
