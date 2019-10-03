
public class ControleDaUnidade {

	private static Fornecedor[] fornecedores;
	private static int fornecedoresIndex = 0;
	private static Funcionario[] funcionarios;
	private static int funcionariosIndex = 0;
	private static Estoque[] produtos;
	private static int produtosIndex = 0;
	private static Cliente[] clientes;	
	private static int clientesIndex = 0;
	private static float impostos = 0;
	private static float metaDeVenda;
	
	
	public ControleDaUnidade(float metaDeVenda) {
		
		ControleDaUnidade.metaDeVenda = metaDeVenda;
		
		fornecedores = new Fornecedor[50];
		funcionarios = new Funcionario[50];
		produtos = new Estoque[50];
		clientes = new Cliente[50];
		
	}
	
	public static void adicionaImpostos(float valor) {
		
		impostos += valor;
		
	}
	
	public static float getMetaDeVenda() {
		
		return metaDeVenda;
		
	}
	
	public static void adicionarFornecedor(Fornecedor fornecedor){
		
		if(fornecedoresIndex >= fornecedores.length) {
			
			Fornecedor aux[] = new Fornecedor[fornecedores.length + 10];
			
			for(int i = 0; i < fornecedores.length; i++) {
				
				aux[i] = fornecedores[i];
				
			}
			
			fornecedores = aux;
			
		}
		
		fornecedores[fornecedoresIndex] = fornecedor;
		fornecedoresIndex++;
		
	}
	
	public static void adicionarFuncionario(Funcionario funcionario){
			
			if(funcionariosIndex >= funcionarios.length) {
				
				Funcionario aux[] = new Funcionario[funcionarios.length + 10];
				
				for(int i = 0; i < funcionarios.length; i++) {
					
					aux[i] = funcionarios[i];
					
				}
				
				funcionarios = aux;
				
			}
			
			funcionarios[funcionariosIndex] = funcionario;
			funcionariosIndex++;
			
	}
	
	public static void adicionarCliente(Cliente cliente){
		
		if(clientesIndex >= clientes.length) {
			
			Cliente aux[] = new Cliente[clientes.length + 10];
			
			for(int i = 0; i < clientes.length; i++) {
				
				aux[i] = clientes[i];
				
			}
			
			clientes = aux;
			
		}
		
		clientes[clientesIndex] = cliente;
		clientesIndex++;
		
	}
	
	public static void adicionarProduto(Estoque produto){
		
		produtos[produtosIndex] = produto;
		produtosIndex++;
		
	}
	
	
}
