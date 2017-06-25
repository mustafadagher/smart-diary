package ai.hachathon.smartdiary;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.net.InetSocketAddress;
import java.net.UnknownHostException;

@SpringBootApplication
public class SmartDiaryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartDiaryApplication.class, args);
	}

	@Bean
	public Client client() throws UnknownHostException {
		Settings settings = Settings.settingsBuilder()
				.put("cluster.name", "elasticsearch_mustafadagher").build();
		return TransportClient.builder()
				.settings(settings)
				.build()
				.addTransportAddress(new InetSocketTransportAddress(new InetSocketAddress("127.0.0.1", 9200)));
	}
}
