import java.util.Scanner;
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
	private static float valorClienteGold;
	private static float valorClientePlatinum;
	private static Scanner scanner = new Scanner(System.in);
	
	public ControleDaUnidade(float metaDeVenda, float valorGold, float valorPlatinum) {
		
		ControleDaUnidade.metaDeVenda = metaDeVenda;
		ControleDaUnidade.valorClienteGold = valorGold;
		ControleDaUnidade.valorClientePlatinum = valorPlatinum;
		
		
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
	
	public static float getValorClienteGold() {
		
		return valorClienteGold;
		
	}

	public static float getValorClientePlatinum() {
		
		return valorClientePlatinum;
		
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
	
	public static Produto buscaProdutoPorCodigo() {
		
		int codigo = ControleDaUnidade.pedirCodigo();
		
		for(int i = 0; i < produtos.length && produtos[i] != null; i++) {
			
			if(produtos[i].produtoPorCodigo(codigo)) {
				
				return produtos[i].getProdutoEmEstoque();
				
			}	
		}
		
		ControleDaUnidade.message("produto-nao-registrado");
		return null;
		
	}
	
	public static int pedirCodigo() {
		
		System.out.println("Passe o código do produto");
		int codigo = scanner.nextInt();
		return codigo;
		
	}
	
	public static boolean solicitarProdutoAoFornecedorAtual() {
		
		System.out.println("O fornecedor atual aceitou sua solicitação? (s/n) ");
		char resposta = scanner.next().charAt(0);
		
		return (resposta == 's');
		
	}
	
	public static Fornecedor solicitarProduto() {

		char resposta;
		
		for(int i = 0; i < fornecedores.length && fornecedores[i] != null; i++) {
			
			System.out.println("O fornecedor " + fornecedores[i].getNome() + " aceitou sua solicitação? (s/n) ");
			resposta = scanner.next().charAt(0);
			scanner.nextLine();
			
			if(resposta == 's'){
				
				return fornecedores[i].fornecerProduto();
				
			}
			
		}
		
		return null;
		
	}
	
	public static void message(String mensagem) {
		
		switch(mensagem) {
		
			case "erro-de-insercao" : System.out.println("Valor inserido invÃ¡lido! Por favor digite novamente com valores vÃ¡lidos"); break;
			
			case "cliente-gold" : System.out.println("O comprador se tornou um cliente gold!"); break;
		
			case "cliente-platinum" : System.out.println("O comprador se tornou um cliente platinum!"); break;
			
			case "erro-de-compra" : System.out.println("A compra não pode ser concluída!"); break;
			
			case "produto-nao-registrado" : System.out.println("O produto não está registrado ou disponível no estoque"); break;
			
			default : System.out.println(mensagem);
		}
		
	}
	
	
}
