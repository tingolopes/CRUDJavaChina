/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.connection.teste;

import br.edu.ifms.dao.DaoGenerico;
import br.edu.ifms.model.Usuario;

/**
 *
 * @author tingo
 */
public class InsertTeste {
    public static void main(String[] args) {
        
        Usuario u = new Usuario();
        u.setLogin("admin");
        u.setNome("admin");
        u.setSenha("ISMvKXpXpadDiUoOSoAfww==");
        new DaoGenerico<>().saveOrUpdate(u);
        
        System.out.println("teste");
    }
}
