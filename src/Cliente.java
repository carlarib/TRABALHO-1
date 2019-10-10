
public class Cliente extends Pessoa {
	
	private float valorAcumulado;
	private TipoCliente tipoDoCliente;
	
	public Cliente(String nome, Endereco endereco, String cpf, String telefone) {
		super(nome, endereco, cpf, telefone);
		
		this.valorAcumulado = 0;
		tipoDoCliente = TipoCliente.COMUM;
	}
	
	public TipoCliente getTipoDoCliente() {
	
		return tipoDoCliente;
	
	}
	
	public void comprar(float valorGasto) {
		
		if(valorGasto > 0.0f) {
			
			this.valorAcumulado += valorGasto;
		
			if(this.valorAcumulado >= ControleDaUnidade.getValorClientePlatinum()) {
				
				this.tipoDoCliente = TipoCliente.PLATINUM;
				ControleDaUnidade.message("cliente-platinum");
				
			} else if(this.valorAcumulado >= ControleDaUnidade.getValorClienteGold()) {
				
				this.tipoDoCliente = TipoCliente.GOLD;
				ControleDaUnidade.message("cliente-gold");
				
			}
		}
		else {
			ControleDaUnidade.message("compra-inexistente");
		}
		
	}

	
	@Override
	public String toString() {
		
		return super.toString() + "\n"
				+ "Valor acumulado em compras: R$" + this.valorAcumulado + "\n"
				+ "Tipo de fidelidade: " + this.tipoDoCliente.getTipoCliente();
	}
	
}
