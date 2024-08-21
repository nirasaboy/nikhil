package in.ashokit.processor;


	import org.springframework.batch.item.ItemProcessor;

import in.ashokit.entity.Person;

	public class PersonItemProcessor implements ItemProcessor<Person, Person> {

	    @Override
	    public Person process(Person person) throws Exception {
	        String name = person.getName().toUpperCase();
	        person.setName(name);
	        return person;
	    }
	}



