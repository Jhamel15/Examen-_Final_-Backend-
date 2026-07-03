package com.example.demo.controller;

import com.example.demo.entity.EntityNoticia;
import com.example.demo.services.NoticiaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/noticias")
public class NoticiaController {

    private final NoticiaService noticiaService;

    public NoticiaController(NoticiaService noticiaService) {
        this.noticiaService = noticiaService;
    }

    @GetMapping
    public List<EntityNoticia> listar() {
        return noticiaService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityNoticia> buscarPorId(@PathVariable Long id) {
        EntityNoticia noticia = noticiaService.buscarPorId(id);

        if (noticia == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(noticia);
    }

    @PostMapping
    public ResponseEntity<EntityNoticia> guardar(@RequestBody EntityNoticia noticia) {
        return ResponseEntity.ok(noticiaService.guardar(noticia));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityNoticia> actualizar(@PathVariable Long id,
            @RequestBody EntityNoticia noticia) {
        EntityNoticia actualizada = noticiaService.actualizar(id, noticia);

        if (actualizada == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(actualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        boolean eliminado = noticiaService.eliminar(id);

        if (!eliminado) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}