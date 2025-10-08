package ar.edu.unlam.pb2.gimnasio;

public class Nutricionista extends Servicio {
	
	private Double precioPorSemana;
	

	public Nutricionista(Double precioPorSemana) {
		this.precioPorSemana = precioPorSemana;
	}


	@Override
	public Double calcularPrecio(Plan plan1) {
		return this.precioPorSemana * plan1.getSemanas();
	}

}
