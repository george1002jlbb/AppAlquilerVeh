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
public class Vehiculo {

    private String matricula;
    private String tipo;

    public Vehiculo() {
    }

    public Vehiculo(String matricula, String tipo) {
        this.matricula = matricula;
        this.tipo = tipo;
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

    @Override
    public String toString() {
        return "Vehiculo{" + "matricula=" + matricula + ", tipo=" + tipo + '}';
    }
    
}
