package ec.edu.espe.sucursales.services;

import java.util.List;
import java.util.Optional;
import ec.edu.espe.sucursales.modelentities.dto.Sucursal;

public interface SucursalService {

    List<Sucursal> buscarTodos();

    Optional<Sucursal> buscarPorId(Long id);

    Sucursal crear(Sucursal sucursal);

    Optional<Sucursal> actualizar(Long id, Sucursal sucursal);

    void eliminarPorId(Long id);
}