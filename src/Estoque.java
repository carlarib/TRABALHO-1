
public class Estoque {

	private Produto produtoEmEstoque;
	private int quantidadeEmEstoque;
	
	public Estoque(Produto produto) {
		
		this.produtoEmEstoque = produto;
		this.quantidadeEmEstoque = 30;
		
	}
	
	public Estoque(Produto produto, int quantidade) {
		
		this.produtoEmEstoque = produto;
		this.quantidadeEmEstoque = quantidade;
		
	}
	
	public boolean produtoPorCodigo(int codigo) {

		if(String.valueOf(codigo).length() == 6) {
			if(this.produtoEmEstoque.getCodigo() == codigo && this.quantidadeEmEstoque > 0) {
			
				if(this.quantidadeEmEstoque == 2) {
					
					this.emitirAlerta();
					
				}
			
			return true;
			
		}
		
		return false;

		}
		else {
			ControleDaUnidade.message("erro-de-insercao");
			return false;
		}
		
	}

	public Produto getProdutoEmEstoque() {
		
		return this.produtoEmEstoque;
		
	}
	
	public void diminuiQuantidadeEmEstoque() {
		
		this.quantidadeEmEstoque--;
		
	}
	
	public void emitirAlerta() {
		
		ControleDaUnidade.message(this.produtoEmEstoque.getNome() + "possui somente uma unidade!");
		
	}
	
	public void reabastecerEstoque(int quantidadeReabastecida) {
		
		if (quantidadeReabastecida > 0 && (quantidadeReabastecida + quantidadeEmEstoque) <= 30) {
			Fornecedor fornecedorAtual = this.produtoEmEstoque.getFornecedor();
			boolean produtoFornecido = false;
			
			if(fornecedorAtual instanceof FornecedorRecorrente) {
				
				produtoFornecido = ControleDaUnidade.solicitarProdutoAoFornecedorAtual();
				
			}
			
			if(!produtoFornecido) {
				
				Fornecedor fornecedorSolicitado = ControleDaUnidade.solicitarProduto();
				
				if(fornecedorSolicitado != null) {
					
					this.quantidadeEmEstoque += quantidadeReabastecida;
					this.produtoEmEstoque.setFornecedor(fornecedorSolicitado);
					
					ControleDaUnidade.message(this.produtoEmEstoque.getNome() + "foi reabastecido!");
					
				} else {
					
					
					ControleDaUnidade.message("É necessário encontrar um novo fornecedor para o produto " + this.produtoEmEstoque.getNome());
					
				}
				
			} else {
				
				this.quantidadeEmEstoque += quantidadeReabastecida;
				ControleDaUnidade.message(this.produtoEmEstoque.getNome() + "foi reabastecido!");
				
			}
		}
		else {
			ControleDaUnidade.message("erro-de-insercao");
		}
	}
}