package com.MC.Ejercicio5.controllerPractica;

import com.MC.Ejercicio5.services.GatitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("Practica")
public class PracticasController {

    @Autowired
    GatitoService gatitoService;

    @GetMapping("/ejercicio1")
    public ResponseEntity<String> ejercicio1() {
        List<String> lista = Arrays.asList("Java", "Python", "C++", "JavaScript");
        System.out.println("Lista de Palabras");
        lista.forEach(s -> System.out.println(s));
        return ResponseEntity.ok("OK");
    }

    @GetMapping("/ejercicio2")
    public ResponseEntity<String> ejercicio2() {
        List<String> lista = Arrays.asList("Java", "Python", "C++", "JavaScript");
        System.out.println("Palabras 'Java' que existen en la Lista ");
        lista.stream()
                .filter(s -> s.contains("Java"))
                .forEach(System.out::println);


        System.out.println("Cuantas palabras 'Java' contiene la Lista ");
        long count = lista.stream()
                .filter(s -> s.contains("Java"))
                .count();
        System.out.println("Número de elementos que contienen 'Java': " + count);
        return ResponseEntity.ok("OK");
    }

    @GetMapping("/ejercicio3")
    public ResponseEntity<String> ejercicio3() {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> numerosPares = numeros.stream()
                .filter(s -> s % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Números pares: " + numerosPares);
        return ResponseEntity.ok("OK");
    }

    @GetMapping("/ejercicio4")
    public ResponseEntity<String> ejercicio4() {
        List<String> palabras = Arrays.asList("lunes","martes","miercoles","jueves","viernes");
        List<String> palabrasEnMayusculas = palabras.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        palabras.forEach(System.out::println);
        System.out.println("Palabras en MAYUSCULAS " + palabrasEnMayusculas);
        return ResponseEntity.ok("OK");
    }

    @GetMapping("/ejercicio5")
    public ResponseEntity<String> ejercicio5() {
        List<String> cadena = Arrays.asList("January","February","March","April","May");
        List<String> cadenaMayor3 = cadena.stream()
                .filter(s -> s.length()>3)
                .collect(Collectors.toList());
        System.out.println("Cadena con longitud superior a 3 caracteres = " + cadenaMayor3);
        return ResponseEntity.ok("OK");
    }
}



