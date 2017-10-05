/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Quarto;
import Persistencia.DatabaseLocator;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author 07228620674
 */
public class QuartoDAO {
   
    private static QuartoDAO instance;
    
    private QuartoDAO(){
        
    }
    
    public static QuartoDAO getInstance(){
        if(instance == null)
            instance = new QuartoDAO();
        return instance;
    }
    
    public void gravar(Quarto quarto) throws ClassNotFoundException, SQLException{
        Connection conn = null;
        PreparedStatement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.prepareStatement("insert into quarto (descricao, estado, tipo_quarto_id) values (?, ?, ?)");
            
           st.setString(1, quarto.getDescricao());
           st.setString(2, quarto.getEstado());
           st.setInt(3, quarto.getTipo_quarto_id());
           st.executeUpdate();
           
        } catch(SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }
    
   
    
    public void excluir(int id) throws ClassNotFoundException, SQLException{
        Connection conn = null;
        PreparedStatement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.prepareStatement("DELETE FROM quarto WHERE id = ?");
            st.setInt(1, id);
            st.execute();
        } catch(SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
    }
    
    public Quarto ler(int id) throws ClassNotFoundException, SQLException{
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.prepareStatement("SELECT * FROM quarto WHERE id = ?");
            st.setInt(1, id);
            rs = st.executeQuery();
            
            if(rs.next()){
                return new Quarto(
                            rs.getString("descricao"), 
                            rs.getString("estado"), 
                            rs.getInt("tipo_quarto_id")
                       );
            }
        } catch(SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
        }
        return null;
    }
    
    public List<Quarto> lerTodos() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs;
        List<Quarto> quartos = new VirtualFlow.ArrayLinkedList<>();
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.prepareStatement("SELECT * FROM quarto");
            rs = st.executeQuery();

            while (rs.next()) {
                Quarto quarto = new Quarto();
                quarto.setId(rs.getInt("id"));
                quarto.setDescricao(rs.getString("descricao"));
                quarto.setEstado(rs.getString("estado"));
                quarto.setTipo_quarto_id(rs.getInt("tipo_quarto_id"));
                quartos.add(quarto);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResources(conn, st);
            
        }
        return quartos;
    }

    private void closeResources(Connection conn, Statement st) {
        try {
            if(st!=null) st.close();
            if(conn!=null) conn.close();

        } catch(SQLException e) {

        }
    }
}
