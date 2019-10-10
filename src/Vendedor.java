
public class Vendedor extends Funcionario {

	private float montanteDeVendas;
	
	public Vendedor(String nome, Endereco endereco, String cpf, String telefone, float salarioBase) {
		super(nome, endereco, cpf, telefone, salarioBase);

		this.montanteDeVendas = 0;
		
	}

	public float getMontanteDeVendas() {
		
		return this.montanteDeVendas;
		
	}
	
	public void vender(float valorDeVenda) {
		
		this.montanteDeVendas += valorDeVenda;
		
	}
	
	@Override
	float receberSalario() {

		float salarioBruto = this.salarioBase;
		
		if(this.montanteDeVendas > ControleDaUnidade.getMetaDeVenda()) {
			
			salarioBruto = this.salarioBase + this.salarioBase*0.1f;
			
		}
		
		this.aplicarImposto(salarioBruto);
		this.montanteDeVendas = 0;
		
		return salarioBruto;
	}

}
