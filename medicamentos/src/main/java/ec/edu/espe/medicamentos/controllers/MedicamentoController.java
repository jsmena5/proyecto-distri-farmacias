package ec.edu.espe.medicamentos.controllers;

import ec.edu.espe.medicamentos.modelentities.Medicamento;
import ec.edu.espe.medicamentos.services.MedicamentoService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/medicamentos")
@CrossOrigin(origins = "*")
public class MedicamentoController {

    @Autowired
    private MedicamentoService medicamentoService;

    // LISTAR TODOS
    @GetMapping
    public ResponseEntity<List<Medicamento>> listarMedicamentos() {
        return ResponseEntity.ok(medicamentoService.buscarTodos());
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        Optional<Medicamento> medicamento = medicamentoService.buscarPorId(id);
        return medicamento.isPresent()
                ? ResponseEntity.ok(medicamento.get())
                : ResponseEntity.notFound().build();
    }

    // CREAR MEDICAMENTO - 201
    @PostMapping
    public ResponseEntity<Medicamento> guardarMedicamento(
            @Valid @RequestBody Medicamento medicamento) {

        Medicamento nuevo = medicamentoService.crear(medicamento);
        URI location = URI.create("/api/medicamentos/" + nuevo.getId());
        return ResponseEntity.created(location).body(nuevo);
    }

    // ACTUALIZAR MEDICAMENTO
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarMedicamento(
            @PathVariable Long id,
            @Valid @RequestBody Medicamento medicamento) {

        Optional<Medicamento> actualizado =
                medicamentoService.actualizar(id, medicamento);

        return actualizado.isPresent()
                ? ResponseEntity.ok(actualizado.get())
                : ResponseEntity.notFound().build();
    }

    // ELIMINAR MEDICAMENTO
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarMedicamento(@PathVariable Long id) {

        Optional<Medicamento> medicamento =
                medicamentoService.buscarPorId(id);

        if (!medicamento.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        medicamentoService.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
