package es.albarregas.daofactory;


import es.albarregas.dao.IGenericoDAO;
import es.albarregas.dao.IModulosDAO;
import es.albarregas.dao.IProfesorDAO;

public abstract class DAOFactory {

    

    public abstract IGenericoDAO getGenericoDAO();
    public abstract IModulosDAO getModuloDAO();
    public abstract IProfesorDAO getProfesorDAO();
    public static DAOFactory getDAOFactory() {
        DAOFactory daof = null;

        daof = new MySQLDAOFactory();

        return daof;
    }

}
