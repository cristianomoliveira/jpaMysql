/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.domain.Cliente;

/**
 *
 * @author cristiano
 */
public class ClienteDao {
    
    
    public void salvarAtualizar (Cliente cliente){
        
        EntityManager em = Conexao.getEntityManager();
        try{
        em.getTransaction().begin();
        
        if (cliente.getCodigo() != null) {
            
            //se existe é atualizado 
            cliente = em.merge(cliente);
             
        }
        
        //se é novo deve ser persistido
        em.persist(cliente);
        
        em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
        }finally {
            em.close();
        }
        
        
        //em.close();
        
    }
    
    
    
    public void exluir (Cliente cliente){
        
        EntityManager em = Conexao.getEntityManager();
        em.getTransaction().begin();
        
        cliente = em.merge(cliente);
        
        
        //se é novo deve ser persistido
        em.remove(cliente);
        em.getTransaction().commit();
        em.close();
        
    }
    
    
    public List<Cliente> pesquisar (Cliente cliente) {
        
        EntityManager em = Conexao.getEntityManager();
        String sql = "from Cliente c where 1 = 1 ";
        
        if (cliente.getCodigo() != null){
            
            sql+=" and c.codigo = :codigo ";
        }
        if (cliente.getNome() != null && cliente.getNome().equals("")){
            
            sql+=" and c.nome like :nome";
        }
        
        Query query = em.createQuery(sql.toString());
        if (cliente.getCodigo() != null){
            query.setParameter("codigo", cliente.getCodigo());
            
        }
        
        if (cliente.getNome() != null && cliente.getNome().equals("")){
            
            query.setParameter("nome", "%"+cliente.getNome()+"%");
        }
        
        return query.getResultList();
        
    }
    
}
