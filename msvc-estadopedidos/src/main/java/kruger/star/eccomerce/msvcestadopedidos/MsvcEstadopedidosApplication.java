package kruger.star.eccomerce.msvcestadopedidos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication

public class MsvcEstadopedidosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsvcEstadopedidosApplication.class, args);
	}

}
