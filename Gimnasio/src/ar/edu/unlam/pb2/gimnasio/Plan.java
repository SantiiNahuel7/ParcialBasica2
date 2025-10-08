package ar.edu.unlam.pb2.gimnasio;

import java.util.HashSet;
import java.util.Set;


public class Plan {
	private Double precioBase;
	private Integer duracion;
	private String intensidad;
	private Integer sesion;
	private Set<Servicio> servicios = new HashSet<Servicio>();
	private Boolean intenviso = false;
	private Boolean personalizado = false;

	public Plan(Double precioBase, Integer duracion, String intensidad, Integer sesion) {
		this.precioBase = precioBase;
		this.duracion = duracion;
		this.intensidad = intensidad;
		this.sesion = sesion;
	}

	public Boolean esIntensivo() {
		if (this.intensidad == "alta" && this.sesion >= 5) {
			this.intenviso = true;
			return this.intenviso;
		}
		return this.intenviso;
	}

	public Boolean esPersonalizado() {
		if ((this.intensidad == "alta" || this.intensidad == "media") && this.duracion > 8) {
			this.personalizado = true;
			return this.personalizado;
			
		}
		return this.personalizado;
	}

	public void setIntensidad(String nuevaIntensidad) {
		this.intensidad = nuevaIntensidad;
		
	}

	public void setPrecioBase(Double nuevoPrecio) {
		this.precioBase = nuevoPrecio;
		
	}

	public Double getPrecioBase() {
		return this.precioBase;
	}

	public String getIntensidad() {
		return this.intensidad;
	}

	public Integer getSemanas() {
		return this.duracion;
	}
	
	public Integer getSesiones() {
		return this.sesion;
	}

	public void agregarServicio(Servicio servicio1) {
		servicios.add(servicio1);
	}

	public Set<Servicio> getServicios() {
		return servicios;
	}

	public Double getPrecioFinal() {
		
		Double precioTotal;
		
		precioTotal = this.precioBase;
		
		for (Servicio servicio1 : servicios) {
			precioTotal += servicio1.calcularPrecio(this);
		}
		return precioTotal;
	}

	public double getPrecioFinalConDescuento(Double porcentaje) {
		
		Double precioTotal;
		
		precioTotal = this.precioBase;
		
		for (Servicio servicio1 : servicios) {
			precioTotal += servicio1.calcularPrecio(this);
		}
		return precioTotal * porcentaje;
	}

	public double getPrecioFinalConDescuentoFijo(Double descuento) {
		
		Double precioTotal;
		
		precioTotal = this.precioBase;
		
		for (Servicio servicio1 : servicios) {
			precioTotal += servicio1.calcularPrecio(this);
		}
		return precioTotal - descuento;
	}
	
	public void tieneCoach(Boolean coach) {
		this.intenviso = false;
		this.personalizado = coach;
	}

}
