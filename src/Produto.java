
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
		if (nome != null && !(nome.equals("")) && String.valueOf(codigo).length() == 6 && fornecedor != null
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
	
	public Produto(String nome, int codigo, Fornecedor fornecedor, float precoDeCusto, float precoFinal, String apelido) {
		this(nome, codigo, fornecedor, precoDeCusto, precoFinal);
		if (apelido != null && !(apelido.equals(""))) {
			
			this.apelido = apelido;
			
		}
		
	}
	
	public Produto(String nome, int codigo, Fornecedor fornecedor, float precoDeCusto, float precoFinal, int quantidadeInicial, String apelido) {
		this(nome, codigo, fornecedor, precoDeCusto, precoFinal, quantidadeInicial);
		if (apelido != null && !(apelido.equals(""))) {
			
			this.apelido = apelido;
			
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

	
	public String infoNotaFiscal() {
		
		return this.nome + ": R$" + this.precoFinal;
		
	}
	
	@Override
	public String toString() {
		String retorno = "Nome";
		
		if(apelido != null) {
			
			retorno += "(" + this.apelido + ")";
			
		}
		
		retorno += ": " + this.nome + "\n"
					+ "Código: " + this.codigo + "\n"
					+ "Fornecedor: " + this.fornecedor + "\n"
					+ "Preço de custo: R$" + this.precoDeCusto + "\n"
					+ "Preço final: R$" + precoFinal;
		
		if(this instanceof ProdutoPerecivel) {
			
			retorno += "\n" + "Data de validade: " + ((ProdutoPerecivel) this).getDataDeValidade().toString();
			
		}
		
		return retorno;
		
	}	

	
}
