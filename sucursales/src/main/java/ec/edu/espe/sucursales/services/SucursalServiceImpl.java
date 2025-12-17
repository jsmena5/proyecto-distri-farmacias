package ec.edu.espe.sucursales.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ec.edu.espe.sucursales.modelentities.dto.Sucursal;
import ec.edu.espe.sucursales.repositories.SucursalRepository;

@Service
public class SucursalServiceImpl implements SucursalService {

    private final SucursalRepository repo;

    public SucursalServiceImpl(SucursalRepository repo) {
        this.repo = repo;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Sucursal> buscarTodos() {
        return (List<Sucursal>) repo.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Sucursal> buscarPorId(Long id) {
        return repo.findById(id);
    }

    @Override
    @Transactional
    public Sucursal crear(Sucursal sucursal) {
        return repo.save(sucursal);
    }

    @Override
    @Transactional
    public Optional<Sucursal> actualizar(Long id, Sucursal sucursal) {
        return repo.findById(id).map(existente -> {
            existente.setNombre(sucursal.getNombre());
            existente.setCiudad(sucursal.getCiudad());
            existente.setDireccion(sucursal.getDireccion());
            existente.setActiva(sucursal.getActiva());
            return repo.save(existente);
        });
    }

    @Override
    @Transactional
    public void eliminarPorId(Long id) {
        repo.deleteById(id);
    }
}