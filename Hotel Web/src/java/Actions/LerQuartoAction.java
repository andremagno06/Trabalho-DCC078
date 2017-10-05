/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;



import Controller.Action;
import DAO.QuartoDAO;
import Model.Quarto;
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
public class LerQuartoAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String codigo = request.getParameter("codigo");
        
        if(codigo.equals("")){
            response.sendRedirect("index.jsp");
        }
        else{
            try{
                int codInt = Integer.parseInt(codigo);
                Quarto c = QuartoDAO.getInstance().ler(codInt);
                
                request.setAttribute("descricao", c.getDescricao());
                request.setAttribute("estado", c.getEstado());
                request.setAttribute("tipo", c.getTipo_quarto_id());
                
                RequestDispatcher view = request.getRequestDispatcher("ContatoLer.jsp");
                view.forward(request, response);
                response.sendRedirect("MensagemSucesso.jsp");
                
            } catch(SQLException e){
                response.sendRedirect("MensagemErro.jsp");
                e.printStackTrace();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(InserirQuartoAction.class.getName()).log(Level.SEVERE, null, ex);
                response.sendRedirect("MensagemErro.jsp");
            } catch (ServletException ex) {
                Logger.getLogger(LerQuartoAction.class.getName()).log(Level.SEVERE, null, ex);
                response.sendRedirect("MensagemErro.jsp");
            }
        }
    }
    
}
