package com.example.demo.repository;

import com.example.demo.entity.EntityContacto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactoRepository extends JpaRepository<EntityContacto, Long> {

}