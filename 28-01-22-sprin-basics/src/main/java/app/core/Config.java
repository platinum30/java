package app.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import app.core.beans.Person;

@Configuration
@ComponentScan
public class Config {
	@Bean
	public Person danny() {
		Person p = new Person();
		p.setAge(56);
		p.setName("Danny");
		p.setId(103);
		return p;
	}
}
