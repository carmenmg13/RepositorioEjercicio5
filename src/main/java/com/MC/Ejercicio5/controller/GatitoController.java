package com.MC.Ejercicio5.controller;

import com.MC.Ejercicio5.entity.Gatito;
import com.MC.Ejercicio5.services.GatitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class GatitoController {

    @Autowired
    GatitoService gatitoService;

    @GetMapping("/gatitos")
    public ResponseEntity<List<Gatito>> gatitos() {
        List<Gatito> listaGatitos = gatitoService.leerGatitos();
        return ResponseEntity.ok(listaGatitos);
    }

    @PutMapping("/actualizarGatito/{id}")
    public ResponseEntity<Gatito> actualizarGatitos(@RequestBody Gatito gatito, @PathVariable Long id) {
        Gatito gatitoActualizado = gatitoService.actualizarGatito(gatito, id);
        return ResponseEntity.ok(gatitoActualizado);
    }

    @PostMapping("/guardarGatito")
    public ResponseEntity<Gatito> guardarGatito(@RequestBody Gatito gatito) {
        Gatito gatitoGuardado = gatitoService.guardarGatito(gatito);
        return ResponseEntity.ok(gatitoGuardado);
    }

    @DeleteMapping("/eliminarGatito/{id}")
    public ResponseEntity<Gatito> eliminarGatito(@PathVariable Long id) {
        Gatito gatitoGuardado = gatitoService.eliminarGatito(id);
        return ResponseEntity.ok(gatitoGuardado);
    }

    @GetMapping("/gatitoMayor/{edad}")
    public ResponseEntity<List<Gatito>> gatitoMayor(@PathVariable int edad) {
        List<Gatito> listaGatitos = gatitoService.gatitoMayor(edad);
        return ResponseEntity.ok(listaGatitos);
    }
}