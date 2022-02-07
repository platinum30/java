package app.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import app.core.beans.Person;

@Configuration
@ComponentScan
public class Config {
	private int nextId = 101;
	private String[] names = {"Danni","Ana","Moshe"};
	@Bean
	@Scope("singleton")
	public Person siri() {
		Person person = new Person();
		person.setId(-1);
		person.setName("siri");
		return person;

	}
	@Bean
	@Scope("prototype")
	public Person coffeeWorker() {
		Person person = new Person();
		person.setId(nextId++);
		person.setAge((int) (Math.random()*(30-18)+18));
		person.setName(names[(int) (Math.random()*names.length)]);
		return person;
	}

}
