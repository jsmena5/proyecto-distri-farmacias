package ec.edu.espe.medicamentos.services;


import java.util.List;
import java.util.Optional;
import ec.edu.espe.medicamentos.modelentities.Medicamento;

public interface MedicamentoService {

    List<Medicamento> buscarTodos();

    Optional<Medicamento> buscarPorId(Long id);

    Medicamento crear(Medicamento medicamento);

    Optional<Medicamento> actualizar(Long id, Medicamento medicamento);

    void eliminarPorId(Long id);
}