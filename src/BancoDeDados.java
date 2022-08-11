import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BancoDeDados {

	private Connection conn = null;
	private Statement st = null;
	private ResultSet rs = null;

	public void conectar() {

		String servidor = "jdbc:mysql://localhost/ibm";
		String usuario = "root";
		String senha = "123456";

		String driver = "com.mysql.cj.jdbc.Driver";

		try {
			Class.forName(driver);
			this.conn = DriverManager.getConnection(servidor, usuario, senha);
			this.st = this.conn.createStatement();

		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public boolean estaConectado() {
		if (this.conn != null) {
			return true;
		} else {
			return false;

		}
	}

	public void listarProdutos() {
		try {
			String query = "SELECT * FROM produtos";
			this.rs = this.st.executeQuery(query);
			this.st = this.conn.createStatement();
			while (this.rs.next()) {
				String id = rs.getString("id_produto");
				String nome = rs.getString("nome_produto");
				Double valor_unitario = rs.getDouble("valor_unitario");
				Integer qtd_produto = rs.getInt("qtd_produto");
				Integer cod_marca = rs.getInt("cod_marca");

				System.out.println("id: " + id);
				System.out.println("nome: " + nome);
				System.out.println("Valor Unit: " + valor_unitario);
				System.out.println("Qtd Produto: " + qtd_produto);
				System.out.println("Cód Marca: " + cod_marca);
				
			}
		} catch (Exception e) {
			System.out.println("Erro " + e.getMessage());
		}

	}

	public void inserirProduto(String nome_produto, Double valor_unitario, int qtd_produto, int cod_marca) {

		try {
			String query = "INSERT INTO produtos values(null,'" + nome_produto + "'," + valor_unitario+","+ qtd_produto +"," + cod_marca+");";
			System.out.println(query);
			st.execute(query);

		} catch (Exception e) {
			System.out.println("Erro " + e.getMessage());
		}

	}

	public void editarNomeProduto(int id, String nome) {
		try {

			String q = "update produto set nome='" + nome + "' where id=" + id + ";";
			System.out.println(q);
			this.st.executeUpdate(q);
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public void deletarProdutos(int id) {
		
		try {
			String q = "delete from produtos where id="+id;
					System.out.println(q);
			this.st.executeUpdate(q);
			}catch(Exception e) {
				System.out.println("Erro: "+e.getMessage());
			}
		}
}


