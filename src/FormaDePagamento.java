
public enum FormaDePagamento {

	DEBITO("Débito"), CREDITO("Crédito"), DINHEIRO("Dinheiro");
	
	public String formaDePagamento;
	
	FormaDePagamento(String formaDePagamento){
		
		this.formaDePagamento = formaDePagamento;
		
	}

	public String getForma() {
		
		return this.formaDePagamento;
	}
	
	
}
