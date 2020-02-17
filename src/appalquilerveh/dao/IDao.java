/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appalquilerveh.dao;

import java.util.List;

/**
 *
 * @author jbermudezb
 */
public interface IDao {

    public void guardar(Object o);

    public Object consultar(String id);

    public boolean existe(String id);

    public void modificar(Object o);

    public List listar();

    public void eliminar(String id);

}
