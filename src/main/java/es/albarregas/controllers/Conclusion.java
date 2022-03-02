package es.albarregas.controllers;


import es.albarregas.beans.Modulo;
import es.albarregas.beans.Profesor;
import es.albarregas.daofactory.DAOFactory;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.CalendarConverter;
import org.apache.commons.beanutils.converters.DateConverter;
import es.albarregas.dao.IGenericoDAO;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Jesus
 */
@WebServlet(name = "Conclusion", urlPatterns = {"/conclusion"})
public class Conclusion extends HttpServlet {

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
            throws ServletException, IOException {
        DAOFactory daof = DAOFactory.getDAOFactory();
        IGenericoDAO pdao = daof.getGenericoDAO();

     
        Profesor profesor = new Profesor();
        String url = null;
        switch (request.getParameter("op")) {

            
            
            
            
            
            case "update":
                try {

                BeanUtils.populate(profesor, request.getParameterMap());
                String[] coleccion = request.getParameterValues("titulo");
                String[] ModulosExistentes = request.getParameterValues("modulosExistentes");
                String[] idModulo = request.getParameterValues("idModulo");
                String[] nombreModulo = request.getParameterValues("nombreModulo");
                Set<Modulo> modulos = new HashSet<Modulo>();
                
                int contador = 0;
                //Modulos que ya son del profesor
                if (idModulo != null) {
                    for (String aux : nombreModulo) {
                        
                            Modulo moduloaux = new Modulo();
                            moduloaux.setId(Integer.parseInt(idModulo[contador]));
                            moduloaux.setTitulo(aux);
                            contador++;
                        modulos.add(moduloaux);
                    }
                }
                //Modulos que no existen
                if (coleccion != null) {
                    for (String aux : coleccion) {
                        if (!aux.equals("")) {
                            Modulo moduloaux = new Modulo();
                            moduloaux.setTitulo(aux);
                            modulos.add(moduloaux);
                        }
                    }
                }
                //Modulos ya existentes
                for (String aux : ModulosExistentes) {
                    if (!aux.equals("-1")) {
                        Modulo moduloaux = new Modulo();
                        Modulo modinsert = new Modulo();
                        moduloaux = (Modulo) pdao.selectById(Integer.parseInt(aux), moduloaux.getClass());
                        modinsert.setId(Integer.parseInt(aux));
                        modinsert.setTitulo(moduloaux.getTitulo());
                        modulos.add(modinsert);
                    }
                }

               

                BeanUtils.copyProperty(profesor, "modulos", modulos);

            } catch (IllegalAccessException | InvocationTargetException ex) {
                ex.printStackTrace();
            }
            pdao.insertUpdate(profesor);

            url = "index.jsp";
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
        processRequest(request, response);
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
        processRequest(request, response);
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
