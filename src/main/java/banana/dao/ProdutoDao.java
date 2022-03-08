package banana.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import banana.model.Produto;


public class ProdutoDao {
	
	public void CadastrarProduto(Produto produto) {
		
		String sql = "INSERT INTO PRODUTO VALUE (NULL,?,?,?,?)";
		PreparedStatement prepared = null;
		Connection conn = null;
		
		try {
			// Class de Conexao, funcao, 
			conn = new MySqlConnection().getConnection();
			prepared = conn.prepareStatement(sql);
			prepared.setString(1, produto.getDescricao());
			prepared.setInt(2, produto.getQuantidade());
			prepared.setDouble(3, produto.getPreco());
			prepared.setBoolean(4, produto.isOnLine());
			prepared.execute();
			
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			//Fechando prepared e conexao
			try {
				
				if(prepared != null) {
					prepared.close();
				}
				
			}catch(Exception e2){
				e2.printStackTrace();
			}
			
			try {
				 
				if(conn != null) {
					conn.close();
				}
				
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		
		}
	
	}
		//mode de fazer busca no banco de dados 
		public ArrayList<Produto> BuscarProdutosporDescricao(String descricao){
			//conexao e busca
			String sql = "SELECT * FROM produtos WHERE LIKE '%" + descricao + "%'";
			ResultSet rs = null;
			Connection conn = null;
			PreparedStatement prepared = null;
			Produto produto = null;
			ArrayList<Produto> produtos = null;
			
			try {
				
				conn = new MySqlConnection().getConnection();
				prepared = conn.prepareStatement(sql);
				rs = prepared.executeQuery();
				if(rs != null) {
					produtos = new ArrayList<Produto>();
					while (rs.next());// busca linha a linha.
					produto = new Produto();
					produto.setIdProduto(rs.getInt("IdProduto"));
					produto.setDescricao(rs.getString("Descricao"));
					produto.setQuantidade(rs.getInt("Quantidade"));
					produto.setPreco(rs.getDouble("Preco"));
					produto.setOnLine(rs.getBoolean("OnLine"));
					produtos.add(produto);
					
				}
				
				
			}catch(Exception e3){
				e3.printStackTrace();
			} finally {
				//Fechando prepared e conexao
				try {
					
					if(prepared != null) {
						prepared.close();
					}
					
				}catch(Exception e2){
					e2.printStackTrace();
				}
				
				try {
					 
					if(conn != null) {
						conn.close();
					}
					
				}catch(Exception e2) {
					e2.printStackTrace();
				}
			
			}
		
			
			return produtos;
		}
		
	public void ExcluirProduto(int idProduto){
		String sql = "DELETE FROM produtos WHERE idProduto = ?";
		Connection conn = null;
		PreparedStatement prepared = null;
		
		try {
			
			conn = new MySqlConnection().getConnection();
			prepared = conn.prepareStatement(sql);
			prepared.setInt(1, idProduto);
			prepared.execute();
			
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			//Fechando prepared e conexao
			try {
				
				if(prepared != null) {
					prepared.close();
				}
				
			}catch(Exception e2){
				e2.printStackTrace();
			}
			
			try {
				 
				if(conn != null) {
					conn.close();
				}
				
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		
		}
	
	}
}
	

