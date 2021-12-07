package model;



import entity.Usuario;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author milan
 */
public class UsuarioModelImpl implements IUsuarioModel {
    private SessionFactory f;
    private Session s;
    @Override
    public void crearRegistro(Usuario usuario) {        
        try {
            f = new Configuration().configure().buildSessionFactory();
            s = f.openSession();
            s.beginTransaction();
            s.save(usuario);
            s.getTransaction().commit();
            s.close();
            f.close();
        } catch (HibernateException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public List<Usuario> obtenerRegistros() {
         try {
            f = new Configuration().configure().buildSessionFactory();
            s = f.openSession();
            List<Usuario> lista = s.createCriteria(Usuario.class).list();
            s.close();
            f.close();
            return lista;
        } catch (HibernateException e) {
            System.out.println("Error: " + e.getMessage());
        }
         return null;
    }
    
    public static void main(String[] args) {
        Usuario u = new Usuario();
        u.setIdUsuario(6);
        u.setNombre("Juan");
        IUsuarioModel model = new UsuarioModelImpl();
        model.crearRegistro(u);
        
        System.out.println("Lista: " + model.obtenerRegistros().size());
    }

    @Override
    public Usuario obtenerRegistro(String idUsuario) {
        try {
            f = new Configuration().configure().buildSessionFactory();
            s = f.openSession();
            Usuario usuario = (Usuario) s.get(Usuario.class, idUsuario);
            s.close();
            f.close();
            return usuario;
        } catch (HibernateException e) {
            System.out.println("Error al recuperar los registros: " + e.getMessage());
        }
        return null;
    }

    @Override
    public void actualizarRegistro(Usuario usuario) {
        try {
            f = new Configuration().configure().buildSessionFactory();
            s = f.openSession();
            s.beginTransaction();
            s.update(usuario);
            s.getTransaction().commit();
            s.close();
            f.close();
        } catch (HibernateException e) {
            System.out.println("Error al actualizar el registro: " + e.getMessage());
        }
    }

    @Override
    public void eliminarRegistro(Usuario usuario) {
        try {
            f = new Configuration().configure().buildSessionFactory();
            s = f.openSession();
            s.beginTransaction();
            s.delete(usuario);
            s.getTransaction().commit();
            s.close();
            f.close();
        } catch (HibernateException e) {
            System.out.println("Error al elimiar el registro: " + e.getMessage());
        }
     
    }
}
