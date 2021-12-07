/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import model.*;
import entity.Desarrollador;
import java.util.List;

/**
 *
 * @author milan
 */
public interface IDesarrolladorService {
    public void crearRegistro(Desarrollador desarrollador);    
    public List<Desarrollador> obtenerRegistros();
    public Desarrollador obtenerRegistro(String idDesarrollador);
    public void actualizarRegistro(Desarrollador desarrollador);
    public void eliminarRegistro(Desarrollador desarrollador);
}
