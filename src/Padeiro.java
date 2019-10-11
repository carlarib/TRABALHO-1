
public class Padeiro extends Funcionario {

	private int horaExtra;
	
	public Padeiro(String nome, Endereco endereco, String cpf, String telefone, float salarioBase) {
		super(nome, endereco, cpf, telefone, salarioBase);
		this.horaExtra = 0;
		
	}

	public int getHoraExtra() {
		
		return this.horaExtra;
		
	}
	
	public void adicionarHorasExtra(int horasExtras) {
		
		this.horaExtra += horasExtras;
		
	}
	
	public
	
	@Override
	float receberSalario() {
		
		float salarioBruto = this.salarioBase + this.horaExtra*0.25f*this.salarioBase;
		this.aplicarImposto(salarioBruto);
		this.horaExtra = 0;
		
		return salarioBruto;
	}

	
}
