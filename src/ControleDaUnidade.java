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
			
			if(valorGold < valorPlatinum) {
				
				ControleDaUnidade.metaDeVenda = metaDeVenda;
				ControleDaUnidade.valorClienteGold = valorGold;
				ControleDaUnidade.valorClientePlatinum = valorPlatinum;
				
				fornecedores = new Fornecedor[50];
				funcionarios = new Funcionario[50];
				produtos = new Estoque[50];
				clientes = new Cliente[50];
				
			} else {
				
				ControleDaUnidade.message("valores-fidelidade-errados");
				
			}
			

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
	
	public static float getImpostos() {
	
		return impostos;
		
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
	
	public static String buscarFornecedor(String nome) {
		
		if(nome == null) {
			String aux = "Fornecedores \n -----------------------------------------------------------------";
			
			for(int i = 0; i < fornecedores.length && fornecedores[i] != null; i++) {
				
				aux += fornecedores[i].toString() + "\n" + "-----------------------------------------------------------------" + "\n";
				
			}
			
			return aux;
			
		} else {
			
			for(int i = 0; i < fornecedores.length && fornecedores[i] != null; i++) {
				
				if(fornecedores[i].getNome().equals(nome)) {
					
					return fornecedores[i].toString();
					
				}
				
				
			}
			
		}
		return null;
	}
		
		public static Fornecedor buscarFornecedorPorNome(String nome) {
				for(int i = 0; i < fornecedores.length && fornecedores[i] != null; i++) {
					
					if(fornecedores[i].getNome().equals(nome)) {
						
						return fornecedores[i];
						
					}
					
					
				}
				
			
		ControleDaUnidade.message("fornecedor-nao-encontrado");
		return null;
		
	}
	
	public static String mostrarFornecedores() {
		
		return buscarFornecedor(null);
		
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
	
	public static String buscarFuncionario(String nome) {
		
		if(nome == null) {
			String aux = "Funcionários \n -----------------------------------------------------------------";
			
			for(int i = 0; i < funcionarios.length && funcionarios[i] != null; i++) {
				
				aux += funcionarios[i].toString() + "\n" + "-----------------------------------------------------------------" + "\n";
				
			}
			
			return aux;
			
		} else {
			
			for(int i = 0; i < funcionarios.length && funcionarios[i] != null; i++) {
				
				if(funcionarios[i].getNome().equals(nome)) {
					
					return "Funcionário: \n" + funcionarios[i].toString();
					
				}
				
				
			}
			
		}
		
		ControleDaUnidade.message("funcionario-nao-encontrado");
		return null;
		
	}
	
	public static String mostrarFuncionarios() {
		
		return buscarFuncionario(null);
		
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
	
	public static String buscarCliente(String nome) {
		
		if(nome == null) {
			String aux = "Clientes \n -----------------------------------------------------------------";
			
			for(int i = 0; i < clientes.length && clientes[i] != null; i++) {
				
				aux += clientes[i].toString() + "\n" + "-----------------------------------------------------------------" + "\n";
				
			}
			
			return aux;
			
		} else {
			
			for(int i = 0; i < clientes.length && clientes[i] != null; i++) {
				
				if(clientes[i].getNome().equals(nome)) {
					
					return "Cliente: \n" + clientes[i].toString();
					
				}
				
				
			}
			
		}
		
		ControleDaUnidade.message("cliente-nao-encontrado");
		return null;
		
	}
	
	public static String mostrarClientes() {
		
		return buscarCliente(null);
		
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
	
	public static String buscarProduto(int codigo) {
		
		if(codigo == 0) {
			String aux = "Produtos \n -----------------------------------------------------------------";
			
			for(int i = 0; i < produtos.length && produtos[i] != null; i++) {
				
				aux += produtos[i].toString() + "\n" + "-----------------------------------------------------------------" + "\n";
				
			}
			
			return aux;
			
		} else {
			
			for(int i = 0; i < produtos.length && produtos[i] != null; i++) {
				
				if(produtos[i].getCodigo() == codigo) {
					
					return "Produto: \n" + produtos[i].toString();
					
				}
				
				
			}
			
		}
		
		ControleDaUnidade.message("produto-nao-encontrado");
		return null;
		
	}
	
	public static String mostrarProdutos() {
		
		return buscarProduto(0);
		
	}
	
	public static Produto buscaProdutoPorCodigo() {
		
		int codigo = ControleDaUnidade.pedirCodigo();
		
		if(codigo != 0) {
			
			for(int i = 0; i < produtos.length && produtos[i] != null; i++) {
				
				if(produtos[i].produtoPorCodigo(codigo)) {
					
					return produtos[i].getProdutoEmEstoque();
					
				}	
			}
			
			ControleDaUnidade.message("produto-nao-registrado");

		}
		
		
		return null;
		
	}
	
	public static int pedirCodigo() {

		System.out.println("Passe o código do produto");
		int codigo = scanner.nextInt();	

		if(String.valueOf(codigo).length() == 6) {
			
			return codigo;	
		}
			
		ControleDaUnidade.message("codigo-invalido");
		
		return 0;
			
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
		
			case "erro-de-insercao" : System.out.println("Valor inserido inválido! Por favor digite novamente com valores válidos."); break;
			
			case "cliente-gold" : System.out.println("O comprador se tornou um cliente gold!"); break;
		
			case "cliente-platinum" : System.out.println("O comprador se tornou um cliente platinum!"); break;
			
			case "erro-de-compra" : System.out.println("A compra não pode ser concluída!"); break;
			
			case "produto-nao-registrado" : System.out.println("O produto não está registrado ou disponível no estoque."); break;
			
			case "compra-inexistente" : System.out.println("A compra não existe!"); break;
			
			case "valores-fidelidade-errados" : System.out.println("O valor para se tornar Cliente Gold deve ser menor que o de Cliente Platinum."); break;
			
			case "data-invalida" : System.out.println("A data inserida não é válida!"); break;
			
			case "codigo-invalido" : System.out.println("O código do produto não é válido!"); break;
			
			case "reabastecimento-invalido" : System.out.println("A quantidade a ser reabastecida não é comportada pelo estoque!"); break;
			
			case "fornecedor-nao-encontrado" : System.out.println("O fornecedor não foi encontrado!"); break;
			
			case "funcionario-nao-encontrado" : System.out.println("O funcionário não foi encontrado!"); break;
			
			case "cliente-nao-encontrado" : System.out.println("O cliente não foi encontrado!"); break;
			
			case "produto-nao-encontrado" : System.out.println("O produto não foi encontrado!"); break;
			
			default : System.out.println(mensagem);
		}
		
	}
	
	public void imprimeFuncionario () {
		Scanner novo = new Scanner (System.in);
		String cpf;
		
		System.out.println("Digite o CPF do funcionário que deseja verificar, ou digite 0 para ver a lista completa de todos funcionários.");
		cpf = novo.nextLine();
		
		if (cpf.equals(0)) {
			for (int i = 0; i < funcionarios.length; i++) {
				funcionarios[i].toString();
			}
		}
		else {
	}
	
	}
}
