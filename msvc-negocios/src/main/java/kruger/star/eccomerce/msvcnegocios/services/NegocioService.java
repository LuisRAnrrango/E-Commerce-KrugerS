package kruger.star.eccomerce.msvcnegocios.services;


import kruger.star.eccomerce.msvcnegocios.models.entity.Negocio;

import java.util.List;
import java.util.Optional;

public interface NegocioService {
    List<Negocio> listar();
    Optional<Negocio> porId(Long id);
    Negocio guardar(Negocio negocio);
    void eliminar(Long id);
}
