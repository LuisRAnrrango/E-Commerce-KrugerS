package kruger.star.eccomerce.msvcestadopedidos.services;

import kruger.star.eccomerce.msvcestadopedidos.models.entity.OrderDetails;
import kruger.star.eccomerce.msvcestadopedidos.repositories.OrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailsServiceImpl implements  OrderDetailsService {
    @Autowired
    private OrderDetailsRepository repository;

    @Override
    public List<OrderDetails> listar() {
        return repository.findAll();
    }

    @Override   public OrderDetails actualizarEstado(OrderDetails orderdetails) {
        return repository.save(orderdetails);
    }

    @Transactional

    @Override
    public String tipoEstado(OrderDetails orderDetails) {
        String estado = "";

        if (orderDetails.getStatus() == 1) {

        //    actualizarEstado(orderDetails);
            estado = "PREPARACION";

        } else if (orderDetails.getStatus() == 2) {

        //    actualizarEstado(orderDetails);
            estado = "REPARTO";
        } else if (orderDetails.getStatus() == 3) {

        //    actualizarEstado(orderDetails);
            estado = "ENTREGADO";
        } else if (orderDetails.getStatus() == 4) {

        //    actualizarEstado(orderDetails);
            estado = "ESPERANDOP";
        } else if (orderDetails.getStatus() == 5) {

        //    actualizarEstado(orderDetails);
            estado = "ERRORP";
        } else if (orderDetails.getStatus() == 6) {

        //    actualizarEstado(orderDetails);
            estado = "PAGOACEPR";
        } else if (orderDetails.getStatus() == 7) {

        //    actualizarEstado(orderDetails);
            estado = "PAGOEFE";
        } else if (orderDetails.getStatus() == 8) {

        //    actualizarEstado(orderDetails);
            estado = "PAGORETOR";
        } else if (orderDetails.getStatus() == 9) {

        //    actualizarEstado(orderDetails);
            estado = "CANCELADO";
        } else if (orderDetails.getStatus() == 10) {

        //    actualizarEstado(orderDetails);
            estado = "ENCURSO";
        } else {

          //  actualizarEstado(orderDetails);
            estado = "SERVICIO";

        }


        return estado;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<OrderDetails> porId(Long id) {
        return repository.findById(id);
    }

    @Override
    public void eliminar(Long id) {

    }
}
