package ar.edu.unlam.pb2.gimnasio;

public class Coaching extends Servicio implements Coachable{

	private Double precioFijo;

	public Coaching(Double precioFijo) {
		this.precioFijo = precioFijo;
	}

	@Override
	public Double calcularPrecio(Plan plan1) {
		return 0.0;
	}

	@Override
	public void coachable(Plan plan1) {
		Double precioAumentado;
		precioAumentado = precioFijo + plan1.getPrecioBase();
		plan1.setPrecioBase(precioAumentado);
		plan1.tieneCoach(true);
		
	}


}
