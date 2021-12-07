/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import model.*;
import entity.Usuario;
import java.util.List;

/**
 *
 * @author milan
 */
public interface IUsuarioService {
    public void crearRegistro(Usuario usuario);    
    public List<Usuario> obtenerRegistros();
    public Usuario obtenerRegistro(String idUsuario);
    public void actualizarRegistro(Usuario usuario);
    public void eliminarRegistro(Usuario usuario);
}
