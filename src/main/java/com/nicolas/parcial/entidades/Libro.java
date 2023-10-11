package com.nicolas.parcial.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "libro")
public class Libro extends BaseEntidad {
    @NotNull
    @Column(name = "titulo")
    private String titulo;

    @NotNull
    @Column(name = "fecha")
    private int fecha;

    @NotNull
    @Column(name = "genero")
    private String genero;

    @NotNull
    @Column(name = "paginas")
    private int paginas;

    @ManyToMany(cascade = CascadeType.REFRESH)                              //Relacion ManyToMany unidireccional
    @JoinTable(
            name = "libro_autor",
            joinColumns = @JoinColumn(name = "libro_id"),
            inverseJoinColumns = @JoinColumn(name = "autor_id")
    )
    private List<Autor> autores = new ArrayList<>();
}
