package com.nicolas.parcial.servicios;

import com.nicolas.parcial.entidades.Autor;
import com.nicolas.parcial.entidades.Persona;
import com.nicolas.parcial.repositorios.AutorRepository;
import com.nicolas.parcial.repositorios.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorServiceImpl extends BaseServiceImpl<Autor, Long> implements AutorService{
    @Autowired
    private AutorRepository autorRepository;

    public AutorServiceImpl(BaseRepository<Autor, Long> baseRepository, AutorRepository autorRepository) {
        super(baseRepository);
        this.autorRepository = autorRepository;
    }

    @Override
    public List<Autor> search(String filtro) throws Exception {
        try {
            //List<Autor> autores = autorRepository.findByNombreContainingOrApellidoContaining(filtro, filtro);
            //List<Autor> autores = autorRepository.searchParam(filtro);
            List<Autor> autores = autorRepository.searchNativo(filtro);
            return autores;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Autor> search(String filtro, Pageable pageable) throws Exception {
        try {
            //Page<Autor> autores = autorRepository.findByNombreContainingOrApellidoContaining(filtro, filtro, pageable);
            //Page<Autor> autores = autorRepository.searchParam(filtro, pageable);
            Page<Autor> autores = autorRepository.searchNativo(filtro, pageable);
            return autores;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
