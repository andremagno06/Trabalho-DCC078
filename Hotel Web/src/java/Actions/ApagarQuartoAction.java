/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;


import Controller.Action;
import DAO.QuartoDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 07228620674
 */
public class ApagarQuartoAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("textNome");
        
        if(id.equals("")){
            response.sendRedirect("index.jsp");
        }
        else{
            
                
            try {
                QuartoDAO.getInstance().excluir(Integer.parseInt(id));
                request.setAttribute("nome", id);
                RequestDispatcher view = request.getRequestDispatcher("QuartoExcluir.jsp");
                response.sendRedirect("MensagemSucesso.jsp");
            } catch (ClassNotFoundException ex) {
                 response.sendRedirect("MensagemErro.jsp");
            } catch (SQLException ex) {
                 response.sendRedirect("MensagemErro.jsp");
            }
                
                
          
        }
    }
    
}
