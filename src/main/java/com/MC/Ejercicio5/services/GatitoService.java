package com.MC.Ejercicio5.services;

import com.MC.Ejercicio5.entity.Gatito;
import com.MC.Ejercicio5.repository.GatitoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GatitoService {

    @Autowired
    GatitoRepository gatitoRepository;

    @Value("${frase.gatito}")
    private String fraseDelGatito;

    public String miGato() {
        return fraseDelGatito;
    }
    public List<Gatito> leerGatitos() {
        return gatitoRepository.findAll();
    }
    public Gatito actualizarGatito(Gatito gatitoActualizado, Long id) {
        Gatito gatito = gatitoRepository.findById(id).orElse(null);
        if (gatito != null) {
            gatito.setNombre(gatitoActualizado.getNombre());
            gatitoRepository.save(gatito);
        }
        return gatito;
    }
    public Gatito guardarGatito(Gatito gatito) {
        return gatitoRepository.save(gatito);
    }
    public Gatito eliminarGatito(Long id) {
        Gatito gatito = gatitoRepository.findById(id).orElse(null);
        if (gatito != null) {
            gatitoRepository.deleteById(id);
        }
        return gatito;
    }
    public List<Gatito> gatitoMayor(int edad){
        return gatitoRepository.findByMayorEdad(edad);
    }

}