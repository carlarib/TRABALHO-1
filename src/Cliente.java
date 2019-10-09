
public class Cliente extends Pessoa {
	
	private float valorAcumulado;
	private TipoCliente tipoCliente;
	
	public Cliente(String nome, Endereco endereco, String cpf, String telefone) {
		super(nome, endereco, cpf, telefone);
		
		this.valorAcumulado = 0;
		tipoCliente = TipoCliente.COMUM;
	}
	
	public TipoCliente getTipoCliente() {
	
		return tipoCliente;
	
	}
	
	public void comprar(float valorGasto) {
		
		if(valorGasto > 0.0f) {
			this.valorAcumulado += valorGasto;
		
			if(this.valorAcumulado >= ControleDaUnidade.getValorClientePlatinum()) {
				
				this.tipoCliente = TipoCliente.PLATINUM;
				ControleDaUnidade.message("cliente-platinum");
				
			} else if(this.valorAcumulado >= ControleDaUnidade.getValorClienteGold()) {
				
				this.tipoCliente = TipoCliente.GOLD;
				ControleDaUnidade.message("cliente-gold");
				
			}
		}
		else {
			ControleDaUnidade.message("erro-de-insercao");
		}
		
	}

}
