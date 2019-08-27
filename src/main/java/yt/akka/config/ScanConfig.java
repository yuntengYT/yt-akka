package yt.akka.config;

import akka.actor.ActorSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import yt.akka.akkaproducer.SpringExtProvider;

/**
 * @author yunteng
 */
@Configuration
public class ScanConfig {
	private final ApplicationContext context;

	@Autowired
	public ScanConfig(ApplicationContext context) {
		this.context = context;
	}

	@Bean
	public ActorSystem createSystem() {
		ActorSystem system = ActorSystem.create("system");
		SpringExtProvider.getInstance().get(system).init(context);
		return system;
	}
}
