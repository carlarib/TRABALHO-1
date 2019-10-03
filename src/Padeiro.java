
public class Padeiro extends Funcionario {

	private int horaExtra;
	
	public Padeiro(String nome, Endereco endereco, String cpf, String telefone, float salarioBase) {
		super(nome, endereco, cpf, telefone, salarioBase);
		
	}

	@Override
	float pagarSalario() {
		
		float salarioBruto = this.salarioBase + this.horaExtra*0.25f*this.salarioBase;
		this.aplicarImposto(salarioBruto);
		
		return salarioBruto;
	}



}
