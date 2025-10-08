package ar.edu.unlam.pb2.gimnasio;

import static org.junit.Assert.*;

import org.junit.Test;

public class GimnasioTest {

	@Test
	public void testQueSeCreeElPlan() {
		
		Plan plan1 = new Plan(400000.0, 10, "alta", 5);
		
		assertNotNull(plan1);
	}
	
	@Test
	public void testQueUnPlanSeaIntensivo() {
		
		Plan plan1 = new Plan(400000.0, 10, "alta", 5);
		
		assertTrue(plan1.esIntensivo());
	}
	
	@Test
	public void testQueUnPlanSeaPersonalizado() {
		
		Plan plan1 = new Plan(400000.0, 5, "alta", 5);
		Plan plan2 = new Plan(400000.0, 10, "media", 5);
		
		assertFalse(plan1.esPersonalizado());
		assertTrue(plan2.esPersonalizado());
	}
	
	@Test
	public void testQueSuIntensidadYPrecioBaseSePuedanModificar() {
		
		Plan plan1 = new Plan(400000.0, 10, "alta", 5);
		
		plan1.setIntensidad("media");
		plan1.setPrecioBase(300000.0);
		
		assertEquals(300000.0,plan1.getPrecioBase(),0.0);
		assertEquals("media", plan1.getIntensidad());
	}
	
	@Test
	public void testQueSePuedaAgregarUnServicio() {
		
		Plan plan1 = new Plan(400000.0, 10, "alta", 5);
		Nutricionista nutri1 = new Nutricionista (10000.0);
		
		plan1.agregarServicio(nutri1);
		
		assertEquals(1, plan1.getServicios().size(),0);
	}
	
	@Test
	public void testNoQueSePuedaAgregarUnServicioRepetido() {
		
		Plan plan1 = new Plan(400000.0, 10, "alta", 5);
		Nutricionista nutri1 = new Nutricionista (10000.0);
		Nutricionista nutri2 = new Nutricionista (10000.0);
		
		plan1.agregarServicio(nutri1);
		plan1.agregarServicio(nutri2);
		
		assertEquals(1, plan1.getServicios().size(),0);
	}
	
	@Test
	public void testQueElNutricionistaDevuelvaBienElPrecio() {
		
		Plan plan1 = new Plan(400000.0, 10, "alta", 5);
		Nutricionista nutri1 = new Nutricionista (10000.0);
		
		plan1.agregarServicio(nutri1);
		
		assertEquals(500000.0, plan1.getPrecioFinal(),0.0);
	}
	
	@Test
	public void testQueLosSuplementosDevuelvanBienElPrecio() {
		
		Plan plan1 = new Plan(400000.0, 10, "alta", 5);
		Suplemento suple1 = new Suplemento(20000.0, 5000.0);
		
		plan1.agregarServicio(suple1);
		
		assertEquals(445000.0, plan1.getPrecioFinal(),0.0);
	}
	
	@Test
	public void testQueLosMasajesDevuelvanBienElPrecio() {
		
		Plan plan1 = new Plan(400000.0, 10, "alta", 5);
		Masaje masaje1 = new Masaje (8000.0);
		
		assertTrue(plan1.esPersonalizado());
		plan1.agregarServicio(masaje1);
		
		assertEquals(500000.0, plan1.getPrecioFinal(),0.0);
	}
	
	@Test
	public void testDevuelvaElPrecioBaseConServicios() {
		
		Plan plan1 = new Plan(400000.0, 10, "alta", 5);
		Nutricionista nutri1 = new Nutricionista (10000.0);
		Suplemento suple1 = new Suplemento(20000.0, 5000.0);
		Masaje masaje1 = new Masaje (8000.0);
		
		
		plan1.agregarServicio(nutri1);
		plan1.agregarServicio(suple1);
		plan1.agregarServicio(masaje1);
		
		assertEquals(645000.0, plan1.getPrecioFinal(),0.0);
	}
	
	@Test
	public void testDevuelvaElPrecioConPorcentaje() {
		
		Plan plan1 = new Plan(400000.0, 10, "alta", 5);
		Nutricionista nutri1 = new Nutricionista (10000.0);
		Suplemento suple1 = new Suplemento(20000.0, 5000.0);
		Masaje masaje1 = new Masaje (8000.0);
		
		
		plan1.agregarServicio(nutri1);
		plan1.agregarServicio(suple1);
		plan1.agregarServicio(masaje1);
		
		assertEquals(580500.0, plan1.getPrecioFinalConDescuento(0.9),0.0);
	}
	
	@Test
	public void testDevuelvaElPrecioConDescuento() {
		
		Plan plan1 = new Plan(400000.0, 10, "alta", 5);
		Nutricionista nutri1 = new Nutricionista (10000.0);
		Suplemento suple1 = new Suplemento(20000.0, 5000.0);
		Masaje masaje1 = new Masaje (8000.0);
		Funcional funcional1 = new Funcional(10000.0);
		
		
		plan1.agregarServicio(nutri1);
		plan1.agregarServicio(suple1);
		plan1.agregarServicio(masaje1);
		plan1.agregarServicio(funcional1);
		
		assertEquals(630000.0, plan1.getPrecioFinalConDescuentoFijo(50000.0),0.0);
	}
	

	
}
