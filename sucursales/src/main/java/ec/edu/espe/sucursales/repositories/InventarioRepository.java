package ec.edu.espe.sucursales.repositories;

import org.springframework.data.repository.CrudRepository;
import ec.edu.espe.sucursales.modelentities.dto.Inventario;

import java.util.Optional;

public interface InventarioRepository extends CrudRepository<Inventario, Long> {

    Optional<Inventario> findBySucursalIdAndMedicamentoId(Long sucursalId, Long medicamentoId);
}