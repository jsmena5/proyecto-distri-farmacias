package ec.edu.espe.sucursales.clientes;

import ec.edu.espe.sucursales.modelentities.dto.MedicamentoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(
        name = "medicamentos",
        url = "http://host.docker.internal:8091/api/medicamentos"
)
public interface MedicamentoClienteRest {

    @GetMapping("/{id}")
    MedicamentoDTO buscarPorId(@PathVariable("id") Long id);
}