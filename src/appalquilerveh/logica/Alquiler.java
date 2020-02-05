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
public class Alquiler {
    
    private int idAlquiler;
    private int nroorden;
    private int vehiculo;
    private double precioAlquiler;
    private String nombrePersona;
    private String contactoPersona;

    public Alquiler() {
    }

    public Alquiler(int vehiculo, double precioAlquiler) {
        this.vehiculo = vehiculo;
        this.precioAlquiler = precioAlquiler;
    }

    public int getIdAlquiler() {
        return idAlquiler;
    }

    public void setIdAlquiler(int idAlquiler) {
        this.idAlquiler = idAlquiler;
    }

    public int getNroorden() {
        return nroorden;
    }

    public void setNroorden(int nroorden) {
        this.nroorden = nroorden;
    }

    public int getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(int vehiculo) {
        this.vehiculo = vehiculo;
    }

    public double getPrecioAlquiler() {
        return precioAlquiler;
    }

    public void setPrecioAlquiler(double precioAlquiler) {
        this.precioAlquiler = precioAlquiler;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getContactoPersona() {
        return contactoPersona;
    }

    public void setContactoPersona(String contactoPersona) {
        this.contactoPersona = contactoPersona;
    }

    @Override
    public String toString() {
        return "Alquiler{" + "vehiculo=" + vehiculo + ", precioAlquiler=" + precioAlquiler + ", nombrePersona=" + nombrePersona + ", contactoPersona=" + contactoPersona + '}';
    }
    
    public static Alquiler load(ResultSet rs) throws SQLException {
        Alquiler a = new Alquiler();
        
        a.setVehiculo(rs.getInt(1));
        a.setPrecioAlquiler(rs.getDouble(2));
        a.setNombrePersona(rs.getString(3));
        a.setContactoPersona(rs.getString(4));
        
        return a;
    }
    
}
