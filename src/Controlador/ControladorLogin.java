package Controlador;

import Modelo.Conexion;
import Modelo.Usuario;
import java.sql.*;

public class ControladorLogin {

    Conexion conexion = new Conexion();
    Connection con = conexion.realziarConexion();
    PreparedStatement ps = null;

    public int registrarUsuario(String correo, String cont, String id, String pn, String sn, String tel, String ap, Date fn, String genero) {

        String sql1 = "Select * from usuario";
        String sql = "insert into Usuario (correo,contraseña,documento,primernombre,segundonombre,telefono,apellidos,fechadenacimiento,género) values (?,?,?,?,?,?,?,?,?)";

        Statement st;
        ResultSet result;
        try {
            st = con.createStatement();
            result = st.executeQuery(sql1);
            while (result.next()) {
                if (correo.equals(result.getString(1))) {
                    return 0;
                }
            }

            ps = con.prepareStatement(sql);
            ps.setString(1, correo);
            ps.setString(2, cont);
            ps.setString(3, id);
            ps.setString(4, pn);
            ps.setString(5, sn);
            ps.setString(6, tel);
            ps.setString(7, ap);
            ps.setDate(8, fn);
            ps.setString(9, genero);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error de Conexion1: " + e.getMessage());
        }
        return 1;
    }

    public int verificarUsuario(Usuario usuario, String correo, String cont) {
        String sql = "SELECT * FROM Usuario";
        int i=0;
        Statement st;
        ResultSet result;
        try {//USUARIO
            st = con.createStatement();
            result = st.executeQuery(sql);
            while (result.next()) {
                if (correo.equals(result.getString(1)) && cont.equals(result.getString(2))) {
                    usuario.setCorreo(correo);
                    usuario.setPrimerNombre(result.getString(4));
                    usuario.setSegundoNombre(result.getString(5));
                    usuario.setApellidos(result.getString(7));
                    usuario.setTelefono(result.getString(6));
                    usuario.setDocumento(result.getString(3));
                    System.out.println("correcto");
                    i=1;
                } 
            }
        } catch (SQLException e) {
            System.out.println("Error de Conexion1: " + e.getMessage());
        }

        return i;
    }
}
