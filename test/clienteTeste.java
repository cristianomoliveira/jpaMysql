
//Fontes
//https://drive.google.com/folderview?id=0B_aMgVziTAnPcUI4LW1uekh1UTg&usp=drive_web


import java.util.List;
import model.dao.ClienteDao;
import model.domain.Cliente;



/**
 *
 * @author cristiano
 */
public class clienteTeste {
    
    public static void main(String[] args) {
        System.out.println("Saída Padrão em Java");
        
        Cliente c = new Cliente();
        //c.setCodigo(1);
        c.setNome("testeNovo5");
        
        ClienteDao clienteDao = new ClienteDao();
        clienteDao.salvarAtualizar(c);
        
        Cliente c2 = new Cliente();
        
        System.out.println(c.getCodigo());
        System.out.println(c.getNome());
        
        List<Cliente> clientes = clienteDao.pesquisar(c2);
        
        for(Cliente cL : clientes){
            
            System.out.println(cL.getNome());
            
        }
        
        
        
        

     }

    
    
}
