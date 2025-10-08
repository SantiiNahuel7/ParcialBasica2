package ar.edu.unlam.pb2.gimnasio;

public class Suplemento extends Servicio{
	
	private Double precioBase;
	private Double precioPorSemana;

	public Suplemento(Double precioBase, Double precioPorSemana) {
		this.precioBase = precioBase;
		this.precioPorSemana = precioPorSemana;
	}

	@Override
	public Double calcularPrecio(Plan plan1) {
		return this.precioBase + (this.precioPorSemana * plan1.getSesiones());
	}

}
