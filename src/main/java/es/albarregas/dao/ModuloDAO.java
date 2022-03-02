package es.albarregas.dao;

import es.albarregas.beans.Modulo;
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

public class ModuloDAO extends GenericoDAO implements IModulosDAO {

    @Override
    public void EliminarModulo(int idModulo) {
        String sql = "DELETE FROM profesormodulo WHERE idModulo= "+ idModulo;
        
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
        
        String sql2 = "DELETE FROM modulosanan WHERE idModulo= "+ idModulo;
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



