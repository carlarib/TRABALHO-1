
public abstract class Pessoa {

	protected String nome;
	protected Endereco endereco;
	protected String cpf;
	protected String telefone;
	
	
	public Pessoa(String nome, Endereco endereco, String cpf, String telefone) {
		if (nome != null || !(nome.equals(" ")) && endereco != null && cpf.length() == 13 && telefone.length() == 11) {
		this.nome = nome;
		this.endereco = endereco;
		this.cpf = cpf;
		this.telefone = telefone;
		}
		else {
			
		}
	}
	
}
