/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appalquilerveh.logica;

/**
 *
 * @author Jorge Bermudez
 */
public class Combo {
    private int IdCombo;
    private String DescripcionCombo;

    public Combo() {
    }

    public Combo(int IdCombo, String DescripcionCombo) {
        this.IdCombo = IdCombo;
        this.DescripcionCombo = DescripcionCombo;
    }

    public int getIdCombo() {
        return IdCombo;
    }

    public void setIdCombo(int IdCombo) {
        this.IdCombo = IdCombo;
    }

    public String getDescripcionCombo() {
        return DescripcionCombo;
    }

    public void setDescripcionCombo(String DescripcionCombo) {
        this.DescripcionCombo = DescripcionCombo;
    }

    @Override
    public String toString() {
        return DescripcionCombo;
    }

}
