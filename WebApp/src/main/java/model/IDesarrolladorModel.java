/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Desarrollador;
import java.util.List;

/**
 *
 * @author milan
 */
public interface IDesarrolladorModel {
    public void crearRegistro(Desarrollador desarrollador);    
    public List<Desarrollador> obtenerRegistros();
    public Desarrollador obtenerRegistro(String iddesarrollador);
    public void actualizarRegistro(Desarrollador desarrollador);
    public void eliminarRegistro(Desarrollador desarrollador);
}
