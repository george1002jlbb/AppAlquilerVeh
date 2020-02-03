/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appalquilerveh.logica;

/**
 *
 * @author jbermudezb
 */
public class Alquiler {
    
    private Vehiculo vehiculo;
    private double precioAlquiler;

    public Alquiler() {
    }

    public Alquiler(Vehiculo vehiculo, double precioAlquiler) {
        this.vehiculo = vehiculo;
        this.precioAlquiler = precioAlquiler;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public double getPrecioAlquiler() {
        return precioAlquiler;
    }

    public void setPrecioAlquiler(double precioAlquiler) {
        this.precioAlquiler = precioAlquiler;
    }

    @Override
    public String toString() {
        return "Alquiler{" + "vehiculo=" + vehiculo + ", precioAlquiler=" + precioAlquiler + '}';
    }
    
}
