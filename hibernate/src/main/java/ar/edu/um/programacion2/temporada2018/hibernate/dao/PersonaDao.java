package ar.edu.um.programacion2.temporada2018.hibernate.dao;

import ar.edu.um.programacion2.temporada2018.hibernate.entidades.Persona;
import ar.edu.um.programacion2.temporada2018.hibernate.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;
import java.util.UUID;


public class PersonaDao {

    protected SessionFactory sf;

    public PersonaDao() {
        this.sf = HibernateUtils.getSessionFactory();
    }

    public void escribir(Persona p) {
        Session ses = this.sf.openSession();
        ses.beginTransaction();
        ses.persist(p);
        ses.getTransaction().commit();
        ses.close();
    }

    public Persona buscarUno(Long id) {
        Session ses = this.sf.openSession();
        //ses.beginTransaction();
        String sql = "select p from Persona p where p.id = :id";
        Query<Persona> query = ses.createQuery(sql);
        query.setParameter("id",id);
        Persona resultado = query.getSingleResult();
        //ses.getTransaction().commit();
        //ses.close();
        return resultado;
    }

    public List<Persona> buscarTodos() {
        Session ses = this.sf.openSession();
        ses.beginTransaction();
        String sql = "select p from Persona p";
        Query<Persona> query = ses.createQuery(sql);
        List<Persona> resultado = query.getResultList();
        ses.getTransaction().commit();
        ses.close();
        return resultado;
    }
}
