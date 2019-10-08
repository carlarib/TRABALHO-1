
public class Venda implements Imposto{

	private Produto[] produtos;
	private Data dataDeVenda;
	private Vendedor vendedor;
	private Pagamento pagamento;
	private Cliente comprador;
	private Fornecedor fornecedor_comprador;
	

	public Venda(Data dataDeVenda, Vendedor vendedor, Pagamento pagamento, Cliente comprador) {
		
		this.produtos = this.passarCompras();
		this.dataDeVenda = dataDeVenda;
		this.vendedor = vendedor;
		this.pagamento = pagamento;
		this.comprador = comprador;
		
		this.cobrarCliente();
		
	}
	
	public Venda(Data dataDeVenda, Vendedor vendedor, Pagamento pagamento, Fornecedor comprador) {
		
		this.produtos = this.passarCompras();
		this.dataDeVenda = dataDeVenda;
		this.vendedor = vendedor;
		this.pagamento = pagamento;
		this.fornecedor_comprador = comprador;
		
		this.cobrarFornecedor();
		
	}
	
	public Produto[] passarCompras() {
		
		Produto[] produtosAux = new Produto[20];
		Produto[] produtosFinal;
		int i;
		boolean continuar = true;
		for(i = 0; i < 20 && continuar; i++) {
			
			if(ControleDaUnidade.buscaProdutoPorCodigo() != null) {
				
				produtosAux[i] = ControleDaUnidade.buscaProdutoPorCodigo();
				
			} else {
				
				continuar = false;
				
			}	
		}
		
		produtosFinal = new Produto[i];
		
		for(int k = 0; k < produtosFinal.length; k++) {
			
			produtosFinal[k] = produtosAux[k];
			
		}
		
		return produtosFinal;
	}

	public float precoTotal() {
		
		float preco = 0;
		
		for(int i = 0; i < this.produtos.length; i++) {
			
			preco += this.produtos[i].getPrecoFinal();
			
		}

		return preco;
		
	}
	
	
	public float precoParaFornecedorRecorrente(FornecedorRecorrente fornecedor) {
		
		float preco = 0;
		
		for(int i = 0; i < this.produtos.length; i++) {
			
			if(this.produtos[i].getFornecedor() == fornecedor) {

				
				preco += this.produtos[i].getPrecoFinal() - this.produtos[i].getPrecoFinal()*fornecedor.getTaxaDeDesconto();
				
			} else {
				
				preco += this.produtos[i].getPrecoFinal();
			
			}
		}
		
		return preco;
		
	}
	
	
	@Override
	public void aplicarImposto(float valor) {
		
		ControleDaUnidade.adicionaImpostos(0.15f*valor);
		
	}

	
	public void cobrarCliente() {
		
		float valorGasto = this.precoTotal();
		boolean error = false;
		
		switch(this.comprador.getTipoCliente()) {
		
		case COMUM: break;
		
		case GOLD: valorGasto -= valorGasto*0.05f;
			break;
		
		case PLATINUM: valorGasto -= valorGasto*0.1f;
			break;
			
		default : error = true;
			break;
		
		}
		
		switch(this.pagamento.getTipoDePagamento()) {
		
		case APRAZO: valorGasto += valorGasto*0.02f;
			break;
			
		case AVISTA: break;
		
		default: error = true;
			break;
		
		}
		
		if(!error && valorGasto != 0) {
			
			this.aplicarImposto(valorGasto);
			this.comprador.comprar(valorGasto);
			
		} else {
			
			ControleDaUnidade.message("erro-de-compra");
			
		}
		
		
	}
	
	
	public void cobrarFornecedor() {
		
		boolean error = false;
		float valorGasto;
		
		if(this.fornecedor_comprador instanceof FornecedorRecorrente){
			
			valorGasto = this.precoParaFornecedorRecorrente((FornecedorRecorrente) this.fornecedor_comprador);

		} else {
			
			valorGasto = this.precoTotal();
			
		}
		
		switch(this.pagamento.getTipoDePagamento()) {
		
		case APRAZO: valorGasto += valorGasto*0.02f;
			break;
			
		case AVISTA: break;
		
		default: error = true;
			break;
		
		}
		
		if(!error && valorGasto != 0) {
			
			this.aplicarImposto(valorGasto);
			
		} else {
			
			ControleDaUnidade.message("erro-de-compra");
			
		}
		
	}

}