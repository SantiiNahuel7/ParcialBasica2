package ar.edu.unlam.pb2.gimnasio;

public class Masaje extends Servicio{
	
	private Double precioBase;
	private static final Double PRECIO_MAXIMO = 150000.0;

	public Masaje(Double precioBase) {
		this.precioBase = precioBase;
	}

	@Override
	public Double calcularPrecio(Plan plan1) {
		
		Double precioTotal = 0.0;
		
		if (plan1.esIntensivo()) {
			this.precioBase = 10000.0;
			precioTotal = this.precioBase * plan1.getSemanas();
			if(precioTotal > PRECIO_MAXIMO)
				return PRECIO_MAXIMO;
		}
		return precioTotal;
	}

}
