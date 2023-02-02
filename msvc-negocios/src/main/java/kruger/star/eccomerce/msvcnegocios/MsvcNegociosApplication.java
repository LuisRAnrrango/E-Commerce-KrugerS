package kruger.star.eccomerce.msvcnegocios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class MsvcNegociosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsvcNegociosApplication.class, args);
	}

}
