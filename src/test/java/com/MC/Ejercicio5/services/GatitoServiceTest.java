package com.MC.Ejercicio5.services;

import com.MC.Ejercicio5.entity.Gatito;
import com.MC.Ejercicio5.repository.GatitoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class GatitoServiceTest {

    @InjectMocks
    private GatitoService gatitoService;

    @Mock
    private GatitoRepository gatitoRepository;

    @Test
    public void testLeerGatitos() {
        // Creamos datos de ejemplos
        List<Gatito> gatitos = new ArrayList<>();
        gatitos.add(new Gatito());
        gatitos.add(new Gatito());

        // Mockeamos. Fingimos que cuando se llama a un metodo nos devuelve lo que queremos
        when(gatitoRepository.findAll()).thenReturn(gatitos);

        // Realizamos la prueba
        List<Gatito> resultado = gatitoService.leerGatitos();

        // Verificamos los datos obtenidos
        assertEquals(2, resultado.size());
    }
    
    @Test
    public void testActualizarGatito() {
        // Creamos datos de ejemplos
        Long id = 1L;
        Gatito gatitoActualizado = new Gatito();
        gatitoActualizado.setNombre("NuevoNombre");

        Gatito gatitoExistente = new Gatito();
        gatitoExistente.setId(id);

        // Mockeamos. Fingimos que cuando se llama a un metodo nos devuelve lo que queremos
        when(gatitoRepository.findById(id)).thenReturn(java.util.Optional.of(gatitoExistente));

        // Realizamos la prueba
        Gatito resultado = gatitoService.actualizarGatito(gatitoActualizado, id);

        // Verificamos los datos obtenidos
        assertEquals("NuevoNombre", resultado.getNombre());
    }
    
    @Test
    public void testEliminarGatito() {
        Long id = 1L;
        Gatito gatitoExistente = new Gatito();
        gatitoExistente.setId(id);

        when(gatitoRepository.findById(id)).thenReturn(java.util.Optional.of(gatitoExistente));

        Gatito resultado = gatitoService.eliminarGatito(id);

        // Verifica que se elimine el gatito correctamente
        verify(gatitoRepository, times(1)).deleteById(id);

        // Verifica que el resultado sea el mismo gatito que se eliminó
        assertEquals(id, resultado.getId());
    }

}
