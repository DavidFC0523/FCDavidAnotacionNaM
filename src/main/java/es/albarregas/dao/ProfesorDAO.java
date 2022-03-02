package es.albarregas.dao;

import java.io.Serializable;

import es.albarregas.persistencia.HibernateUtil;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;
import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.resource.transaction.spi.TransactionStatus;

public class ProfesorDAO extends GenericoDAO implements IProfesorDAO {

    @Override
    public void EliminarProfesor(int idProfesor) {
        String sql = "DELETE FROM profesormodulo WHERE idProfesor= "+ idProfesor;
        
        try {

            this.startSession();
          Query query = sesion.createNativeQuery(sql);
          query.executeUpdate();
        } catch (HibernateException he) {          
            if (sesion != null) {
                this.handleException(he);
              
            }
        } finally {

            this.endSession();

        }
        
        String sql2 = "DELETE FROM profesoresanan WHERE idProfesor= "+ idProfesor;
        try {

            this.startSession();
            Query query = sesion.createNativeQuery(sql2);
            query.executeUpdate();
        } catch (HibernateException he) {
            if (sesion != null) {
               
                this.handleException(he);
            }
        } finally {

            this.endSession();

        }
        
        

    }
}
