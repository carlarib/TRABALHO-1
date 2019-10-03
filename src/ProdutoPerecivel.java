public class ProdutoPerecivel extends Produto {

	private Data dataDeValidade;
	
	public ProdutoPerecivel(String nome, int codigo, Fornecedor fornecedor, float precoDeCusto, float precoFinal, Data dataDeValidade) {
		super(nome, codigo, fornecedor, precoDeCusto, precoFinal);
		
		this.dataDeValidade = dataDeValidade;
		
	}

}
