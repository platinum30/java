package zoo.core;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import zoo.core.beans.Bird;
import zoo.core.beans.Mammal;
import zoo.core.beans.Reptile;
import zoo.core.beans.Zone;

@Configuration
@ComponentScan
public class Config {
	@Bean
	@Scope("prototype")
	public Zone<Mammal> mammalZone() {
		Zone<Mammal> zone = new Zone<>();
		zone.setAnimals(new ArrayList<>());
		return zone;
	}

	@Bean
	@Scope("prototype")
	public Zone<Reptile> reptileZone() {
		Zone<Reptile> zone = new Zone<>();
		zone.setAnimals(new ArrayList<>());
		return zone;
	}

	@Bean
	@Scope("prototype")
	public Zone<Bird> birdZone() {
		Zone<Bird> zone = new Zone<>();
		zone.setAnimals(new ArrayList<>());
		return zone;
	}
}
