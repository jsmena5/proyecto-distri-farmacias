package ec.edu.espe.sucursales.controllers;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ec.edu.espe.sucursales.modelentities.dto.Sucursal;
import ec.edu.espe.sucursales.services.SucursalService;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sucursales")
@CrossOrigin(origins = "*")
public class SucursalController {

    private final SucursalService service;

    public SucursalController(SucursalService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Sucursal>> listar() {
        return ResponseEntity.ok(service.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscar(@PathVariable Long id) {
        Optional<Sucursal> sucursal = service.buscarPorId(id);
        return sucursal.isPresent()
                ? ResponseEntity.ok(sucursal.get())
                : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Sucursal> crear(@Valid @RequestBody Sucursal sucursal) {
        Sucursal nueva = service.crear(sucursal);
        URI location = URI.create("/api/sucursales/" + nueva.getId());
        return ResponseEntity.created(location).body(nueva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id,
                                        @Valid @RequestBody Sucursal sucursal) {
        Optional<Sucursal> actualizada = service.actualizar(id, sucursal);
        return actualizada.isPresent()
                ? ResponseEntity.ok(actualizada.get())
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        Optional<Sucursal> sucursal = service.buscarPorId(id);
        if (!sucursal.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        service.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }
}