package es.albarregas.daofactory;


import es.albarregas.dao.GenericoDAO;
import es.albarregas.dao.IGenericoDAO;
import es.albarregas.dao.IModulosDAO;
import es.albarregas.dao.IProfesorDAO;
import es.albarregas.dao.ModuloDAO;
import es.albarregas.dao.ProfesorDAO;


public class MySQLDAOFactory extends DAOFactory{

    @Override
    public IGenericoDAO getGenericoDAO() {
        return new GenericoDAO();
    }

    @Override
    public IModulosDAO getModuloDAO() {
         return new ModuloDAO();
    }
    @Override
    public IProfesorDAO getProfesorDAO() {
        return new ProfesorDAO();
    }
}
