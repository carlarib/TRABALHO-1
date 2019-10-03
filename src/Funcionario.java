
public abstract class Funcionario extends Pessoa implements Imposto {

	protected float salarioBase;
	
	public Funcionario(String nome, Endereco endereco, String cpf, String telefone, float salarioBase) {
		super(nome, endereco, cpf, telefone);
		
		if (salarioBase != 0) {
		this.salarioBase = salarioBase;
		}
		else {
			
		}
		
	}
	
	@Override
	public void aplicarImposto(float salario) {
	
		ControleDaUnidade.adicionaImpostos(salario*0.18f);
		
		
	}

	abstract float pagarSalario();
	
	

}
