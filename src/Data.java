public class Data {

	private int dia;
	private int mes;
	private int ano;
	
	public Data(int dia, int mes, int ano) {
		boolean bissexto = false;

		if ((ano % 4 == 0)) {
			
			bissexto = true;
			
		}

		if (ano > 0 && String.valueOf(ano).length() == 4 && mes > 0 && mes <= 12) {
				
				if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
					
					if (dia > 0 && dia <= 31) {
						
						this.dia = dia;
						this.mes = mes;
						this.ano = ano;
						
					} else {
						
						ControleDaUnidade.message("data-invalida");
						
					}
					
				} else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
					
					if (dia > 0 && dia <= 30) {
						
						this.dia = dia;
						this.mes = mes;
						this.ano = ano;
						
					} else {
						
						ControleDaUnidade.message("data-invalida");
						
					}
					
				} else if (mes == 2) {
					
					if (bissexto) {
						
						if (dia > 0 && dia <= 29) {
							
							this.dia = dia;
							this.mes = mes;
							this.ano = ano;
						
						} else {
							
							ControleDaUnidade.message("data-invalida");
							
						}
						
					} else {
						
						if (dia > 0 && dia <= 28) {
							
							this.dia = dia;
							this.mes = mes;
							this.ano = ano;
						
						} else {
							
							ControleDaUnidade.message("data-invalida");
							
						}
					}
				}
				
			} else {
				
			ControleDaUnidade.message("data-invalida");
		}
	}
	
	@Override
	public String toString(){
		
		return this.dia + "/" + this.mes + "/" + this.ano;
		
	}
	
}
