package com.grupo3.grpc.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Auto")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Auto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer autoId;

    private String autoMarca;
    private String autoModelo;
    private String autoAnio;
}
