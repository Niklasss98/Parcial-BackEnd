package com.nicolas.parcial.repositorios;

import com.nicolas.parcial.entidades.Libro;
import com.nicolas.parcial.entidades.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepository extends BaseRepository<Libro, Long> {

    //Metodo de Query
    List<Libro> findByTituloContaining(String titulo);
    Page<Libro> findByTituloContaining(String titulo, Pageable pageable);

    //Anotacion JPQL parametros indexados
    @Query(value = "SELECT l FROM Libro l WHERE l.titulo LIKE %?1%")
    List<Libro> searchIndex(String filtro);
    @Query(value = "SELECT l FROM Libro l WHERE l.titulo LIKE %?1%")
    Page<Libro> searchIndex(String filtro, Pageable pageable);

    //Anotacion JPQL parametros nombrados
    @Query(value = "SELECT l FROM Libro l WHERE l.titulo LIKE %:filtro%")
    List<Libro> searchParam(@Param("filtro") String filtro);
    @Query(value = "SELECT l FROM Libro l WHERE l.titulo LIKE %:filtro%")
    Page<Libro> searchParam(@Param("filtro") String filtro, Pageable pageable);

    //Anotacion SQL Nativo
    @Query(
            value = "SELECT * FROM libro WHERE libro.titulo LIKE %:filtro%",
            nativeQuery = true
    )
    List<Libro> searchNativo(@Param("filtro") String filtro);
    @Query(
            value = "SELECT * FROM libro WHERE libro.titulo LIKE %:filtro%",
            countQuery = "SELECT count(*) FROM libro",
            nativeQuery = true
    )
    Page<Libro> searchNativo(@Param("filtro") String filtro, Pageable pageable);

}
