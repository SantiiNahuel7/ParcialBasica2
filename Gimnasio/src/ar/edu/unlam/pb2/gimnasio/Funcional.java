package ar.edu.unlam.pb2.gimnasio;

public class Funcional extends Servicio{
	
	private Double precioBase;
	private static final Double EXTRA = 25000.0;

	public Funcional(Double precioBase) {
		this.precioBase = precioBase;
	}

	@Override
	public Double calcularPrecio(Plan plan1) {
		
		if(plan1.esPersonalizado())	{
			return this.precioBase + EXTRA;
		}
		return this.precioBase;
	}

}
