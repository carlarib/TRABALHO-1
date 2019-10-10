
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
			
			ControleDaUnidade.adicionaImpostos(salario*0.18f);
			
		
	}

	abstract float receberSalario();

	@Override
	public String toString() {
		String retorno = super.toString();
		
		if(this instanceof Padeiro) {
			
			retorno += "\n" + "Função: Padeiro" + "\n"
					 	+ "Salário Base: R$" + this.salarioBase + "\n"
						+ "Horas extras trabalhadas: " + ((Padeiro) this).getHoraExtra() + "\n"
						+ "Salário a ser recebido até o momento: R$" + ((Padeiro) this).receberSalario();
			
		} else if(this instanceof Vendedor) {
			
			retorno += "\n" + "Função: Vendedor" + "\n"
						+ "Salário Base: R$" + this.salarioBase + "\n"
						+ "Montante atual de vendas: R$" + ((Vendedor) this).getMontanteDeVendas() + "\n"
						+ "Salário a ser recebido até o momento: R$" + ((Vendedor) this).receberSalario();
			
		} else if(this instanceof Gerente) {
			
			retorno += "\n" + "Função: Gerente" + "\n"
						+ "Salário Base: R$" + this.salarioBase + "\n"
						+ "Salário Bruto: R$" + ((Gerente) this).receberSalario();
			
		}
		
		return retorno;
		
	}
	
}
