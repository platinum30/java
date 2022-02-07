package app.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import app.core.beans.Person;
import app.core.beans.cars.Engine;
import app.core.beans.cars.FamilyCar;
import app.core.beans.cars.Gear;

@Configuration
@ComponentScan
public class ConfigCar {
	private int nextId = 101;
	private String[] names = { "Danni", "Ana", "Moshe" };



	@Bean
	@Primary
	@Scope("prototype")
	public Engine standardEngine() {
		Engine engine = new Engine();
		engine.setModel("standardEngine");
		return engine;

	}
	@Bean
	@Scope("prototype")
	public Engine turboEngine() {
		Engine engine = new Engine();
		engine.setModel("turboEngine");
		return engine;

	}
	@Bean
	@Scope("prototype")
	public Gear automaticGear() {
		Gear gear = new Gear();
		gear.setModel("automaticGear");
		return gear;

	}
	@Bean
	@Scope("prototype")
	public Gear manualGear() {
		Gear gear = new Gear();
		gear.setModel("manualGear");
		return gear;

	}

}
