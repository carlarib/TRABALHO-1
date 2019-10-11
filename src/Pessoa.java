
public abstract class Pessoa {

	protected String nome;
	protected Endereco endereco;
	protected String cpf;
	protected String telefone;
	
	
	public Pessoa(String nome, Endereco endereco, String cpf, String telefone) {
		if (!(nome.equals(" ")) && nome != null && endereco != null && cpf.length() == 14 && telefone.length() == 12) {
			
			this.nome = nome;
			this.endereco = endereco;
			this.cpf = cpf;
			this.telefone = telefone;
		
		} else {
			
			ControleDaUnidade.message("erro-de-insercao");
			
		}
	}

	public String getNome() {
		return this.nome;
		
	}
	
	
	public Endereco getEndereco() {
		return endereco;
	}

	public String getCpf() {
		return cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	@Override
	public String toString() {
		
		return "Nome: " + this.nome + "\n"
				+ "Endereço: " + this.endereco.toString() + "\n" 
				+ "CPF: " + this.cpf + "\n"
				+ "Telefone: " + this.telefone;
	
	}
		
}
