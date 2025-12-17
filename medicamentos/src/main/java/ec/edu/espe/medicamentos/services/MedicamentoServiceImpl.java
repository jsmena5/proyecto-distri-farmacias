package ec.edu.espe.medicamentos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ec.edu.espe.medicamentos.modelentities.Medicamento;
import ec.edu.espe.medicamentos.repositories.MedicamentoRepository;

@Service
public class MedicamentoServiceImpl implements MedicamentoService {

    @Autowired
    private MedicamentoRepository medicamentoRepo;

    @Override
    @Transactional(readOnly = true)
    public List<Medicamento> buscarTodos() {
        return (List<Medicamento>) medicamentoRepo.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Medicamento> buscarPorId(Long id) {
        return medicamentoRepo.findById(id);
    }

    @Override
    @Transactional
    public Medicamento crear(Medicamento medicamento) {
        return medicamentoRepo.save(medicamento);
    }

    @Override
    @Transactional
    public Optional<Medicamento> actualizar(Long id, Medicamento medicamento) {
        return medicamentoRepo.findById(id).map(existente -> {
            existente.setNombre(medicamento.getNombre());
            existente.setDescripcion(medicamento.getDescripcion());
            existente.setPrecioBase(medicamento.getPrecioBase());
            existente.setLaboratorio(medicamento.getLaboratorio());
            existente.setRequiereReceta(medicamento.getRequiereReceta());
            return medicamentoRepo.save(existente);
        });
    }

    @Override
    @Transactional
    public void eliminarPorId(Long id) {
        medicamentoRepo.deleteById(id);
    }
}