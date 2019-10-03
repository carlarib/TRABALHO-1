
public class Cliente extends Pessoa {
	
	private float valorAcumulado;
	private TipoCliente tipoCliente;
	
	public Cliente(String nome, Endereco endereco, String cpf, String telefone, float valorAcumulado) {
		super(nome, endereco, cpf, telefone);
		
		this.valorAcumulado = valorAcumulado;
		
		tipoCliente = TipoCliente.COMUM;
	}

}
