
package Modelo;


public class Boleta {
    String nombre,pelicula,sala,hora;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPelicula(String pelicula) {
        this.pelicula = pelicula;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setnAsientos(int nAsientos) {
        this.nAsientos = nAsientos;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPelicula() {
        return pelicula;
    }

    public String getSala() {
        return sala;
    }

    public String getHora() {
        return hora;
    }

    public int getnAsientos() {
        return nAsientos;
    }

    public int getPrecio() {
        return precio;
    }
    int nAsientos,precio;
    
}
