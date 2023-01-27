package kruger.star.eccomerce.msvcnegocios.services;

import kruger.star.eccomerce.msvcnegocios.models.entity.Negocio;
import kruger.star.eccomerce.msvcnegocios.repositories.NegocioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class NegocioServiceImpl  implements NegocioService{
    @Autowired
    private NegocioRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Negocio> listar() {
        return (List<Negocio>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Negocio> porId(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Negocio guardar(Negocio negocio) {
        return repository.save(negocio);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
repository.deleteById(id);
    }
}
