package ec.edu.espe.medicamentos.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ec.edu.espe.medicamentos.modelentities.Medicamento;

@Repository
@Transactional
public interface MedicamentoRepository extends CrudRepository<Medicamento, Long> {
}