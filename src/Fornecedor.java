public abstract class Fornecedor {

	protected String nome;
	protected Endereco endereco;
	protected String cnpj;
	
	public Fornecedor(String nome, Endereco endereco, String cnpj) {
		
		this.nome = nome;
		this.endereco = endereco;
		this.cnpj = cnpj;
		
	}
	
	@Override
	public String toString() {
		
		return "Fornecedor: " + this.nome + "/n"
				+ "Endereço: " + this.endereco + "/n"
				+ "CNPJ: " + this.cnpj;
		
	}
	
}
