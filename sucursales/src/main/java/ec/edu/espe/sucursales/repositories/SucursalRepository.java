package ec.edu.espe.sucursales.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ec.edu.espe.sucursales.modelentities.dto.Sucursal;

@Repository
public interface SucursalRepository extends CrudRepository<Sucursal, Long> {
}

