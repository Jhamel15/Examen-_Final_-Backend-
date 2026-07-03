package com.example.demo.services;

import com.example.demo.entity.EntityUsuario;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<EntityUsuario> listar() {
        return usuarioRepository.findAll();
    }

    public EntityUsuario buscarPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public EntityUsuario guardar(EntityUsuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public EntityUsuario actualizar(Long id, EntityUsuario usuario) {
        EntityUsuario existente = buscarPorId(id);

        if (existente == null) {
            return null;
        }

        existente.setNombreUsuario(usuario.getNombreUsuario());
        existente.setPassword(usuario.getPassword());
        existente.setRol(usuario.getRol());
        existente.setActivo(usuario.isActivo());

        return usuarioRepository.save(existente);
    }

    public boolean eliminar(Long id) {
        if (!usuarioRepository.existsById(id)) {
            return false;
        }

        usuarioRepository.deleteById(id);
        return true;
    }

    public EntityUsuario login(String nombreUsuario, String password) {
        return usuarioRepository.findByNombreUsuarioAndPasswordAndActivoTrue(nombreUsuario, password);
    }
}