package es.albarregas.controllers;

import es.albarregas.beans.Modulo;
import es.albarregas.beans.Profesor;
import es.albarregas.daofactory.DAOFactory;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import es.albarregas.dao.IGenericoDAO;
import es.albarregas.dao.IModulosDAO;
import es.albarregas.dao.IProfesorDAO;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Jesus
 */
@WebServlet(name = "Controlador", urlPatterns = {"/control"})
public class Controlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, IllegalAccessException, InvocationTargetException {
        DAOFactory daof = DAOFactory.getDAOFactory();
        IGenericoDAO pdao = daof.getGenericoDAO();
        IModulosDAO pmod = daof.getModuloDAO();
        IProfesorDAO ppro = daof.getProfesorDAO();
        Profesor profesor = new Profesor();
        Modulo modulo = new Modulo();
        String url = null;
        switch (request.getParameter("op")) {
            case "add":
                
                try {
                BeanUtils.populate(profesor, request.getParameterMap());
                String[] coleccion = request.getParameterValues("titulo");
                String[] ModulosExistentes = request.getParameterValues("modulosExistentes");
                Set<Modulo> modulos = new HashSet<Modulo>();
                //Modulos Nuevos
                if (coleccion != null) {
                    for (String aux : coleccion) {
                        if (!aux.equals("")) {
                            Modulo moduloaux = new Modulo();
                            moduloaux.setTitulo(aux);
                            modulos.add(moduloaux);
                        }
                    }
                }
                //Modulos Existentes
                for (String aux : ModulosExistentes) {
                    if (!aux.equals("-1")) {
                        Modulo moduloaux = new Modulo();
                        Modulo modaux = new Modulo();
                        moduloaux = (Modulo) pdao.selectById(Integer.parseInt(aux), moduloaux.getClass());
                        modaux.setId(Integer.parseInt(aux));
                        modaux.setTitulo(moduloaux.getTitulo());
                        modulos.add(modaux);
                    }
                }

                BeanUtils.copyProperty(profesor, "modulos", modulos);

                System.out.println(profesor.getModulos().size());

            } catch (IllegalAccessException | InvocationTargetException ex) {
                ex.printStackTrace();
            }
            pdao.insertUpdate(profesor);
            url = "index.jsp";
            break;

            case "delete":
                //Sacamos el codigo que es la pk
                String Cod = request.getParameter("registro");
                ppro.EliminarProfesor(Integer.parseInt(Cod));
                url = "index.jsp";
                break;

            case "deleteModulo":
                System.out.println("deleteMod");
                //Sacamos el codigo que es la pk
                String Codi = request.getParameter("registro");
                pmod.EliminarModulo(Integer.parseInt(Codi));

                url = "index.jsp";
                break;
            case "update":
                Cod = request.getParameter("registro");
                profesor = (Profesor) pdao.selectById(Integer.parseInt(Cod), profesor.getClass());
                List<Object> lista = null;
                lista = pdao.selectAll(modulo.getClass());
                request.setAttribute("listado", lista);
                request.setAttribute("profesor", profesor);
                url = "JSP/formularioActualizar.jsp";

                break;
        }

        request.getRequestDispatcher(url).forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
