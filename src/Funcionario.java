
public abstract class Funcionario extends Pessoa implements Imposto {

	protected float salarioBase;
	
	public Funcionario(String nome, Endereco endereco, String cpf, String telefone, float salarioBase) {
		super(nome, endereco, cpf, telefone);
		
		this.salarioBase = salarioBase;
		
	}
	
	@Override
	public void aplicarImposto(float salario) {
	
		Controle.adicionaImpostos(salario*0.18f);
		
		
	}

	abstract float pagarSalario();
	
	

}
