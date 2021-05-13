
package Modelos;

public class Paciente {
    
    private int cedula;
    private String nombre;
    private String cama;
    
    public Paciente(int cedula, String nombre, String cama){
        this.cedula = cedula;
        this.nombre = nombre;
        this.cama =cama;
    }

    @Override
    public String toString() {
        return "Paciente{" + "cedula=" + cedula + ", nombre=" + nombre + ", cama=" + cama + '}';
    }
    // gracias profe por la explicacion sin esto no me salia nada 

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCama() {
        return cama;
    }

    public void setCama(String cama) {
        this.cama = cama;
    }
   
}
