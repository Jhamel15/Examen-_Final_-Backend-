package com.example.demo.repository;

import com.example.demo.entity.EntityUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<EntityUsuario, Long> {
    EntityUsuario findByNombreUsuarioAndPasswordAndActivoTrue(String nombreUsuario, String password);
}