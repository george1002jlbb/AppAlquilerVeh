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
    private int dia;
    private final int base =50;
    private int pma;
    private String nombrePersona;
    private String contactoPersona;

    public Alquiler() {
    }

    public Alquiler(int idAlquiler, int nroorden, int vehiculo, double precioAlquiler, int dia, String nombrePersona, String contactoPersona) {
        this.idAlquiler = idAlquiler;
        this.nroorden = nroorden;
        this.vehiculo = vehiculo;
        this.precioAlquiler = precioAlquiler;
        this.dia = dia;
        this.nombrePersona = nombrePersona;
        this.contactoPersona = contactoPersona;
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

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getBase() {
        return base;
    }

    public int getPma() {
        return pma;
    }

    public void setPma(int pma) {
        this.pma = pma;
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
        
        a.setIdAlquiler(rs.getInt(1));
        a.setNroorden(rs.getInt(2));
        a.setVehiculo(rs.getInt(3));
        a.setPrecioAlquiler(rs.getDouble(4));
        a.setDia(rs.getInt(5));
        a.setNombrePersona(rs.getString(6));
        a.setContactoPersona(rs.getString(7));
        
        return a;
    }
    
}
