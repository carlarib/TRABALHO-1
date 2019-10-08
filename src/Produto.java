
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
		
		new Estoque(this);
		
	}
	
	public Produto(String nome, int codigo, Fornecedor fornecedor, float precoDeCusto, float precoFinal, int quantidadeInicial) {
		this.nome = nome;
		this.codigo = codigo;
		this.fornecedor = fornecedor;
		this.precoDeCusto = precoDeCusto;
		this.precoFinal = precoFinal;
		
		new Estoque(this, quantidadeInicial);
		
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
		
		this.fornecedor = fornecedor;
		
	}
	
	public int getCodigo() {
		
		return this.codigo;
		
	}
}
