package br.com.devmedia.revjpa;

import java.util.List;

import br.com.devmedia.revjpa.dao.PersonDAO;
import br.com.devmedia.revjpa.entity.Person;

/**
 * Hello world!
 *
 */
public class AppRevJPA {
    public static void main( String[] args ) {
        System.out.println( "Hello World!" );
        
        //insertPerson();
        //findPersonById();
        //findAllPersons();
        //countPersons();
        //findByLastName();
        //findByAge();
        //findByFullName();
        //updatePerson();
        deletePerson();
    }
      
    

	private static void deletePerson() {
		
		new PersonDAO().delete(3L);
		
	}



	private static void updatePerson() {
		
		Person p1 = new PersonDAO().findById(5L);
		
		System.out.println(p1.toString());
		
		p1.setLastName("CucaBeludos");
		p1.setAge(21);
		p1.setFirstName("james");
		
		new PersonDAO().update(p1);
		
		Person p2 = new PersonDAO().findById(5L);
		
		System.out.println(p2.toString());
	}



	private static void findByFullName() {
		
		Person person = new PersonDAO().findByFullName("Bruna", "Figueira");
		
		System.out.println(person.toString());
	}

	private static void findByAge() {
		
		List<Person> persons = new PersonDAO().findAgeIsBetween(27, 36);
		
		for (Person person : persons){
			System.out.println(person.toString());
		}
		
	}

	private static void findByLastName() {
		List<Person> persons = new PersonDAO().findByLastName("Raflas");
		
		for (Person person : persons){
			System.out.println(person.toString());
		}
		
	}

	

	private static void countPersons() {
		long total = new PersonDAO().count();
		
		System.out.println("Total of Persons: " + total);
		
	}

	private static void findAllPersons() {
		
		List<Person> persons = new PersonDAO().findAll();
		
		for (Person p : persons) {
			System.out.println(p.toString());
		}
		
	}

	private static void findPersonById() {
		Person p1 = new PersonDAO().findById(2L);
		
		Person p2 = new PersonDAO().findById(4L);
		
		System.out.println(p1.toString());
		System.out.println(p2.toString());
	}

	private static void insertPerson() {
		Person p1 = new Person();
		p1.setFirstName("Fabiana");
		p1.setLastName("da Silva");
		p1.setAge(29);
		
		new PersonDAO().save(p1);
		
		System.out.println(p1.toString());
		
		Person p2 = new Person();
		p2.setFirstName("Gilberto");
		p2.setLastName("Figueira");
		p2.setAge(36);
		
		new PersonDAO().save(p2);
		
		System.out.println(p2.toString());
		
		Person p3 = new Person();
		p3.setFirstName("Carlos Andre");
		p3.setLastName("Rodrigues");
		p3.setAge(36);
		
		new PersonDAO().save(p3);
		
		System.out.println(p3.toString());
	}
}
