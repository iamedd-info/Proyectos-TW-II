package service;



import model.*;
import entity.Usuario;

import java.util.List;

/**
 *
 * @author milan
 */
public class UsuarioServicelImpl implements IUsuarioService {
    private IUsuarioModel model = new UsuarioModelImpl();

    @Override
    public void crearRegistro(Usuario usuario) {
        model.crearRegistro(usuario);
    }

    @Override
    public List<Usuario> obtenerRegistros() {
        return model.obtenerRegistros();
    }

    @Override
    public Usuario obtenerRegistro(String idUsuario) {
        return model.obtenerRegistro(idUsuario);
    }

    @Override
    public void actualizarRegistro(Usuario usuario) {
        model.actualizarRegistro(usuario);
    }

    @Override
    public void eliminarRegistro(Usuario usuario) {
        model.eliminarRegistro(usuario);
    }
    
}
