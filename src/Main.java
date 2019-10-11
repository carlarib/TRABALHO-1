import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner novo = new Scanner(System.in);
		
		String respostaLaco = "sim";
		
		do {

		System.out.println("MENU");
		System.out.println("Insira o número correspondente a operação desejada.");
		System.out.println("1. Relatório de Funcionário(s)");
		System.out.println("2. Relatório de Cliente(s)");
		System.out.println("3. Relatório de Produto(s)");
		System.out.println("4. Relatório de Fornecedor(es)");
		System.out.println("5. Cadastrar Funcionário");
		System.out.println("6. Cadastrar Cliente");
		System.out.println("7. Cadastrar Produto");
		System.out.println("8. Cadastrar Fornecedor");

		int aux = novo.nextInt();
		novo.nextLine();

		switch (aux) {
		case 1:
			System.out.println(ControleDaUnidade.mostrarFuncionarios());
			break;

		case 2:
			System.out.println(ControleDaUnidade.mostrarClientes());
			break;

		case 3:
			System.out.println(ControleDaUnidade.mostrarProdutos());
			break;
		case 4:
			System.out.println(ControleDaUnidade.mostrarFornecedores());
			break;

		case 5:
			String funcao, nome, cpf, telefone, rua, bairro, cidade, estado;
			float salario;
			int numero;

			System.out.println("Insira o nome do novo funcionário");
			nome = novo.nextLine();
			novo.nextLine();

			System.out.println("Insira o CPF do novo funcionário");
			cpf = novo.nextLine();
			novo.nextLine();

			System.out.println("Insira o telefone do novo funcionário");
			telefone = novo.nextLine();
			novo.nextLine();

			System.out.println("Insira o salário do novo funcionário");
			salario = novo.nextFloat();
			novo.nextLine();

			System.out.println("Insira o endereço do novo funcionário");
			System.out.println("Insira a rua");
			rua = novo.nextLine();
			novo.nextLine();

			System.out.println("Insira o número");
			numero = novo.nextInt();
			novo.nextLine();

			System.out.println("Insira o bairro");
			bairro = novo.nextLine();
			novo.nextLine();

			System.out.println("Insira a cidade");
			cidade = novo.nextLine();
			novo.nextLine();

			System.out.println("Insira o estado");
			estado = novo.nextLine();
			novo.nextLine();
			

			Endereco eF1 = new Endereco(rua, numero, bairro, cidade, estado);

			System.out.println("Insira a função do novo funcionário");
			funcao = novo.next();
			novo.nextLine();

			if (funcao.equalsIgnoreCase("padeiro")) {
				Funcionario f1 = new Padeiro(nome, eF1, cpf, telefone, salario);
				ControleDaUnidade.adicionarFuncionario(f1);
			}

			if (funcao.equalsIgnoreCase("vendedor")) {
				Funcionario f1 = new Vendedor(nome, eF1, cpf, telefone, salario);
				ControleDaUnidade.adicionarFuncionario(f1);
			}

			if (funcao.equalsIgnoreCase("gerente")) {
				Funcionario f1 = new Gerente(nome, eF1, cpf, telefone, salario);
				ControleDaUnidade.adicionarFuncionario(f1);
			}

			break;

		case 6:
			String nomeC, cpfC, telefoneC, ruaC, bairroC, cidadeC, estadoC;
			int numeroC;

			System.out.println("Insira o nome do cliente");
			nomeC = novo.nextLine();
			novo.nextLine();

			System.out.println("Insira o CPF do cliente");
			cpfC = novo.nextLine();
			novo.nextLine();

			System.out.println("Insira o telefone do cliente");
			telefoneC = novo.nextLine();
			novo.nextLine();

			System.out.println("Insira o endereço do cliente");
			System.out.println("Insira a rua");
			ruaC = novo.nextLine();
			novo.nextLine();

			System.out.println("Insira o número");
			numeroC = novo.nextInt();
			novo.nextLine();

			System.out.println("Insira o bairro");
			bairroC = novo.nextLine();
			novo.nextLine();

			System.out.println("Insira a cidade");
			cidadeC = novo.nextLine();
			novo.nextLine();

			System.out.println("Insira o estado");
			estadoC = novo.nextLine();
			novo.nextLine();

			Endereco eC = new Endereco(ruaC, numeroC, bairroC, cidadeC, estadoC);
			Cliente c1 = new Cliente(nomeC, eC, cpfC, telefoneC);

			ControleDaUnidade.adicionarCliente(c1);
			break;

		case 7:
			String nomeP, nomeFornecedor, respostaCadFornecedor, perecivel;
			int codigo;
			float precoCusto, precoFinal;
			Fornecedor fornecedor;

			System.out.println("Insira o nome do produto");
			nomeP = novo.nextLine();
			novo.nextLine();

			System.out.println("Insira o código do produto");
			codigo = novo.nextInt();
			novo.nextLine();

			System.out.println("O produto é perecível?");
			perecivel = novo.next();
			novo.nextLine();

			System.out.println("Insira o preço de custo do produto");
			precoCusto = novo.nextInt();
			novo.nextLine();

			System.out.println("Insira o preço final do produto");
			precoFinal = novo.nextInt();
			novo.nextLine();

			System.out.println("O fornecedor do produto já é cadastrado?");
			respostaCadFornecedor = novo.next();
			novo.nextLine();

			// FORNECEDOR JA CADASTRADO
			if (respostaCadFornecedor.equalsIgnoreCase("sim")) {
				System.out.println("Insira o nome do fornecedor do produto");
				nomeFornecedor = novo.nextLine();
				fornecedor = ControleDaUnidade.buscarFornecedorPorNome(nomeFornecedor);

				// PRODUTO PERECIVEL
				if (perecivel.equalsIgnoreCase("sim")) {
					int dia, mes, ano;
					System.out.println("Insira o dia de vencimento do produto");
					dia = novo.nextInt();
					novo.nextLine();

					System.out.println("Insira o mês de vencimento do produto");
					mes = novo.nextInt();
					novo.nextLine();

					System.out.println("Insira o ano de vencimento do produto");
					ano = novo.nextInt();
					novo.nextLine();

					Data d1 = new Data(dia, mes, ano);

					Produto p1 = new ProdutoPerecivel(nomeP, codigo, fornecedor, precoCusto, precoFinal, d1);
					Estoque estoque = new Estoque(p1);
					ControleDaUnidade.adicionarProduto(estoque);
				}
				// PROD N PERECIVEL
				else {
					Produto p1 = new ProdutoNaoPerecivel(nomeP, codigo, fornecedor, precoCusto, precoFinal);
					Estoque estoque = new Estoque(p1);
					ControleDaUnidade.adicionarProduto(estoque);
				}

			}
			// FORNECEDOR NAO CADASTRADO
			else {
				String nomeNovoF, cnpjNovoF, ruaNovoF, bairroNovoF, cidadeNovoF, estadoNovoF;
				int numeroNovoF;

				System.out.println("Insira o nome do fornecedor do produto");
				nomeNovoF = novo.nextLine();
				novo.nextLine();

				System.out.println("Insira o CPF do fornecedor");
				cnpjNovoF = novo.nextLine();
				novo.nextLine();

				System.out.println("O fornecedor é recorrente?");
				String resposta = novo.next();
				novo.nextLine();

				System.out.println("Insira o endereço do fornecedor");
				System.out.println("Insira a rua");
				ruaNovoF = novo.nextLine();
				novo.nextLine();

				System.out.println("Insira o número");
				numeroNovoF = novo.nextInt();
				novo.nextLine();

				System.out.println("Insira o bairro");
				bairroNovoF = novo.nextLine();
				novo.nextLine();

				System.out.println("Insira a cidade");
				cidadeNovoF = novo.nextLine();
				novo.nextLine();

				System.out.println("Insira o estado");
				estadoNovoF = novo.nextLine();
				novo.nextLine();

				Endereco eF3 = new Endereco(ruaNovoF, numeroNovoF, bairroNovoF, cidadeNovoF, estadoNovoF);

				// EH RECORRENTE
				if (resposta.equalsIgnoreCase("sim")) {
					float desc;
					System.out.println("Insira a taxa de desconto");
					desc = novo.nextFloat();
					Fornecedor foP = new FornecedorRecorrente(nomeNovoF, eF3, cnpjNovoF, desc);
					ControleDaUnidade.adicionarFornecedor(foP);

					if (perecivel.equalsIgnoreCase("sim")) {
						int dia, mes, ano;
						System.out.println("Insira o dia de vencimento do produto");
						dia = novo.nextInt();
						novo.nextLine();

						System.out.println("Insira o mês de vencimento do produto");
						mes = novo.nextInt();
						novo.nextLine();

						System.out.println("Insira o ano de vencimento do produto");
						ano = novo.nextInt();
						novo.nextLine();

						Data d1 = new Data(dia, mes, ano);

						Produto p1 = new ProdutoPerecivel(nomeP, codigo, foP, precoCusto, precoFinal, d1);
						Estoque estoque = new Estoque(p1);
						ControleDaUnidade.adicionarProduto(estoque);
					} else {
						Produto p1 = new ProdutoNaoPerecivel(nomeP, codigo, foP, precoCusto, precoFinal);
						Estoque estoque = new Estoque(p1);
						ControleDaUnidade.adicionarProduto(estoque);
					}
				}
				// NAO É RECORRENTE
				else {
					Fornecedor foP = new FornecedorConvencional(nomeNovoF, eF3, cnpjNovoF);
					ControleDaUnidade.adicionarFornecedor(foP);

					if (perecivel.equalsIgnoreCase("sim")) {
						int dia, mes, ano;
						System.out.println("Insira o dia de vencimento do produto");
						dia = novo.nextInt();
						novo.nextLine();

						System.out.println("Insira o mês de vencimento do produto");
						mes = novo.nextInt();
						novo.nextLine();

						System.out.println("Insira o ano de vencimento do produto");
						ano = novo.nextInt();
						novo.nextLine();

						
						Data d1 = new Data(dia, mes, ano);

						Produto p1 = new ProdutoPerecivel(nomeP, codigo, foP, precoCusto, precoFinal, d1);
						Estoque estoque = new Estoque(p1);
						ControleDaUnidade.adicionarProduto(estoque);
					} else {
						Produto p1 = new ProdutoNaoPerecivel(nomeP, codigo, foP, precoCusto, precoFinal);
						Estoque estoque = new Estoque(p1);
						ControleDaUnidade.adicionarProduto(estoque);
					}

				}
			}

			break;

		case 8:
			String nomeF, cnpjF, ruaF, bairroF, cidadeF, estadoF;
			int numeroF;

			System.out.println("Insira o nome do fornecedor");
			nomeF = novo.nextLine();
			novo.nextLine();

			System.out.println("Insira o CPF do fornecedor");
			cnpjF = novo.nextLine();
			novo.nextLine();

			System.out.println("O fornecedor é recorrente?");
			String resposta = novo.next();
			novo.nextLine();

			System.out.println("Insira o endereço do fornecedor");
			System.out.println("Insira a rua");
			ruaF = novo.nextLine();
			novo.nextLine();

			System.out.println("Insira o número");
			numeroF = novo.nextInt();
			novo.nextLine();

			System.out.println("Insira o bairro");
			bairroF = novo.nextLine();
			novo.nextLine();

			System.out.println("Insira a cidade");
			cidadeF = novo.nextLine();
			novo.nextLine();

			System.out.println("Insira o estado");
			estadoF = novo.nextLine();
			novo.nextLine();

			Endereco eF2 = new Endereco(ruaF, numeroF, bairroF, cidadeF, estadoF);

			if (resposta.equalsIgnoreCase("sim")) {
				float desc;
				System.out.println("Insira a taxa de desconto");
				desc = novo.nextFloat();
				novo.nextLine();
				Fornecedor fo1 = new FornecedorRecorrente(nomeF, eF2, cnpjF, desc);
				ControleDaUnidade.adicionarFornecedor(fo1);
			} else {
				Fornecedor fo1 = new FornecedorConvencional(nomeF, eF2, cnpjF);
				ControleDaUnidade.adicionarFornecedor(fo1);
			}
		
		break;
		default :
			System.out.println("Opção inválida. Tente novamente.");
			
		
	}
		}while (respostaLaco.equalsIgnoreCase("sim"));
	
		
		System.out.println("Deseja fazer mais alguma operação?");
		respostaLaco = novo.next();
		novo.nextLine();


}}
