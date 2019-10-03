
public abstract class Produto {

	protected String nome;
	protected int codigo;
	protected Fornecedor fornecedor;
	protected float precoDeCusto;
	protected float precoFinal;
	protected String apelido;
	
	public Produto(String nome, int codigo, Fornecedor fornecedor, float precoDeCusto, float precoFinal) {
		this.nome = nome;
		this.codigo = codigo;
		this.fornecedor = fornecedor;
		this.precoDeCusto = precoDeCusto;
		this.precoFinal = precoFinal;
	}
	
	public float getPrecoFinal() {
		
		return this.precoFinal;
		
	}
	
}
