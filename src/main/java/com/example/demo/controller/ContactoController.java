package com.example.demo.controller;

import com.example.demo.entity.EntityContacto;
import com.example.demo.services.ContactoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/contactos")
public class ContactoController {

    private final ContactoService contactoService;

    public ContactoController(ContactoService contactoService) {
        this.contactoService = contactoService;
    }

    @GetMapping
    public List<EntityContacto> listar() {
        return contactoService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityContacto> buscarPorId(@PathVariable Long id) {

        EntityContacto contacto = contactoService.buscarPorId(id);

        if (contacto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(contacto);
    }

    @PostMapping
    public ResponseEntity<EntityContacto> guardar(@RequestBody EntityContacto contacto) {

        return ResponseEntity.ok(contactoService.guardar(contacto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityContacto> actualizar(@PathVariable Long id,
            @RequestBody EntityContacto contacto) {

        EntityContacto actualizado = contactoService.actualizar(id, contacto);

        if (actualizado == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {

        boolean eliminado = contactoService.eliminar(id);

        if (!eliminado) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}