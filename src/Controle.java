
public class Controle {

	private Fornecedor[] fornecedores;
	private static float impostos = 0;
	private static float metaDeVenda;
	
	
	public static void adicionaImpostos(float valor) {
		
		impostos += valor;
		
	}
	
	public static float getMetaDeVenda() {
		
		return metaDeVenda;
		
	}
	
	public void adicionarFornecedor(Fornecedor fornecedor){
		
		
		
	}
	
}
