package ups.edu.ec.micromariaDB.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Auto")
public class Auto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer auto_id;

    private String auto_marca;
    private String auto_modelo;
    private String auto_anio;

    // Getters and Setters


    public Integer getAuto_id() {
        return auto_id;
    }

    public void setAuto_id(Integer auto_id) {
        this.auto_id = auto_id;
    }

    public String getAuto_marca() {
        return auto_marca;
    }

    public void setAuto_marca(String auto_marca) {
        this.auto_marca = auto_marca;
    }

    public String getAuto_modelo() {
        return auto_modelo;
    }

    public void setAuto_modelo(String auto_modelo) {
        this.auto_modelo = auto_modelo;
    }

    public String getAuto_anio() {
        return auto_anio;
    }

    public void setAuto_anio(String auto_anio) {
        this.auto_anio = auto_anio;
    }
}