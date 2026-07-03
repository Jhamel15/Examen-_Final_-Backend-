package com.example.demo.repository;

import com.example.demo.entity.EntityComunicado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComunicadoRepository extends JpaRepository<EntityComunicado, Long> {

}