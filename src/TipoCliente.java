
public enum TipoCliente {

	COMUM("Comum"), GOLD("Gold"), PLATINUM("Platinum");
	
	public String tipoCliente;
	
	TipoCliente(String tipoCliente){
		
		this.tipoCliente = tipoCliente;
		
	}
	
	public String getTipoCliente() {
		
		return this.tipoCliente;
		
	}
	
}
