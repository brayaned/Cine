package Controlador;

import Modelo.Boleta;
import Modelo.Conexion;
import Modelo.Pelicula;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ControladorPrincipal {

    Pelicula p = new Pelicula();
    Boleta b;
    Conexion conexion = new Conexion();
    Connection con = conexion.realziarConexion();
    PreparedStatement ps = null;

    public Pelicula seleccionarPelicula(String nombrePelicula) {
        String sql = "SELECT * FROM película";
        Statement st;
        ResultSet result;
        try {//USUARIO
            st = con.createStatement();
            result = st.executeQuery(sql);
            while (result.next()) {
                if (nombrePelicula.equals(result.getString(1))) {
                    p.setTitulo(nombrePelicula);
                    p.setDuracion(result.getString(2));
                    p.setGenero(result.getString(3));
                    p.setDirector(result.getString(4));
                    p.setDescripcion(result.getString(5));
                    System.out.println("correcto");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error de Conexion1: " + e.getMessage());
        }
        return p;
    }

    public Boleta verificarAsientos(Boleta boleta) {
        b = boleta;
        String sql = "SELECT * FROM sala";
        Statement st;
        ResultSet result;
        try {//USUARIO
            st = con.createStatement();
            result = st.executeQuery(sql);
            while (result.next()) {
                if (b.getSala().equals(result.getString(1))) {
                    if (b.getnAsientos() + result.getInt(3) > 50) {
                        b = null;
                    } else {
                        b.setnAsientos(b.getnAsientos() + result.getInt(3));
                        ps = con.prepareStatement("UPDATE sala SET sillasocupadas='" + b.getnAsientos() + "' WHERE id_sala='" + b.getSala() + "'");
                        ps.executeUpdate();
                    }
                }

            }
        } catch (SQLException e) {
            System.out.println("Error de Conexion1: " + e.getMessage());
        }

        return b;
    }
    
    public int borrarSusuario(Usuario u){
        String sql = "SELECT * FROM usuario";
        Statement st;
        ResultSet result;
        int i=0;
        try {//USUARIO
            st = con.createStatement();
            result = st.executeQuery(sql);
            while (result.next()) {
                if (u.getCorreo().equals(result.getString(1))) {
                    ps = con.prepareStatement("DELETE FROM usuario  WHERE correo='" + u.getCorreo() + "'");
                    ps.executeUpdate();
                    i=1;
                    
                }else{
                    i=0;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error de Conexion1: " + e.getMessage());
        }
        return i;
    }

}
