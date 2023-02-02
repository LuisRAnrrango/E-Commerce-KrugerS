package kruger.star.eccomerce.msvcestadopedidos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsvcEstadopedidosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsvcEstadopedidosApplication.class, args);
	}

}
