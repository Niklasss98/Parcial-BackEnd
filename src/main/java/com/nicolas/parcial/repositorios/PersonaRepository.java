package com.nicolas.parcial.repositorios;

import com.nicolas.parcial.entidades.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends BaseRepository<Persona, Long>{

    //Metodo de Query
    List<Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido);
    Page<Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido, Pageable pageable);

    //Anotacion JPQL parametros indexados
    @Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE %?1% OR p.apellido LIKE %?1%")
    List<Persona> searchIndex(String filtro);
    @Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE %?1% OR p.apellido LIKE %?1%")
    Page<Persona> searchIndex(String filtro, Pageable pageable);

    //Anontacion JPQL parametros nombrados
    @Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE %:filtro% OR p.apellido LIKE %:filtro%")                //Habia q corregir las comillas de filtro
    List<Persona> searchParam(@Param("filtro") String filtro);
    @Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE %:filtro% OR p.apellido LIKE %:filtro%")
    Page<Persona> searchParam(@Param("filtro") String filtro, Pageable pageable);

    //Anotacion SQL Nativo
    @Query(
           value = "SELECT * FROM persona WHERE persona.nombre LIKE %:filtro% OR persona.apellido LIKE %:filtro%",
            nativeQuery = true
    )
    List<Persona> searchNativo(@Param("filtro") String filtro);
    @Query(
            value = "SELECT * FROM persona WHERE persona.nombre LIKE %:filtro% OR persona.apellido LIKE %:filtro%",
            countQuery = "SELECT count(*) FROM persona",
            nativeQuery = true
    )
    Page<Persona> searchNativo(@Param("filtro") String filtro, Pageable pageable);

}
