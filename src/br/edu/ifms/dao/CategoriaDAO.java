/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.dao;

import br.edu.ifms.connection.ConnectionFactory;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author tingo
 */
public class CategoriaDAO {

    private final static EntityManager MANAGER = ConnectionFactory.getEntityManager();

    //SQL com inner join em desenvolvimento
    public List listarCategorias() {

//pesquisa por nome do produto ou categoria
//        String sql = "Select p.idproduto, p.nome, p.preco, "
//                + "p.datacadastro, p.idadmin, p.idcategoria, c.categoria "
//                + "From produto p "
//                + "inner JOIN categoria c "
//                + "On p.idcategoria = c.idcategoria "
//                + "where (p.nome like ? or c.categoria like ?) " 
//                + "order by nome";

//pesquisa fazendo junção de resultado
        String sql2 = "Select c.id, c.nome, Count(p.id) qtdprodutos, sum(p.preco) somaprodutos "
                + "From produto p right JOIN categoria c On c.id = p.id_categoria "
                + "Group By p.id_categoria, c.nome order by nome";
        return MANAGER.createQuery(sql2).getResultList();
    }
}
