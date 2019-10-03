
public class Venda implements Imposto{

	private Produto[] produtos;
	private Data dataDeVenda;
	private Vendedor vendedor;
	private Pagamento pagamento;
	

	public Venda(Produto[] produtos, Data dataDeVenda, Vendedor vendedor, Pagamento pagamento) {
		super();
		this.produtos = produtos;
		this.dataDeVenda = dataDeVenda;
		this.vendedor = vendedor;
		this.pagamento = pagamento;
	}
	
	public float precoTotal() {
		
		float preco = 0;
		
		for(int i = 0; i < produtos.length; i++) {
			
			preco += produtos[i].getPrecoFinal();
			
		}
		
		
		this.aplicarImposto(preco);
		return preco;
		
	}
	
	@Override
	public void aplicarImposto(float valor) {
		
		ControleDaUnidade.adicionaImpostos(0.15f*valor);
		
	}

	
}
