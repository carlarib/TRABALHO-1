
public enum TipoDePagamento {

	AVISTA("À vista"), APRAZO("À prazo");
	
public String tipoDePagamento;
	
	TipoDePagamento(String tipoPagamento){
		
		this.tipoDePagamento = tipoPagamento;
		
	}
	
	public String getTipoDePagamento() {
		
		return this.tipoDePagamento;
		
	}
	
}
