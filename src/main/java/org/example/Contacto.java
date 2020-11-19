package org.example;

public class Contacto {

   private String Nombre;
    private long Edad;
    private String Coche;

    public Contacto() {
    }

    public Contacto(String nombre, long edad, String coche) {
        Nombre = nombre;
        Edad = edad;
        Coche = coche;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public long getEdad() {
        return Edad;
    }

    public void setEdad(long edad) {
        Edad = edad;
    }

    public String getCoche() {
        return Coche;
    }

    public void setCoche(String coche) {
        Coche = coche;
    }
}
