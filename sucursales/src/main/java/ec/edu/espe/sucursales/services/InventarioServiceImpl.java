package ec.edu.espe.sucursales.services;

import ec.edu.espe.sucursales.modelentities.dto.Inventario;
import ec.edu.espe.sucursales.repositories.InventarioRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class InventarioServiceImpl implements InventarioService {

    private final InventarioRepository repository;

    public InventarioServiceImpl(InventarioRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public Inventario crear(Inventario inventario) {
        return repository.save(inventario);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Inventario> buscarTodos() {
        return (List<Inventario>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Inventario> buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Optional<Inventario> actualizar(Long id, Inventario inventario) {
        return repository.findById(id).map(existente -> {
            existente.setStock(inventario.getStock());
            existente.setStockMinimo(inventario.getStockMinimo());
            return repository.save(existente);
        });
    }
}