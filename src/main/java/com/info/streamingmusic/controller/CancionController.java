package com.info.streamingmusic.controller;

import com.info.streamingmusic.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1/canciones", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class CancionController {

    private final CancionService cancionService;

    @PostMapping
    public ResponseEntity<CancionDto> crearCancion(@RequestBody CancionDto cancionDto) {
        Cancion nuevaCancion = cancionService.crearCancion(cancionDto);
        CancionDto nuevaCancionDto = CancionMapper.toCancionDto(nuevaCancion);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaCancionDto);
    }

    @GetMapping
    public ResponseEntity<List<CancionDto>> obtenerTodasLasCanciones() {
        List<CancionDto> canciones = cancionService.obtenerTodasLasCanciones();
        return ResponseEntity.ok(canciones);
    }

    @GetMapping("/{idCancion}")
    public ResponseEntity<CancionDto> obtenerCancionPorId(@PathVariable UUID idCancion) {
        CancionDto cancion = cancionService.obtenerCancionPorId(idCancion);
        return ResponseEntity.ok(cancion);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<CancionDto>> buscarCanciones(
            @RequestParam(required = false) String titulo,
            @RequestParam(required = false) String genero,
            @RequestParam(required = false) String artista,
            @RequestParam(required = false) String album) {

        List<CancionDto> resultados = cancionService.buscarCanciones(titulo, genero, artista, album);
        return ResponseEntity.ok(resultados);
    }

    @GetMapping("/aleatorias")
    public ResponseEntity<List<CancionDto>> obtenerCancionesAleatorias() {
        List<CancionDto> cancionesAleatorias = cancionService.obtenerCancionesAleatorias();
        return ResponseEntity.ok(cancionesAleatorias);
    }

    @PutMapping("/{idCancion}")
    public ResponseEntity<CancionDto> actualizarCancion(@PathVariable UUID idCancion, @RequestBody CancionDto cancionDto) {
        Cancion cancionActualizada = cancionService.actualizarCancion(idCancion, cancionDto);
        CancionDto cancionDtoActualizada = CancionMapper.toCancionDto(cancionActualizada);
        return ResponseEntity.ok(cancionDtoActualizada);
    }


    @DeleteMapping("/{idCancion}")
    public ResponseEntity<Void> eliminarCancion(@PathVariable UUID idCancion) {
        cancionService.eliminarCancion(idCancion);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
