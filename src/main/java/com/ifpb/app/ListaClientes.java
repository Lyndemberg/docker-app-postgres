
package com.ifpb.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ListaClientes", urlPatterns = {"/clientes"})
public class ListaClientes extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ClienteDao cd = new ClienteDao();
        try {
            ArrayList<Cliente> clientes = cd.getClientes();
            PrintWriter out = response.getWriter();
            out.println("<h1>CLIENTES CADASTRADOS</h1>");
            out.println("<ul>");
            for(Cliente c:clientes){
                out.println("<li>"+c.getNome()+"</li>");
            }
            out.println("</ul>");
        } catch (SQLException ex) {
            Logger.getLogger(ListaClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
