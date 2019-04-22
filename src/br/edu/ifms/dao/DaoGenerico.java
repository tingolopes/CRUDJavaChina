package br.edu.ifms.dao;

import javax.persistence.EntityManager;
import br.edu.ifms.connection.ConnectionFactory;
import br.edu.ifms.model.EntidadeBase;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

public class DaoGenerico<T extends EntidadeBase> {

    private final static EntityManager MANAGER = ConnectionFactory.getEntityManager();

    public T findById(Class<T> clazz, Integer id) {
        return MANAGER.find(clazz, id);
    }

    public <T> List<T> findByNome(Class<T> clazz, String nomeBusca, String nomeColuna) {
        String tabela = clazz.getSimpleName();
        String jpql = "from " + tabela + " where " + nomeColuna + " like :nomeBusca";
        Query query = MANAGER.createQuery(jpql, clazz);
        query.setParameter("nomeBusca", nomeBusca + "%");
        return (List<T>) query.getResultList();
    }

    //SQL com inner join em desenvolvimento
    public <T> List<T> findByNome(Class<T> clazz, Class<T> clazz2, String nomeBusca, String nomeColuna, String nomeColuna2) {
        String tabela = clazz.getSimpleName();
        String tabela2 = clazz2.getSimpleName();

        String sql = "Select p.idproduto, p.nome, p.preco, "
                + "p.datacadastro, p.idadmin, p.idcategoria, c.categoria "
                + "From produto p "
                + "inner JOIN categoria c "
                + "On p.idcategoria = c.idcategoria "
                + "where (p.nome like ? or c.categoria like ?) " //pesquisa por nome do produto ou categoria
                + "order by nome";

        String jpql = "from " + tabela + " a inner join " + tabela2 + " b on a.id = b.id where " + nomeColuna + " like :nomeBusca";
        Query query = MANAGER.createQuery(jpql, clazz);
        query.setParameter("nomeBusca", nomeBusca + "%");
        return (List<T>) query.getResultList();
    }

    public List<T> listaTodos(Class<T> clazz) {
        CriteriaQuery<T> query = MANAGER.getCriteriaBuilder().createQuery(clazz);
        query.select(query.from(clazz));
        List<T> lista = MANAGER.createQuery(query).getResultList();
        return lista;
    }

    public void saveOrUpdate(T obj) {
        try {
            MANAGER.getTransaction().begin();
            if (obj.getId() == null) {
                MANAGER.persist(obj);
//                System.out.println("Inclusão de "+obj.getClass().getSimpleName()+" com ID "+obj.getId());
            } else {
                MANAGER.merge(obj);
//                System.out.println("Alteração de "+obj.getClass().getSimpleName()+" com ID "+obj.getId());
            }
            MANAGER.getTransaction().commit();
        } catch (Exception e) {
            MANAGER.getTransaction().rollback();
//            System.out.println("Rollback de "+obj.getClass().getSimpleName()+" com ID "+obj.getId());
        }
    }

    public void remove(Class<T> clazz, Integer id) {
        T t = findById(clazz, id);
        try {
            MANAGER.getTransaction().begin();
            MANAGER.remove(t);
            MANAGER.getTransaction().commit();
        } catch (Exception e) {
            MANAGER.getTransaction().rollback();
        }
    }

}
