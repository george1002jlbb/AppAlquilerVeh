/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appalquilerveh.dao;

import appalquilerveh.logica.Alquiler;
import appalquilerveh.logica.Vehiculo;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jbermudezb
 */
public class AlquilerDao implements IDao{
    
    private Conn conn = new Conn();

    @Override
    public void guardar(Object o) {
        Connection conexion = null;
        PreparedStatement pst = null;
        Alquiler a = (Alquiler) o;
        try {
            conexion = conn.Conectar(); // cargamos la conexion
            pst = conexion.prepareStatement("INSERT INTO alquiler VALUES (?,?,?,?,?,?,?)");
            pst.setInt(1, a.getIdAlquiler());
            pst.setInt(2, a.getNroorden());
            pst.setInt(3, a.getVehiculo());
            pst.setDouble(4, a.getPrecioAlquiler());
            pst.setInt(5, a.getDia());
            pst.setString(6, a.getNombrePersona().toUpperCase());
            pst.setString(7, a.getContactoPersona().trim());
            pst.executeUpdate();
        } catch (IllegalStateException ex) {
            Logger.getLogger(VehiculoDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(VehiculoDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(VehiculoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object consultar(String id) {
        Connection conexion = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Alquiler a = new Alquiler();
        try {
            conexion = conn.Conectar(); // cargamos la conexion
            pst = conexion.prepareStatement("SELECT a.* FROM alquiler a, vehiculo v WHERE v.idvehiculo=a.idvehiculo AND v.matricula = ?");
            pst.setString(1, id);
            rs = pst.executeQuery();
            while (rs.next()) {
                a = Alquiler.load(rs);
            }
        } catch (IllegalStateException ex) {
            Logger.getLogger(VehiculoDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(VehiculoDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(VehiculoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }
    
    public Vehiculo consultarVehiculo(int idvehiculo) throws SQLException, IOException, IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        ResultSet rs = null;
        Vehiculo v = new Vehiculo();
        try {
            pst = conexion.prepareStatement("SELECT * FROM vehiculo WHERE idvehiculo = ?");
            pst.setInt(1, idvehiculo);
            rs = pst.executeQuery();
            while (rs.next()) {
                v = Vehiculo.load(rs);
            }
        } catch (SQLException e) {
            throw new SQLException("Error Method - consultarVehiculoMatricula -- " + e.getMessage());
        } finally {
            conn.close(conexion, pst, rs);
        }
        return v;
    }
    
    public Alquiler consultarAlquilerOrden(int nroorden) throws SQLException, IOException, IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        ResultSet rs = null;
        Alquiler a = new Alquiler();
        try {
            pst = conexion.prepareStatement("SELECT * FROM alquiler WHERE nroorden = ?");
            pst.setInt(1, nroorden);
            rs = pst.executeQuery();
            while (rs.next()) {
                a = Alquiler.load(rs);
            }
        } catch (SQLException e) {
            throw new SQLException("Error Method - consultarAlquilerOrden -- " + e.getMessage());
        } finally {
            conn.close(conexion, pst, rs);
        }
        return a;
    }

    @Override
    public boolean existe(String id) {
        Connection conexion = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conexion = conn.Conectar(); // cargamos la conexion
            pst = conexion.prepareStatement("SELECT COUNT(*) FROM alquiler WHERE nroorden = ?");
            pst.setInt(1, Integer.parseInt(id) );
            rs = pst.executeQuery();
            if (rs.next()) {
                if (rs.getInt(1) == 0) {
                    return false;
                }
            }
        } catch (IllegalStateException ex) {
            Logger.getLogger(VehiculoDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(VehiculoDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(VehiculoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    @Override
    public void modificar(Object o) {
        Connection conexion = null;
        PreparedStatement pst = null;
        Alquiler a = (Alquiler) o;
        try {
            conexion = conn.Conectar(); // cargamos la conexion
            pst = conexion.prepareStatement("UPDATE alquiler SET precio=?, dia=?, nombrePersona=?, contactoPersona=? WHERE nroorden=?");
            pst.setDouble(1, a.getPrecioAlquiler());
            pst.setInt(2, a.getDia());
            pst.setString(3, a.getNombrePersona());
            pst.setString(4, a.getContactoPersona());
            pst.setInt(5, a.getNroorden());
            pst.executeUpdate();
        } catch (IllegalStateException ex) {
            Logger.getLogger(VehiculoDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(VehiculoDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(VehiculoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List listar() {
        Connection conexion = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List lalquiler = new LinkedList();
        try {
            conexion = conn.Conectar(); // cargamos la conexion
            pst = conexion.prepareStatement("SELECT * FROM alquiler a");
            rs = pst.executeQuery();
            while (rs.next()) {
                lalquiler.add(Alquiler.load(rs));
            }
        } catch (IllegalStateException ex) {
            Logger.getLogger(VehiculoDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(VehiculoDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(VehiculoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lalquiler;
    }
    
    public List listarTodosAlquilerOrden(int NROORDEN) throws SQLException, IOException, IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        ResultSet rs = null;
        List lalquiler = new LinkedList();
        try {
            pst = conexion.prepareStatement("SELECT * FROM alquiler WHERE nroorden=?");
            pst.setInt(1, NROORDEN);
            rs = pst.executeQuery();
            while (rs.next()) {
                lalquiler.add(Alquiler.load(rs));
            }
        } catch (SQLException e) {
            throw new SQLException("Error Method - listarTodosAlquilerOrden -- " + e.getMessage());
        } finally {
            conn.close(conexion, pst, rs);
        }
        return lalquiler;
    }
    
    public List listarTodosAlquilerMatricula(String MATRICULA) throws SQLException, IOException, IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        ResultSet rs = null;
        List lalquiler = new LinkedList();
        try {
            pst = conexion.prepareStatement("SELECT a.* FROM alquiler a, vehiculo v WHERE v.idvehiculo=a.idvehiculo AND v.matricula LIKE ?");
            MATRICULA = MATRICULA + "%";
            pst.setString(1, MATRICULA);
            rs = pst.executeQuery();
            while (rs.next()) {
                lalquiler.add(Alquiler.load(rs));
            }
        } catch (SQLException e) {
            throw new SQLException("Error Method - listarTodosAlquilerMatricula -- " + e.getMessage());
        } finally {
            conn.close(conexion, pst, rs);
        }
        return lalquiler;
    }
    
    public List listarTodosAlquilerContacto(String CONTACTO) throws SQLException, IOException, IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        ResultSet rs = null;
        List lalquiler = new LinkedList();
        try {
            pst = conexion.prepareStatement("SELECT * FROM alquiler WHERE nombrePersona LIKE ?");
            CONTACTO = CONTACTO + "%";
            pst.setString(1, CONTACTO);
            rs = pst.executeQuery();
            while (rs.next()) {
                lalquiler.add(Alquiler.load(rs));
            }
        } catch (SQLException e) {
            throw new SQLException("Error Method - listarTodosAlquilerMatricula -- " + e.getMessage());
        } finally {
            conn.close(conexion, pst, rs);
        }
        return lalquiler;
    }

    @Override
    public void eliminar(String id) {
        
    }

    

}
