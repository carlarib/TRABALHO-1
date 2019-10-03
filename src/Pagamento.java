public class Pagamento {

	private TipoDePagamento tipoDePagamento;
	private int parcelas;
	private FormaDePagamento formaDePagamento;
	
	public Pagamento(String tipoPagamento, String formaPagamento) {
		
		switch(tipoPagamento) {
		
		case "À vista" : this.tipoDePagamento = TipoDePagamento.AVISTA; this.parcelas = 0; break;
		
		case "A prazo" : this.tipoDePagamento = TipoDePagamento.APRAZO; break;
		
		}
		
		switch(formaPagamento) {
		
			case "Débito" : this.formaDePagamento = FormaDePagamento.DEBITO; break;
			
			case "Crédito" : this.formaDePagamento = FormaDePagamento.CREDITO; break;
			
			case "Dinheiro" : this.formaDePagamento = FormaDePagamento.DINHEIRO; break;
			
		}
		
	}

	public void setParcelas(int parcelas) {
		
		this.parcelas = parcelas;
	}
	
	
	
}
