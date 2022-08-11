
public class ControleDeProdutos {

	public static void main(String[] args) {
		BancoDeDados bd = new BancoDeDados();
		bd.conectar();
		
		if(bd.estaConectado()) {
			System.out.println("Conexão realizada.");
			bd.listarProdutos();
			bd.inserirProduto("Tapetes", 5.22, 0, 1);
			bd.deletarProdutos(1);
			bd.editarNomeProduto(3, "Teste");
			
			
		}else {
			System.out.println("Falha na conexão. ");
		}

	}


}
