package conexaoPostgres;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class TesteAgenda {
 
public static void main(String args[]) throws SQLException{
 
	//Cria uma conexão com o banco
	  Connection conn = null;
	  try {
			conn = Conecta.criarConexao();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
 ContatoDAO contatoDAO = new ContatoDAO();
 TelefoneDao telefoneDao = new TelefoneDao();
 
 Telefone telefone = new Telefone();
 
 
 telefone.setContato_id(3);
 telefone.setTelefone(89768788);
 
 telefoneDao.create(conn, telefone);

 List loadTelefones = telefoneDao.loadAll(conn);
 
 System.out.print(loadTelefones);
 
 //Cria um contato e salva no banco
 Contato contato = new Contato();
 contato.setNome("ETELVINO");
 contato.setIdade(503);
 contato.setDataCadastro(new Date());
 
 contatoDAO.save(contato);
 
 //Atualiza o contato com id = 1 com os dados do objeto contato1
 Contato contato1 = new Contato();
 contato1.setId(1);
 contato1.setNome("NOME NOVO");
 contato1.setIdade(32);
 contato1.setDataCadastro(new Date());
 
 contatoDAO.update(contato1);
 
 //Remove o contato com id = 1
 
 contatoDAO.removeById(1);
 
 //Lista todos os contatos do banco de dados
 
 for(Contato c : contatoDAO.getContatos()){
 
 System.out.println("NOME: " + c.getNome() + " "+ c.getId());
 }
 }
}