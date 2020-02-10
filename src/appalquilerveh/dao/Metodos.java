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
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Jorge Bermudez
 */
public class Metodos {

    private Conn conn = new Conn();

    // MODULO DE VEHICULO
    public void guardarVehiculo(Vehiculo v) throws IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        try {
            pst = conexion.prepareStatement("INSERT INTO vehiculo VALUES (?,?,?,?)");
            pst.setInt(1, v.getIdvehiculo());
            pst.setString(2, v.getMatricula());
            pst.setString(3, v.getTipo());
            pst.setString(4, v.getDescripcion());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Error Method - guardarVehiculo -- " + e.getMessage());
        } finally {
            conn.close(conexion, pst, null);
        }
    }

    public Vehiculo consultarVehiculoMatricula(String matricula) throws SQLException, IOException, IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        ResultSet rs = null;
        Vehiculo v = new Vehiculo();
        try {
            pst = conexion.prepareStatement("SELECT * FROM vehiculo WHERE matricula = ?");
            pst.setString(1, matricula);
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

    public boolean existeVehiculo(String veh) throws SQLException, IOException, IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        ResultSet rs = null;
        Vehiculo v = new Vehiculo();
        try {
            pst = conexion.prepareStatement("SELECT COUNT(*) FROM vehiculo WHERE matricula = ?");
            pst.setString(1, veh);
            rs = pst.executeQuery();
            if (rs.next()) {
                if (rs.getInt(1) == 0) {
                    return false;
                }
            }
        } catch (SQLException e) {
            throw new SQLException("Error Method - existeVehiculo -- " + e.getMessage());
        } finally {
            conn.close(conexion, pst, rs);
        }
        return true;
    }

    public void modificarVehiculo(Vehiculo v) throws SQLException, IOException, IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        try {
            pst = conexion.prepareStatement("UPDATE vehiculo SET tipo=?, descripcion=? WHERE matricula=?");
            pst.setString(1, v.getTipo());
            pst.setString(2, v.getDescripcion());
            pst.setString(3, v.getMatricula());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Error Method - modificarVehiculo -- " + e.getMessage());
        } finally {
            conn.close(conexion, pst, null);
        }
    }

    public List listarTodosVehiculos() throws SQLException, IOException, IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        ResultSet rs = null;
        List lveh = new LinkedList();
        try {
            pst = conexion.prepareStatement("SELECT * FROM vehiculo");
            rs = pst.executeQuery();
            while (rs.next()) {
                lveh.add(Vehiculo.load(rs));
            }
        } catch (SQLException e) {
            throw new SQLException("Error Method - listarTodosVehiculos -- " + e.getMessage());
        } finally {
            conn.close(conexion, pst, rs);
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

    // MODULO ALQUILER
    public void guardarAlquiler(Alquiler a) throws IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        try {
            pst = conexion.prepareStatement("INSERT INTO alquiler VALUES (?,?,?,?,?,?,?)");
            pst.setInt(1, a.getIdAlquiler());
            pst.setInt(2, a.getNroorden());
            pst.setInt(3, a.getVehiculo());
            pst.setDouble(4, a.getPrecioAlquiler());
            pst.setInt(5, a.getDia());
            pst.setString(6, a.getNombrePersona().toUpperCase());
            pst.setString(7, a.getContactoPersona().trim());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Error Method - guardarAlquiler -- " + e.getMessage());
        } finally {
            conn.close(conexion, pst, null);
        }
    }

    public Alquiler consultarAlquiler(String matricula) throws SQLException, IOException, IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        ResultSet rs = null;
        Alquiler a = new Alquiler();
        try {
            pst = conexion.prepareStatement("SELECT a.* FROM alquiler a, vehiculo v WHERE v.idvehiculo=a.idvehiculo AND v.matricula = ?");
            pst.setString(1, matricula);
            rs = pst.executeQuery();
            while (rs.next()) {
                a = Alquiler.load(rs);
            }
        } catch (SQLException e) {
            throw new SQLException("Error Method - consultarAlquiler -- " + e.getMessage());
        } finally {
            conn.close(conexion, pst, rs);
        }
        return a;
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

    public List listarTodosAlquiler() throws SQLException, IOException, IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        ResultSet rs = null;
        List lalquiler = new LinkedList();
        try {
            pst = conexion.prepareStatement("SELECT * FROM alquiler a");
            rs = pst.executeQuery();
            while (rs.next()) {
                lalquiler.add(Alquiler.load(rs));
            }
        } catch (SQLException e) {
            throw new SQLException("Error Method - listarTodosAlquiler -- " + e.getMessage());
        } finally {
            conn.close(conexion, pst, rs);
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

    public boolean existeAlquiler(int nroorden) throws SQLException, IOException, IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conexion.prepareStatement("SELECT COUNT(*) FROM alquiler WHERE nroorden = ?");
            pst.setInt(1, nroorden);
            rs = pst.executeQuery();
            if (rs.next()) {
                if (rs.getInt(1) == 0) {
                    return false;
                }
            }
        } catch (SQLException e) {
            throw new SQLException("Error Method - existeAlquiler -- " + e.getMessage());
        } finally {
            conn.close(conexion, pst, rs);
        }
        return true;
    }

    public void modificarAlquiler(Alquiler a) throws SQLException, IOException, IllegalStateException, NoSuchAlgorithmException, Exception {
        Connection conexion = conn.Conectar(); // cargamos la conexion
        PreparedStatement pst = null;
        try {
            pst = conexion.prepareStatement("UPDATE alquiler SET precio=?, dia=?, nombrePersona=?, contactoPersona=? WHERE nroorden=?");
            pst.setDouble(1, a.getPrecioAlquiler());
            pst.setInt(2, a.getDia());
            pst.setString(3, a.getNombrePersona());
            pst.setString(4, a.getContactoPersona());
            pst.setInt(5, a.getNroorden());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Error Method - modificarAlquiler -- " + e.getMessage());
        } finally {
            conn.close(conexion, pst, null);
        }
    }

}
