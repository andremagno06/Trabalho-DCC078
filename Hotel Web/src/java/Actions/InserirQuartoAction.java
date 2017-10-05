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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Desenvolvedor
 */
public class InserirQuartoAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String descricao = request.getParameter("textDescricao");
        String tipo = request.getParameter("textTipo");
        
        if (descricao.equals("") || tipo.equals("")) {
            response.sendRedirect("index.jsp");
        } else {
            try {
                Quarto quarto = new Quarto(descricao,"disponivel", Integer.parseInt(tipo));
                QuartoDAO.getInstance().gravar(quarto);
                response.sendRedirect("MensagemSucesso.jsp");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(InserirQuartoAction.class.getName()).log(Level.SEVERE, null, ex);
                response.sendRedirect("MensagemErro.jsp");
            } catch (SQLException ex) {
                Logger.getLogger(InserirQuartoAction.class.getName()).log(Level.SEVERE, null, ex);
                response.sendRedirect("MensagemErro.jsp");
            }
            response.sendRedirect("MensagemErro.jsp");
            
        }
    }

}
