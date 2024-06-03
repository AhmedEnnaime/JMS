package com.learning.jms;

import org.apache.activemq.artemis.core.config.impl.ConfigurationImpl;
import org.apache.activemq.artemis.core.server.ActiveMQServer;
import org.apache.activemq.artemis.core.server.ActiveMQServers;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JmsApplication {

	public static void main(String[] args) throws Exception {
		ActiveMQServer activeMQServer = ActiveMQServers.newActiveMQServer(
				new ConfigurationImpl().setPersistenceEnabled(true)
						.setJournalDirectory("target/data/journal")
						.setSecurityEnabled(false)
						.addAcceptorConfiguration("invm", "vm://0")
		);
		activeMQServer.start();
		SpringApplication.run(JmsApplication.class, args);
	}

}
