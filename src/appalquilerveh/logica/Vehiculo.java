/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appalquilerveh.logica;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author jbermudezb
 */
public class Vehiculo {

    private int idvehiculo;
    private String matricula;
    private String tipo;
    private String descripcion;

    public Vehiculo() {
    }

    public Vehiculo(int idvehiculo, String matricula, String tipo, String descripcion) {
        this.idvehiculo = idvehiculo;
        this.matricula = matricula;
        this.tipo = tipo;
        this.descripcion = descripcion;
    }

    public int getIdvehiculo() {
        return idvehiculo;
    }

    public void setIdvehiculo(int idvehiculo) {
        this.idvehiculo = idvehiculo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "idvehiculo=" + idvehiculo + ", matricula=" + matricula + ", tipo=" + tipo + ", descripcion=" + descripcion + '}';
    }
    
    public static Vehiculo load(ResultSet rs) throws SQLException {
        Vehiculo v = new Vehiculo();
        
        v.setIdvehiculo(rs.getInt(1));
        v.setMatricula(rs.getString(2));
        v.setTipo(rs.getString(3));
        v.setDescripcion(rs.getString(4));
        
        return v;
    }
    
}
