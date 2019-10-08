public class FornecedorRecorrente extends Fornecedor {

	private float taxaDeDesconto;
	
	public FornecedorRecorrente(String nome, Endereco endereco, String cnpj, float taxaDeDesconto) {
		super(nome, endereco, cnpj);
		this.taxaDeDesconto = taxaDeDesconto;
	
	
	}
		
	public float getTaxaDeDesconto() {
		
		return this.taxaDeDesconto;
		
	}

}
