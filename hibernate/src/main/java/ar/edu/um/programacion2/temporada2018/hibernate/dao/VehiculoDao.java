package ar.edu.um.programacion2.temporada2018.hibernate.dao;

import ar.edu.um.programacion2.temporada2018.hibernate.entidades.Vehiculo;
import ar.edu.um.programacion2.temporada2018.hibernate.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class VehiculoDao {

    protected SessionFactory sf;

    public VehiculoDao() {
        this.sf = HibernateUtils.getSessionFactory();
    }

    public void escribir(Vehiculo v) {
        Session ses = this.sf.getCurrentSession();
        ses.getTransaction().begin();
        ses.persist(v);
        ses.getTransaction().commit();
    }

    public Vehiculo buscarUno(Long id) {
        Session ses = this.sf.getCurrentSession();
        ses.getTransaction().begin();
        String sql = "select v from Vehiculo v where v.id = :id";
        Query<Vehiculo> query = ses.createQuery(sql);
        query.setParameter("id",id);
        Vehiculo resultado = query.getSingleResult();
        ses.getTransaction().commit();
        return resultado;
    }

    public List<Vehiculo> buscarTodos() {
        Session ses = this.sf.getCurrentSession();
        ses.getTransaction().begin();
        String sql = "select v from Vehiculo v";
        Query<Vehiculo> query = ses.createQuery(sql);
        List<Vehiculo> resultado = query.getResultList();
        ses.getTransaction().commit();
        return resultado;
    }

}
