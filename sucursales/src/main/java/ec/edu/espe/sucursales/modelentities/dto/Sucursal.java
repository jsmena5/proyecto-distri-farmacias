package ec.edu.espe.sucursales.modelentities.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "sucursal")
public class Sucursal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre de la sucursal es obligatorio")
    @Size(min = 3, max = 100, message = "El nombre debe tener entre 3 y 100 caracteres")
    private String nombre;

    @NotBlank(message = "La ciudad es obligatoria")
    @Size(min = 3, max = 50)
    private String ciudad;

    @NotBlank(message = "La dirección es obligatoria")
    @Size(min = 5, max = 150)
    private String direccion;

    @NotNull(message = "El estado es obligatorio")
    private Boolean activa;

    public Sucursal() {}

    public Sucursal(Long id, String nombre, String ciudad, String direccion, Boolean activa) {
        this.id = id;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.activa = activa;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public Boolean getActiva() { return activa; }
    public void setActiva(Boolean activa) { this.activa = activa; }
}