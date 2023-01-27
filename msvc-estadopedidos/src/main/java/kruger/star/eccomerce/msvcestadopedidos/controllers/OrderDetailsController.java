package kruger.star.eccomerce.msvcestadopedidos.controllers;

import kruger.star.eccomerce.msvcestadopedidos.models.entity.OrderDetails;
import kruger.star.eccomerce.msvcestadopedidos.services.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orderdetail/")
public class OrderDetailsController {
    @Autowired
    private OrderDetailsService service;

    @GetMapping
    public ResponseEntity<List<OrderDetails>> listar(){
        return  ResponseEntity.ok(service.listar());
    }
    @PutMapping("cambio-estado/{id}")
    public ResponseEntity<?> editar(@RequestBody OrderDetails orderDetails, @PathVariable Long id){
        Optional<OrderDetails> o= service.porId(id);
        String mensajeResult= service.tipoEstado(orderDetails);
        if(o.isPresent()) {
            if(mensajeResult.equals("PREPARACION")){
                updateOrderDetails(o,orderDetails);
          return      ResponseEntity.badRequest()
                        .body(Collections
                                .singletonMap("mensaje","Su pedido esta en Preparación para el envio"));
            }

            else if(mensajeResult.equals("REPARTO")){
                updateOrderDetails(o,orderDetails);
       return     ResponseEntity.badRequest()
                    .body(Collections
                            .singletonMap("mensaje","Su pedido esta en proceso de Repartición"));

        }  else if(mensajeResult.equals("ENTREGADO")){
                updateOrderDetails(o,orderDetails);
       return     ResponseEntity.badRequest()
                    .body(Collections
                            .singletonMap("mensaje","Su pedido ha sido entregado"));

        }  else if(mensajeResult.equals("ESPERANDOP")){
                updateOrderDetails(o,orderDetails);
       return     ResponseEntity.badRequest()
                    .body(Collections
                            .singletonMap("mensaje","Su pedido esta esperando Pago"));

        }  else if(mensajeResult.equals("ERRORP")){
                updateOrderDetails(o,orderDetails);
       return     ResponseEntity.badRequest()
                    .body(Collections
                            .singletonMap("mensaje","Error en Pago"));

        }  else if(mensajeResult.equals("PAGOACEPR")){
                updateOrderDetails(o,orderDetails);
       return     ResponseEntity.badRequest()
                    .body(Collections
                            .singletonMap("mensaje","Pago Aceptado Remotamente"));

        }  else if(mensajeResult.equals("PAGOEFE")){
                updateOrderDetails(o,orderDetails);
       return     ResponseEntity.badRequest()
                    .body(Collections
                            .singletonMap("mensaje","Pago Efectuado"));

        }  else if(mensajeResult.equals("PAGORETOR")){
                updateOrderDetails(o,orderDetails);
       return     ResponseEntity.badRequest()
                    .body(Collections
                            .singletonMap("mensaje","Pago Retornado"));

        }  else if(mensajeResult.equals("CANCELADO")){
                updateOrderDetails(o,orderDetails);
       return     ResponseEntity.badRequest()
                    .body(Collections
                            .singletonMap("mensaje","Pedido Cancelado"));

        }  else if(mensajeResult.equals("ENCURSO")){
                updateOrderDetails(o,orderDetails);
       return     ResponseEntity.badRequest()
                    .body(Collections
                            .singletonMap("mensaje","Pedido en Curso"));

        }

            else {
            OrderDetails orderDetailDb=o.get();
            orderDetailDb.setStatus(orderDetails.getStatus());
            service.actualizarEstado(orderDetailDb);
    return    ResponseEntity.badRequest()
                .body(Collections
                        .singletonMap("mensaje","Servicio"));

    }
        }


return    ResponseEntity.badRequest()
        .body(Collections
        .singletonMap("mensaje","pedido No existe"));


        }

public  String  updateOrderDetails(Optional<OrderDetails> o, OrderDetails orderDetails){
        String result="";
    OrderDetails orderDetailDb=o.get();
    orderDetailDb.setStatus(orderDetails.getStatus());
    service.actualizarEstado(orderDetailDb);
        return result;
}


}
