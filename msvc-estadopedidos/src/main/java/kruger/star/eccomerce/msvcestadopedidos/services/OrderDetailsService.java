package kruger.star.eccomerce.msvcestadopedidos.services;

import kruger.star.eccomerce.msvcestadopedidos.models.entity.OrderDetails;

import java.util.List;
import java.util.Optional;

public interface OrderDetailsService {
    List<OrderDetails> listar();
    OrderDetails actualizarEstado(OrderDetails orderdetails);

    String tipoEstado(OrderDetails orderDetails);

    Optional<OrderDetails> porId(Long id);
    void eliminar(Long id);

}
