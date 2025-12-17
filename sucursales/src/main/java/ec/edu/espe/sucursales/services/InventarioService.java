package ec.edu.espe.sucursales.services;

import ec.edu.espe.sucursales.modelentities.dto.Inventario;

import java.util.List;
import java.util.Optional;

public interface InventarioService {

    Inventario crear(Inventario inventario);

    List<Inventario> buscarTodos();

    Optional<Inventario> buscarPorId(Long id);

    Optional<Inventario> actualizar(Long id, Inventario inventario);
}
