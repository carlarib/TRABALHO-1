public class Pagamento {

	private TipoDePagamento tipoDePagamento;
	private int parcelas;
	private FormaDePagamento formaDePagamento;
	
	public Pagamento(String tipoPagamento, String formaPagamento) {
		
		switch(tipoPagamento) {
		
		case "� vista" : this.tipoDePagamento = TipoDePagamento.AVISTA; this.parcelas = 0; break;
		
		case "A prazo" : this.tipoDePagamento = TipoDePagamento.APRAZO; break;
		
		}
		
		switch(formaPagamento) {
		
			case "D�bito" : this.formaDePagamento = FormaDePagamento.DEBITO; break;
			
			case "Cr�dito" : this.formaDePagamento = FormaDePagamento.CREDITO; break;
			
			case "Dinheiro" : this.formaDePagamento = FormaDePagamento.DINHEIRO; break;
			
		}
		
	}

	public int getParcelas() {
		
		return this.parcelas;
		
	}
	
	public void setParcelas(int parcelas) {
		
		this.parcelas = parcelas;
	}

	
	public TipoDePagamento getTipoDePagamento() {
	
		return tipoDePagamento;
	
	}

	
	public FormaDePagamento getFormaDePagamento() {
	
		return formaDePagamento;
	
	}
	
	
	
}
