package ar.edu.unlam.pb2.gimnasio;

import java.util.Objects;

public abstract class Servicio {
	
	public abstract Double calcularPrecio(Plan plan1);
	
	@Override
    public int hashCode() {
        return Objects.hash(this.getClass());
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; 
        if (obj == null) return false; 
        return getClass() == obj.getClass();
    }

}
