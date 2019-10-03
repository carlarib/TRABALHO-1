
public enum FormaDePagamento {

	DEBITO("Débito"), CREDITO("Crédito"), DINHEIRO("Dinheiro");
	
	public String formaDePagamento;
	
	FormaDePagamento(String formaDePagamento){
		
		this.formaDePagamento = formaDePagamento;
		
	}

	public String getTipoPagamento() {
		
		return this.formaDePagamento;
	}
	
	
}
