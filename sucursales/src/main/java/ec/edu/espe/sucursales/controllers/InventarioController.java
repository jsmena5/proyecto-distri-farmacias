package ec.edu.espe.sucursales.controllers;

import ec.edu.espe.sucursales.clientes.MedicamentoClienteRest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ec.edu.espe.sucursales.modelentities.dto.Inventario;
import ec.edu.espe.sucursales.modelentities.dto.MedicamentoDTO;
import ec.edu.espe.sucursales.services.InventarioService;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/inventarios")
@CrossOrigin(origins = "*")
public class InventarioController {

    private final InventarioService service;
    private final MedicamentoClienteRest medicamentoCliente;

    public InventarioController(
            InventarioService service,
            MedicamentoClienteRest medicamentoCliente) {
        this.service = service;
        this.medicamentoCliente = medicamentoCliente;
    }

    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody Inventario inventario) {

        // 🔍 Validar medicamento vía Feign
        try {
            MedicamentoDTO medicamento =
                    medicamentoCliente.buscarPorId(inventario.getMedicamentoId());

            if (medicamento == null) {
                return ResponseEntity.badRequest()
                        .body("El medicamento no existe");
            }

        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body("Error: medicamento no encontrado o servicio no disponible");
        }

        Inventario nuevo = service.crear(inventario);
        URI location = URI.create("/api/inventarios/" + nuevo.getId());
        return ResponseEntity.created(location).body(nuevo);
    }

    @GetMapping
    public ResponseEntity<List<Inventario>> listar() {
        return ResponseEntity.ok(service.buscarTodos());
    }
}