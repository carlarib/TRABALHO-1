
public class Vendedor extends Funcionario {

	private float montanteDeVendas;
	
	public Vendedor(String nome, Endereco endereco, String cpf, String telefone, float salarioBase) {
		super(nome, endereco, cpf, telefone, salarioBase);

	}

	@Override
	float pagarSalario() {

		float salarioBruto = this.salarioBase;
		
		if(this.montanteDeVendas > ControleDaUnidade.getMetaDeVenda()) {
			
			salarioBruto = this.salarioBase + this.salarioBase*0.1f;
			
		}
		
		this.aplicarImposto(salarioBruto);
		
		return salarioBruto;
	}

}
