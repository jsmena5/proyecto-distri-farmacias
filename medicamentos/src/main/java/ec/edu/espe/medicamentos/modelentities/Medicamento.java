package ec.edu.espe.medicamentos.modelentities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "medicamento")
public class Medicamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 3, max = 100, message = "El nombre debe tener entre 3 y 100 caracteres")
    private String nombre;

    @NotBlank(message = "La descripción no puede estar vacía")
    @Size(min = 5, max = 255, message = "La descripción debe tener entre 5 y 255 caracteres")
    private String descripcion;

    @NotNull(message = "El precio base es obligatorio")
    @Positive(message = "El precio debe ser mayor a 0")
    private Double precioBase;

    @NotBlank(message = "El laboratorio no puede estar vacío")
    private String laboratorio;

    @NotNull(message = "Debe indicar si requiere receta")
    private Boolean requiereReceta;

    // Constructor vacío
    public Medicamento() {}

    // Constructor completo
    public Medicamento(Long id, String nombre, String descripcion,
                       Double precioBase, String laboratorio, Boolean requiereReceta) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioBase = precioBase;
        this.laboratorio = laboratorio;
        this.requiereReceta = requiereReceta;
    }

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public Double getPrecioBase() { return precioBase; }
    public void setPrecioBase(Double precioBase) { this.precioBase = precioBase; }

    public String getLaboratorio() { return laboratorio; }
    public void setLaboratorio(String laboratorio) { this.laboratorio = laboratorio; }

    public Boolean getRequiereReceta() { return requiereReceta; }
    public void setRequiereReceta(Boolean requiereReceta) { this.requiereReceta = requiereReceta; }
}
