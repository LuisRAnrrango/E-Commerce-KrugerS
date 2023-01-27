package kruger.star.eccomerce.msvcnegocios.controllers;

import kruger.star.eccomerce.msvcnegocios.models.entity.Negocio;
import kruger.star.eccomerce.msvcnegocios.services.NegocioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/negocio/")
public class NegocioController {
    @Autowired
    private NegocioService service;

    @GetMapping
    public ResponseEntity<List<Negocio>> listar(){
        return  ResponseEntity.ok(service.listar());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> detalle(@PathVariable Long id){
        Optional<Negocio> o =	service.porId(id);
        if(o.isPresent()) {
            return ResponseEntity.ok(o.get());
        }
        return ResponseEntity.notFound().build();
    }


    @PostMapping("/crear")
    public ResponseEntity<?> crear(@RequestBody Negocio negocio){
        Negocio negocioDb= service.guardar(negocio);
        return ResponseEntity.status(HttpStatus.CREATED).body(negocioDb);	}

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@RequestBody Negocio negocio, @PathVariable Long id){
        Optional<Negocio> o= service.porId(id);
        if(o.isPresent()) {
            Negocio negocioDb=o.get();
            negocioDb.setNombreNeg(negocio.getNombreNeg());
            negocioDb.setRucNeg(negocio.getRucNeg());
            negocioDb.setDescripNeg(negocio.getDescripNeg());
            negocioDb.setObjtNeg(negocio.getObjtNeg());
            negocioDb.setHistoriaNeg(negocio.getHistoriaNeg());
            negocioDb.setDireccionWebNeg(negocio.getDireccionWebNeg());
            negocioDb.setDireccionNeg(negocio.getDireccionNeg());
            negocioDb.setEmailNeg(negocio.getEmailNeg());
            negocioDb.setTelefonoNeg(negocio.getTelefonoNeg());
            return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(negocioDb));

        }
        return ResponseEntity.notFound().build();


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        Optional<Negocio> o= service.porId(id);
        if(o.isPresent()) {
            service.eliminar(o.get().getId());
            return ResponseEntity.noContent().build();

        }
        return ResponseEntity.notFound().build();

    }

}
