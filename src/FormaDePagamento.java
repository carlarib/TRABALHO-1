
public enum FormaDePagamento {

	DEBITO("D�bito"), CREDITO("Cr�dito"), DINHEIRO("Dinheiro");
	
	public String formaDePagamento;
	
	FormaDePagamento(String formaDePagamento){
		
		this.formaDePagamento = formaDePagamento;
		
	}

	public String getForma() {
		
		return this.formaDePagamento;
	}
	
	
}
