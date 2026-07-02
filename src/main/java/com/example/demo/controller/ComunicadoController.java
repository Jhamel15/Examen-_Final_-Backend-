package com.example.demo.controller;

import com.example.demo.entity.EntityComunicado;
import com.example.demo.services.ComunicadoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/comunicados")
public class ComunicadoController {

    private final ComunicadoService comunicadoService;

    public ComunicadoController(ComunicadoService comunicadoService) {
        this.comunicadoService = comunicadoService;
    }

    @GetMapping
    public List<EntityComunicado> listar() {
        return comunicadoService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityComunicado> buscarPorId(@PathVariable Long id) {

        EntityComunicado comunicado = comunicadoService.buscarPorId(id);

        if (comunicado == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(comunicado);
    }

    @PostMapping
    public ResponseEntity<EntityComunicado> guardar(@RequestBody EntityComunicado comunicado) {

        return ResponseEntity.ok(comunicadoService.guardar(comunicado));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityComunicado> actualizar(@PathVariable Long id,
            @RequestBody EntityComunicado comunicado) {

        EntityComunicado actualizado = comunicadoService.actualizar(id, comunicado);

        if (actualizado == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {

        boolean eliminado = comunicadoService.eliminar(id);

        if (!eliminado) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}