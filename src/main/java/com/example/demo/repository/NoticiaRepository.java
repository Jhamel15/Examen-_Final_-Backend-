package com.example.demo.repository;

import com.example.demo.entity.EntityNoticia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticiaRepository extends JpaRepository<EntityNoticia, Long> {
}