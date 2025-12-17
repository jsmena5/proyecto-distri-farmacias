package ec.edu.espe.sucursales.modelentities.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "inventario",
        uniqueConstraints = @UniqueConstraint(columnNames = {"sucursal_id", "medicamento_id"}))
public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El ID de la sucursal es obligatorio")
    @Column(name = "sucursal_id")
    private Long sucursalId;

    @NotNull(message = "El ID del medicamento es obligatorio")
    @Column(name = "medicamento_id")
    private Long medicamentoId;

    @NotNull(message = "El stock es obligatorio")
    @Min(value = 0, message = "El stock no puede ser negativo")
    private Integer stock;

    @NotNull(message = "El stock mínimo es obligatorio")
    @Min(value = 0, message = "El stock mínimo no puede ser negativo")
    private Integer stockMinimo;

    public Inventario() {}

    public Inventario(Long id, Long sucursalId, Long medicamentoId,
                      Integer stock, Integer stockMinimo) {
        this.id = id;
        this.sucursalId = sucursalId;
        this.medicamentoId = medicamentoId;
        this.stock = stock;
        this.stockMinimo = stockMinimo;
    }

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getSucursalId() { return sucursalId; }
    public void setSucursalId(Long sucursalId) { this.sucursalId = sucursalId; }

    public Long getMedicamentoId() { return medicamentoId; }
    public void setMedicamentoId(Long medicamentoId) { this.medicamentoId = medicamentoId; }

    public Integer getStock() { return stock; }
    public void setStock(Integer stock) { this.stock = stock; }

    public Integer getStockMinimo() { return stockMinimo; }
    public void setStockMinimo(Integer stockMinimo) { this.stockMinimo = stockMinimo; }
}