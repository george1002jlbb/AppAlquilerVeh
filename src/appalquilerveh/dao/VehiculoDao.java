/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appalquilerveh.dao;

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
public class VehiculoDao implements IDao {

    private Conn conn = new Conn();

    @Override
    public void guardar(Object o) {
        Connection conexion = null;
        PreparedStatement pst = null;
        Vehiculo v = (Vehiculo) o;
        try {
            conexion = conn.Conectar(); // cargamos la conexion
            pst = conexion.prepareStatement("INSERT INTO vehiculo VALUES (?,?,?,?)");
            pst.setInt(1, v.getIdvehiculo());
            pst.setString(2, v.getMatricula());
            pst.setString(3, v.getTipo());
            pst.setString(4, v.getDescripcion());
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
        Vehiculo v = new Vehiculo();
        try {
            conexion = conn.Conectar(); // cargamos la conexion
            pst = conexion.prepareStatement("SELECT * FROM vehiculo WHERE matricula = ?");
            pst.setString(1, id);
            rs = pst.executeQuery();
            while (rs.next()) {
                v = Vehiculo.load(rs);
            }
        } catch (IllegalStateException ex) {
            Logger.getLogger(VehiculoDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(VehiculoDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(VehiculoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v;
    }
    
    

    @Override
    public void modificar(Object o) {
        Connection conexion = null;
        PreparedStatement pst = null;
        Vehiculo v = (Vehiculo) o;
        try {
            conexion = conn.Conectar(); // cargamos la conexion
            pst = conexion.prepareStatement("UPDATE vehiculo SET tipo=?, descripcion=? WHERE matricula=?");
            pst.setString(1, v.getTipo());
            pst.setString(2, v.getDescripcion());
            pst.setString(3, v.getMatricula());
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
        List lveh = new LinkedList();
        try {
            conexion = conn.Conectar(); // cargamos la conexion
            pst = conexion.prepareStatement("SELECT * FROM vehiculo");
            rs = pst.executeQuery();
            while (rs.next()) {
                lveh.add(Vehiculo.load(rs));
            }
        } catch (IllegalStateException ex) {
            Logger.getLogger(VehiculoDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(VehiculoDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(VehiculoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lveh;
    }
    
    public List listarTodosVehiculosMatricula(String MATRICULA) throws SQLException, IOException, IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        ResultSet rs = null;
        List lveh = new LinkedList();
        try {
            pst = conexion.prepareStatement("SELECT * FROM vehiculo WHERE matricula LIKE ?");
            MATRICULA = MATRICULA + "%";
            pst.setString(1, MATRICULA);
            rs = pst.executeQuery();
            while (rs.next()) {
                lveh.add(Vehiculo.load(rs));
            }
        } catch (SQLException e) {
            throw new SQLException("Error Method - listarTodosVehiculosMatricula -- " + e.getMessage());
        } finally {
            conn.close(conexion, pst, rs);
        }
        return lveh;
    }
    
    public List listarTodosVehiculosTipo(String TIPO) throws SQLException, IOException, IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        ResultSet rs = null;
        List lveh = new LinkedList();
        try {
            pst = conexion.prepareStatement("SELECT * FROM vehiculo WHERE tipo=?");
            pst.setString(1, TIPO);
            rs = pst.executeQuery();
            while (rs.next()) {
                lveh.add(Vehiculo.load(rs));
            }
        } catch (SQLException e) {
            throw new SQLException("Error Method - listarTodosVehiculosTipo -- " + e.getMessage());
        } finally {
            conn.close(conexion, pst, rs);
        }
        return lveh;
    }

    @Override
    public void eliminar(String id) {

    }

    @Override
    public boolean existe(String id) {
        Connection conexion = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conexion = conn.Conectar(); // cargamos la conexion
            pst = conexion.prepareStatement("SELECT COUNT(*) FROM vehiculo WHERE matricula = ?");
            pst.setString(1, id);
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

}
