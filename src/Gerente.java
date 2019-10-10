
public class Gerente extends Funcionario {

	public Gerente(String nome, Endereco endereco, String cpf, String telefone, float salarioBase) {
		super(nome, endereco, cpf, telefone, salarioBase);
	
	}


	@Override
	public float receberSalario() {
		
		float salarioBruto = this.salarioBase + this.salarioBase*0.2f;
		this.aplicarImposto(salarioBruto);
		
		return salarioBruto;
		
	}

}
