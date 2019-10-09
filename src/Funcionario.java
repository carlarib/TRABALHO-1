
public abstract class Funcionario extends Pessoa implements Imposto {

	protected float salarioBase;
	
	public Funcionario(String nome, Endereco endereco, String cpf, String telefone, float salarioBase) {
		super(nome, endereco, cpf, telefone);
		
		if (salarioBase >= 0.0f) {
			this.salarioBase = salarioBase;
		}
		else {
			
			ControleDaUnidade.message("erro-de-insercao");
			
		}
		
	}
	
	@Override
	public void aplicarImposto(float salario) {
		if (salario > 0.0f) {
			ControleDaUnidade.adicionaImpostos(salario*0.18f);
		}	
		else {
			ControleDaUnidade.message("erro-de-insercao");
		}
		
	}

	abstract float pagarSalario();
	
	

}
