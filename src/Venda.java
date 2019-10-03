
public class Venda implements Imposto{

	private Produto[] produtos;
	private Data dataDeVenda;
	private Vendedor vendedor;
	private Pagamento pagamento;
	private Cliente comprador;
	

	public Venda(Produto[] produtos, Data dataDeVenda, Vendedor vendedor, Pagamento pagamento, Cliente comprador) {
		
		this.produtos = produtos;
		this.dataDeVenda = dataDeVenda;
		this.vendedor = vendedor;
		this.pagamento = pagamento;
		this.comprador = comprador;
		
		this.cobrar();
		
	}
	
	public float precoTotal() {
		
		float preco = 0;
		
		for(int i = 0; i < produtos.length; i++) {
			
			preco += produtos[i].getPrecoFinal();
			
		}

		return preco;
		
	}
	
	@Override
	public void aplicarImposto(float valor) {
		
		ControleDaUnidade.adicionaImpostos(0.15f*valor);
		
	}

	public void cobrar() {
		
		float valorGasto = 0;
		boolean error = false;
		
		switch(this.comprador.getTipoCliente()) {
		
		case COMUM: valorGasto = this.precoTotal();
			break;
		
		case GOLD: valorGasto = this.precoTotal() - this.precoTotal()*0.05f;
			break;
		
		case PLATINUM: valorGasto = this.precoTotal() - this.precoTotal()*0.1f;
			break;
			
		default : error = true;
			break;
		
		}
		
		if(!error && valorGasto != 0) {
			
			this.aplicarImposto(valorGasto);
			this.comprador.comprar(valorGasto);
			
		} else {
			
			ControleDaUnidade.message("erro-de-compra");
			
		}
		
		
	}
	
}
