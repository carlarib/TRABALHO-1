public class Endereco {

	private String rua;
	private int numero;
	private String bairro;
	private String cidade;
	private String estado;
	
	public Endereco(String rua, int numero, String bairro, String cidade, String estado) {
		if (!(rua.equals(" ")) || rua != null && numero != 0 && bairro != null || !(bairro.equals(" ")) && 
				cidade != null || !(cidade.equals(" ")) && estado != null || !(estado.equals(" "))){
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		} else {
			
			ControleDaUnidade.message("erro-de-insercao");
			
		}
	}

	@Override
	public String toString() {
		return "Rua " + rua + ", número " + numero + ", bairro " + bairro + ", " + cidade + "-"+ estado;
	}
	
}
