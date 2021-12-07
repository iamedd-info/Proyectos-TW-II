package service;



import model.*;
import entity.Desarrollador;

import java.util.List;

/**
 *
 * @author milan
 */
public class DesarrolladorServicelImpl implements IDesarrolladorService {
    private IDesarrolladorModel model = new DesarrolladorModelImpl();

    @Override
    public void crearRegistro(Desarrollador desarrollador) {
        model.crearRegistro(desarrollador);
    }

    @Override
    public List<Desarrollador> obtenerRegistros() {
        return model.obtenerRegistros();
    }

    @Override
    public Desarrollador obtenerRegistro(String idDesarrollador) {
        return model.obtenerRegistro(idDesarrollador);
    }

    @Override
    public void actualizarRegistro(Desarrollador desarrollador) {
        model.actualizarRegistro(desarrollador);
    }

    @Override
    public void eliminarRegistro(Desarrollador desarrollador) {
        model.eliminarRegistro(desarrollador);
    }
}
