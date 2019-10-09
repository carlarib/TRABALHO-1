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
		
		if(metaDeVenda > 0.0f && valorGold > 0.0f && valorPlatinum > 0.0f) {

			ControleDaUnidade.metaDeVenda = metaDeVenda;
			ControleDaUnidade.valorClienteGold = valorGold;
			ControleDaUnidade.valorClientePlatinum = valorPlatinum;
			
			fornecedores = new Fornecedor[50];
			funcionarios = new Funcionario[50];
			produtos = new Estoque[50];
			clientes = new Cliente[50];

		}
		else {
			ControleDaUnidade.message("erro-de-insercao");
		}
		
	}
	
	public static void adicionaImpostos(float valor) {
		
		if(valor > 0.0f) {
			impostos += valor;
		}
		else {
			ControleDaUnidade.message("erro-de-insercao");
		}
		
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
		
		if(fornecedor != null) {
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
		else {
			ControleDaUnidade.message("erro-de-insercao");
		}
		
	}
	
	public static void adicionarFuncionario(Funcionario funcionario){
		
		if(funcionario != null) {	
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
		else {
			ControleDaUnidade.message("erro-de-insercao");
		}
			
	}
	
	public static void adicionarCliente(Cliente cliente){
		
		if(cliente != null) {
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
		else {
			ControleDaUnidade.message("erro-de-insercao");
		}
		
	}
	
	public static void adicionarProduto(Estoque produto){
		
		if(produto != null) {
			produtos[produtosIndex] = produto;
			produtosIndex++;
		}
		else {
			ControleDaUnidade.message("erro-de-insercao");
		}

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
		
		int codigo = 0;

		do {
			System.out.println("Passe o código do produto");
			codigo = scanner.nextInt();	
		} while(String.valueOf(codigo).length() != 6);
		
		return codigo;
		
	}
	
	public static boolean solicitarProdutoAoFornecedorAtual() {
		
		char resposta;

		do {
			System.out.println("O fornecedor atual aceitou sua solicitação? (s/n) ");
			resposta = scanner.next().charAt(0);
		} while(resposta != 's' || resposta != 'n');
		
		return (resposta == 's');
		
	}
	
	public static Fornecedor solicitarProduto() {

		char resposta;
		
		for(int i = 0; i < fornecedores.length && fornecedores[i] != null; i++) {
			
			do {
				System.out.println("O fornecedor " + fornecedores[i].getNome() + " aceitou sua solicitação? (s/n) ");
				resposta = scanner.next().charAt(0);
				scanner.nextLine();
			} while(resposta != 's' || resposta != 'n');
			
			if(resposta == 's'){
				
				return fornecedores[i].fornecerProduto();
				
			}
			
		}
		
		return null;
		
	}
	
	public static void message(String mensagem) {
		
		switch(mensagem) {
		
			case "erro-de-insercao" : System.out.println("Valor inserido inválido! Por favor digite novamente com valores válidos."); break;
			
			case "cliente-gold" : System.out.println("O comprador se tornou um cliente gold!"); break;
		
			case "cliente-platinum" : System.out.println("O comprador se tornou um cliente platinum!"); break;
			
			case "erro-de-compra" : System.out.println("A compra não pode ser concluída!"); break;
			
			case "produto-nao-registrado" : System.out.println("O produto não está registrado ou disponível no estoque."); break;
			
			default : System.out.println(mensagem);
		}
		
	}
	
	
}
