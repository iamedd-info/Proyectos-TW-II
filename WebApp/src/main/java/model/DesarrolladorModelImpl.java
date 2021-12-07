package model;



import entity.Desarrollador;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author milan
 */
public class DesarrolladorModelImpl implements IDesarrolladorModel {
    private SessionFactory f;
    private Session s;
    @Override
    public void crearRegistro(Desarrollador desarrollador) {        
        try {
            f = new Configuration().configure().buildSessionFactory();
            s = f.openSession();
            s.beginTransaction();
            s.save(desarrollador);
            s.getTransaction().commit();
            s.close();
            f.close();
        } catch (HibernateException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public List<Desarrollador> obtenerRegistros() {
         try {
            f = new Configuration().configure().buildSessionFactory();
            s = f.openSession();
            List<Desarrollador> lista = s.createCriteria(Desarrollador.class).list();
            s.close();
            f.close();
            return lista;
        } catch (HibernateException e) {
            System.out.println("Error: " + e.getMessage());
        }
         return null;
    }
    
    public static void main(String[] args) {
        Desarrollador d = new Desarrollador();
        d.setIdDesarrollador(0);
        d.setNombre("Eduardo");
        d.setApellido("Hernández");
        d.setCorreo("eduardo@gmail.com");
        d.setPwd("123");
        
        IDesarrolladorModel model = new DesarrolladorModelImpl();
        model.crearRegistro(d);
        
        System.out.println("Lista: " + model.obtenerRegistros().size());
    }

    @Override
    public Desarrollador obtenerRegistro(String idDesarrollador) {
        try {
            f = new Configuration().configure().buildSessionFactory();
            s = f.openSession();
            Desarrollador desarrollador = (Desarrollador) s.get(Desarrollador.class, idDesarrollador);
            s.close();
            f.close();
            return desarrollador;
        } catch (HibernateException e) {
            System.out.println("Error al recuperar los registros: " + e.getMessage());
        }
        return null;
    }

    @Override
    public void actualizarRegistro(Desarrollador desarrollador) {
        try {
            f = new Configuration().configure().buildSessionFactory();
            s = f.openSession();
            s.beginTransaction();
            s.update(desarrollador);
            s.getTransaction().commit();
            s.close();
            f.close();
        } catch (HibernateException e) {
            System.out.println("Error al actualizar el registro: " + e.getMessage());
        }
    }

    @Override
    public void eliminarRegistro(Desarrollador desarrollador) {
        try {
            f = new Configuration().configure().buildSessionFactory();
            s = f.openSession();
            s.beginTransaction();
            s.delete(desarrollador);
            s.getTransaction().commit();
            s.close();
            f.close();
        } catch (HibernateException e) {
            System.out.println("Error al elimiar el registro: " + e.getMessage());
        }
     
    }

}
