package kruger.star.eccomerce.msvcestadopedidos.repositories;

import kruger.star.eccomerce.msvcestadopedidos.models.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails,Long> {
}
