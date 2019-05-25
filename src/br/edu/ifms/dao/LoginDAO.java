package br.edu.ifms.dao;

import br.edu.ifms.connection.ConnectionFactory;
import br.edu.ifms.model.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class LoginDAO {

    private final static EntityManager MANAGER = ConnectionFactory.getEntityManager();

    public Usuario findByLoginSenha(Class clazz, String login, String senha) {
        String tabela = clazz.getSimpleName();
        String jpql = "from " + tabela + " WHERE login LIKE :login and senha LIKE :senha";
        Query query = MANAGER.createQuery(jpql, clazz);
        query.setParameter("login", login);
        query.setParameter("senha", senha);
        try {
            return (Usuario) query.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }
}
