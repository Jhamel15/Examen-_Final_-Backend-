package com.example.demo.services;

import com.example.demo.entity.EntityNoticia;
import com.example.demo.repository.NoticiaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class NoticiaService {

    private final NoticiaRepository noticiaRepository;

    public NoticiaService(NoticiaRepository noticiaRepository) {
        this.noticiaRepository = noticiaRepository;
    }

    public List<EntityNoticia> listar() {
        return noticiaRepository.findAll();
    }

    public EntityNoticia buscarPorId(Long id) {
        return noticiaRepository.findById(id).orElse(null);
    }

    public EntityNoticia guardar(EntityNoticia noticia) {
        if (noticia.getFecha() == null) {
            noticia.setFecha(LocalDate.now());
        }

        return noticiaRepository.save(noticia);
    }

    public EntityNoticia actualizar(Long id, EntityNoticia noticia) {
        EntityNoticia existente = buscarPorId(id);

        if (existente == null) {
            return null;
        }

        existente.setTitulo(noticia.getTitulo());
        existente.setDescripcion(noticia.getDescripcion());
        existente.setFecha(noticia.getFecha());
        existente.setImagen(noticia.getImagen());

        return noticiaRepository.save(existente);
    }

    public boolean eliminar(Long id) {
        if (!noticiaRepository.existsById(id)) {
            return false;
        }

        noticiaRepository.deleteById(id);
        return true;
    }
}