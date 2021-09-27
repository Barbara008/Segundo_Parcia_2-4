package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



import entidades.Autor;
import entidades.Domicilio;
import entidades.Libro;
import entidades.Localidad;
import entidades.Persona;

public class PersonApp {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonAppPU");
		EntityManager em = emf.createEntityManager();
		
		try {
			em.getTransaction().begin();
			
			
			Persona persona = new Persona();
			
			persona.setNombre("Barbara");
			persona.setApellido("Panelo");
			persona.setDni(40661020);
			
			Domicilio dom1 = Domicilio.builder().calle("Lago en el Cielo").numero(1062).build();
			
			
			
			//System.out.println(dom1.toString());
			
			Localidad localidad1 = Localidad.builder().denominacion("Lujan de Cuyo").build();
			
			
			
			Libro libro1 = Libro.builder().titulo("Martin Fierro").fecha(1872).genero("Poesia").paginas(233).autor("Jose Hernandez").build();
			
			
			
			Autor autor1 = Autor.builder().nombre("Jose").apellido("Hernandez").biografia("Biografia:...").build();
			
			persona.setDomicilio(dom1);
			
			dom1.setLocalidad(localidad1);
			
			persona.getLibros().add(libro1);
			libro1.getAutores().add(autor1);
			
			
			
			
			em.persist(persona);
			
			em.flush();
			
			em.getTransaction().commit();
			
			
		}catch (Exception e) {
			
			em.getTransaction().rollback();			
		}
		
		em.close();
		emf.close();
	}
}
