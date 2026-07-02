package com.example.demo.services;

import com.example.demo.entity.EntityComunicado;
import com.example.demo.repository.ComunicadoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ComunicadoService {

    private final ComunicadoRepository comunicadoRepository;

    public ComunicadoService(ComunicadoRepository comunicadoRepository) {
        this.comunicadoRepository = comunicadoRepository;
    }

    public List<EntityComunicado> listar() {
        return comunicadoRepository.findAll();
    }

    public EntityComunicado buscarPorId(Long id) {
        return comunicadoRepository.findById(id).orElse(null);
    }

    public EntityComunicado guardar(EntityComunicado comunicado) {

        if (comunicado.getFecha() == null) {
            comunicado.setFecha(LocalDate.now());
        }

        return comunicadoRepository.save(comunicado);
    }

    public EntityComunicado actualizar(Long id, EntityComunicado comunicado) {

        EntityComunicado existente = buscarPorId(id);

        if (existente == null) {
            return null;
        }

        existente.setTitulo(comunicado.getTitulo());
        existente.setDescripcion(comunicado.getDescripcion());
        existente.setFecha(comunicado.getFecha());
        existente.setEstado(comunicado.getEstado());

        return comunicadoRepository.save(existente);
    }

    public boolean eliminar(Long id) {

        if (!comunicadoRepository.existsById(id)) {
            return false;
        }

        comunicadoRepository.deleteById(id);

        return true;
    }
}