package com.nicolas.parcial.servicios;

import com.nicolas.parcial.entidades.Libro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LibroService extends BaseService<Libro, Long> {
    List<Libro> search(String filtro) throws Exception;

    //Paginacion
    Page<Libro> search(String filtro, Pageable pageable) throws Exception;

}
