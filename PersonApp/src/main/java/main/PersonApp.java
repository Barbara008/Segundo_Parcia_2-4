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
			
			//Persona persona = Persona.builder().nombre("Barbara").apellido("Panelo").dni(40661020).build();
			Persona persona = new Persona();
			
			persona.setNombre("Barbara");
			persona.setApellido("Panelo");
			persona.setDni(40661020);
			//System.out.println(persona.toString());
			
			Domicilio dom1 = Domicilio.builder().calle("Lago en el Cielo").numero(1062).build();
			
			//persona.setDomicilio(dom1);
			
			//System.out.println(dom1.toString());
			
			Localidad localidad1 = Localidad.builder().denominacion("Lujan de Cuyo").build();
			
			//dom1.setLocalidad(localidad1);
			
			//System.out.println(localidad1.toString());
			
			Libro libro1 = Libro.builder().titulo("Martin Fierro").fecha(1872).genero("Poesia").paginas(233).autor("Jose Hernandez").build();
			
			//persona.getLibros().add(libro1);
			
			
			//System.out.println(libro1.toString());
			//persona.getLibros().add(libro1);
			
			Autor autor1 = Autor.builder().nombre("Jose").apellido("Hernandez").biografia("Biografia:...").build();
			//System.out.println(autor1.toString());
			persona.setDomicilio(dom1);
			
			dom1.setLocalidad(localidad1);
			
			persona.getLibros().add(libro1);
			libro1.getAutores().add(autor1);
			
			//libro1.getAutores().add(autor1);
			
			
			/*Persona persona = new Persona("Barbara", "Panelo", 40661020);
			Domicilio dom1 = new Domicilio("Lago en el cielo", 1062);
			
			persona.setDomicilio(dom1);
			
			Localidad localidad1 = new Localidad("Lujan de Cuyo");
			
			dom1.setLocalidad(localidad1);
			
			Libro libro1 = new Libro("Martin Fierro", 1872, "Poesia", 233, "Jose Hernandez");
			
			persona.getLibros().add(libro1);
			
			Autor autor1 = new Autor("Jose", "Hernandez", "Biografia:...");
			
			libro1.getAutores().add(autor1);*/
			
			
			
			
			
			
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
