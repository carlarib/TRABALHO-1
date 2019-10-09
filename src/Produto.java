
public abstract class Produto {

	protected String nome;
	protected int codigo;
	protected Fornecedor fornecedor;
	protected float precoDeCusto;
	protected float precoFinal;
	protected String apelido;
	
	public Produto(String nome, int codigo, Fornecedor fornecedor, float precoDeCusto, float precoFinal) {
		
		if (nome != null && nome.equals("") && String.valueOf(codigo).length() == 6 && fornecedor != null
			&& precoDeCusto > 0.0f && precoFinal > 0.0f) {
			this.nome = nome;
			this.codigo = codigo;
			this.fornecedor = fornecedor;
			this.precoDeCusto = precoDeCusto;
			this.precoFinal = precoFinal;
			new Estoque(this);
		}
		else {
			ControleDaUnidade.message("erro-de-insercao");
		}
		
	}
	
	public Produto(String nome, int codigo, Fornecedor fornecedor, float precoDeCusto, float precoFinal, int quantidadeInicial) {
		if (nome != null && nome.equals("") && String.valueOf(codigo).length() == 6 && fornecedor != null
			&& precoDeCusto > 0.0f && precoFinal > 0.0f && quantidadeInicial > 0 && quantidadeInicial <= 30) {
			this.nome = nome;
			this.codigo = codigo;
			this.fornecedor = fornecedor;
			this.precoDeCusto = precoDeCusto;
			this.precoFinal = precoFinal;
			
			new Estoque(this, quantidadeInicial);
		}
		else {
			ControleDaUnidade.message("erro-de-insercao");
		}
		
	}
	
	public String getNome() {
		
		return this.nome;
		
	}
	
	public float getPrecoFinal() {
		
		return this.precoFinal;
		
	}
	
	public Fornecedor getFornecedor() {
		
		return this.fornecedor;
		
	}
	
	public void setFornecedor(Fornecedor fornecedor) {
		
		if(fornecedor != null) {
			this.fornecedor = fornecedor;
		}
		else {
			ControleDaUnidade.message("erro-de-insercao");
		}
		
	}
	
	public int getCodigo() {
		
		return this.codigo;
		
	}
}
