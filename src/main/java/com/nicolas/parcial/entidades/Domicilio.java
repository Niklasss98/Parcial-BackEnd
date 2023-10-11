package com.nicolas.parcial.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "domicilio")
public class Domicilio extends BaseEntidad {

    @NotNull
    @Column(name = "calle")
    private String calle;

    @NotNull
    @Column(name = "numero")
    private int numero;

    @ManyToOne(optional = false)                    //Relacion ManyToOne unidireccional
    @JoinColumn(name = "id_localidad")
    private Localidad localidad;
}