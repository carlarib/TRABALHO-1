
public enum TipoDePagamento {

	AVISTA("� vista"), APRAZO("A prazo");
	
public String tipoDePagamento;
	
	TipoDePagamento(String tipoPagamento){
		
		this.tipoDePagamento = tipoPagamento;
		
	}
	
	public String getTipo() {
		
		return this.tipoDePagamento;
		
	}
	
}
