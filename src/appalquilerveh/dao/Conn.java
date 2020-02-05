/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appalquilerveh.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Jorge Bermudez
 */
public class Conn {

    private Connection conn;
    private String nombre_bd;
    private String usuario;
    private String pass;
    private String puerto;
    private String server;

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public String getNombre_bd() {
        return nombre_bd;
    }

    public void setNombre_bd(String nombre_bd) {
        this.nombre_bd = nombre_bd;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPuerto() {
        return puerto;
    }

    public void setPuerto(String puerto) {
        this.puerto = puerto;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

//    public Conn() {
//        this.conn = conn;
//        this.server = server;
//        this.puerto = puerto;
//        this.nombre_bd = nombre_bd;
//        this.usuario = usuario;
//        this.pass = pass;
//    }

    public Connection Conectar() throws FileNotFoundException, IOException, IllegalStateException, NoSuchAlgorithmException, Exception {

        //System.out.println("clave "+clave);
        //System.out.println("clave "+encriptar.encriptar(clave).toString().toUpperCase());
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // CONEXION
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/alquiler", "root", "");
            System.out.println("Conexion Exitosa");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("ERROR " + e.getMessage());
        }

        return conn;
    }

    public void Desconectar() {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Conexion Cerrada");
            } catch (Exception e) {
                // throw new SQLException("ERROR AL DESCONECTAR \n -- " + se.getMessage());
                System.out.println("ERROR " + e.getMessage());
            } finally {
                conn = null;
            }
        }
    }

    public void close(Connection con, PreparedStatement dtm, ResultSet rs) throws SQLException {
        try {
            if (dtm != null) {
                dtm.close();
            }
            if (rs != null) {
                rs.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (Exception ex) {
            throw new SQLException("Error Method - close \n -- " + ex.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Conexion{" + "conn=" + conn + ", nombre_bd=" + nombre_bd + ", usuario=" + usuario + ", pass=" + pass + ", puerto=" + puerto + '}';
    }
}
