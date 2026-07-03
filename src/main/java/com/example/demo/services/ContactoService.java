package com.example.demo.services;

import com.example.demo.entity.EntityContacto;
import com.example.demo.repository.ContactoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ContactoService {

    private final ContactoRepository contactoRepository;

    public ContactoService(ContactoRepository contactoRepository) {
        this.contactoRepository = contactoRepository;
    }

    public List<EntityContacto> listar() {
        return contactoRepository.findAll();
    }

    public EntityContacto buscarPorId(Long id) {
        return contactoRepository.findById(id).orElse(null);
    }

    public EntityContacto guardar(EntityContacto contacto) {

        contacto.setFecha(LocalDate.now());

        return contactoRepository.save(contacto);
    }

    public EntityContacto actualizar(Long id, EntityContacto contacto) {

        EntityContacto existente = buscarPorId(id);

        if (existente == null) {
            return null;
        }

        existente.setNombre(contacto.getNombre());
        existente.setCorreo(contacto.getCorreo());
        existente.setAsunto(contacto.getAsunto());
        existente.setMensaje(contacto.getMensaje());

        return contactoRepository.save(existente);
    }

    public boolean eliminar(Long id) {

        if (!contactoRepository.existsById(id)) {
            return false;
        }

        contactoRepository.deleteById(id);

        return true;
    }
}