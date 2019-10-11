/* 
Alunos: Carla Sawana, Bruno Monteiro, Yasmin Lied
*/


import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ControleDaUnidade controle = new ControleDaUnidade(30564.34f, 2500.0f, 9904.23f);
		ControleDaUnidade.adicionaImpostos(3521.30f);

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
		System.out.println("9. Realizar venda");
		System.out.println("10. Checar imposto");

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

			System.out.println("Insira o CPF do novo funcionário (com '.' e '-')");
			cpf = novo.nextLine();
			novo.nextLine();

			System.out.println("Insira o telefone do novo funcionário (com '-')");
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

			System.out.println("Insira o CPF do cliente (com '.' e '-')");
			cpfC = novo.nextLine();
			novo.nextLine();

			System.out.println("Insira o telefone do cliente (com '-')");
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

				System.out.println("Insira o CPF do fornecedor (com '.' e '-')");
				cnpjNovoF = novo.nextLine();
				novo.nextLine();

				System.out.println("O fornecedor é recorrente?");
				String resposta = novo.next();
				novo.nextLine();

				System.out.println("Insira o endereço do fornecedor (com '-')");
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

			System.out.println("Insira o CPF do fornecedor (com '.' e '-')");
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

		case 9:
		System.out.println("Insira o dia da venda");
		int dia = novo.nextInt();

		System.out.println("Insira o mês da venda");
		int mes = novo.nextInt();

		System.out.println("Insira o ano da venda");
		int ano = novo.nextInt();
		novo.nextLine();

		Data dataVenda = new Data(dia, mes, ano);

		System.out.println("Informe o nome do vendedor");
		String nomeVend = novo.nextLine();

		System.out.println("Informe o endereço do vendedor");
		System.out.println("Insira a rua");
		String ruaVend = novo.nextLine();
		novo.nextLine();

		System.out.println("Insira o número");
		int numeroVend = novo.nextInt();
		novo.nextLine();

		System.out.println("Insira o bairro");
		String bairroVend = novo.nextLine();
		novo.nextLine();

		System.out.println("Insira a cidade");
		String cidadeVend = novo.nextLine();
		novo.nextLine();

		System.out.println("Insira o estado");
		String estadoVend = novo.nextLine();
		novo.nextLine();

		Endereco enderecoVend = new Endereco(ruaVend, numeroVend, bairroVend, cidadeVend, estadoVend);

		System.out.println("Informe o cpf do vendedor");
		String cpfVend = novo.nextLine();

		System.out.println("Informe o telefone do vendedor");
		String telefoneVend = novo.nextLine();

		System.out.println("Informe o salário base do vendedor");
		float salarioBaseVend = novo.nextFloat();
		novo.nextLine();

		Vendedor vend = new Vendedor(nomeVend, enderecoVend, cpfVend, telefoneVend, salarioBaseVend);



		System.out.println("Informe o nome do cliente");
		String nomeCliente = novo.nextLine();

		System.out.println("Informe o endereço do cliente");
		System.out.println("Insira a rua");
		String ruaCliente = novo.nextLine();
		novo.nextLine();

		System.out.println("Insira o número");
		int numeroCliente = novo.nextInt();
		novo.nextLine();

		System.out.println("Insira o bairro");
		String bairroCliente = novo.nextLine();
		novo.nextLine();

		System.out.println("Insira a cidade");
		String cidadeCliente = novo.nextLine();
		novo.nextLine();

		System.out.println("Insira o estado");
		String estadoCliente = novo.nextLine();
		novo.nextLine();

		Endereco enderecoCliente = new Endereco(ruaCliente, numeroCliente, bairroCliente, cidadeCliente, estadoCliente);

		System.out.println("Informe o cpf do cliente");
		String cpfCliente = novo.nextLine();

		System.out.println("Informe o telefone do cliente");
		String telefoneCliente = novo.nextLine();

		Cliente cl = new Cliente(nomeCliente, enderecoCliente, cpfCliente, telefoneCliente);

		System.out.println("Informe o tipo de pagamento");
		String tipoPag = novo.nextLine();

		System.out.println("Informe a forma de pagamento");
		String formaPag = novo.nextLine();

		Pagamento pag = new Pagamento(tipoPag, formaPag);

		Venda venda = new Venda(dataVenda, vend, pag, cl);

		break;

		case 10:
			System.out.printf("Valor do imposto: %.3f\n", ControleDaUnidade.getImpostos());
		break;
		default :
			System.out.println("Opção inválida. Tente novamente.");
			
		
	}
		}while (respostaLaco.equalsIgnoreCase("sim"));
	
		
		System.out.println("Deseja fazer mais alguma operação?");
		respostaLaco = novo.next();
		novo.nextLine();


}}
