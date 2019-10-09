public abstract class Fornecedor {

	protected String nome;
	protected Endereco endereco;
	protected String cnpj;
	
	public Fornecedor(String nome, Endereco endereco, String cnpj) {
		if (nome != null && !nome.equals("") && endereco != null && cnpj.length() == 18) {
			this.nome = nome;
			this.endereco = endereco;
			this.cnpj = cnpj;
		}
		else {
			ControleDaUnidade.message("erro-de-insercao");
		}
		
	}
	
	public Fornecedor fornecerProduto() {
		
		return this;
		
	}
	
	public String getNome() {
		
		return this.nome;
		
	}
	
	@Override
	public String toString() {
		
		return "Fornecedor: " + this.nome + "/n"
				+ "Endereço: " + this.endereco + "/n"
				+ "CNPJ: " + this.cnpj;
		
	}
	
	
}
