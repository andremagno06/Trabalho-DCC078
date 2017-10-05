/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DAO.QuartoDAO;

/**
 *
 * @author Desenvolvedor
 */
public class Quarto {
   
    
    private  int id;
    private String descricao;	
    private String estado;
    private int tipo_quarto_id;

   

    public Quarto(String descricao, String estado, int tipo_quarto_id) {
        this.descricao = descricao;
        this.estado = estado;
        this.tipo_quarto_id = tipo_quarto_id;
    }

    public Quarto() {
    }

    public Quarto(int id, String descricao, String estado, int tipo_quarto_id) {
        this.id = id;
        this.descricao = descricao;
        this.estado = estado;
        this.tipo_quarto_id = tipo_quarto_id;
    }

    

   


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getTipo_quarto_id() {
        return tipo_quarto_id;
    }

    public void setTipo_quarto_id(int tipo_quarto_id) {
        this.tipo_quarto_id = tipo_quarto_id;
    }
    
    
    
}
