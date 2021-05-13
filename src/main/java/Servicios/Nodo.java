package Servicios;

import Modelos.Paciente;

public class Nodo {

    private Paciente dato;  // El elemento o dato de la lista es la clase Paciente
    private Nodo siguiente;

    public Nodo(Paciente dato, Nodo siguiente) {
        this.dato = dato;
        this.siguiente = siguiente;
    }

// ------------Agrego Seters y Geters ------------------
    public Paciente getDato() {
        return dato;
    }

    public void setDato(Paciente dato) {
        this.dato = dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }


}
