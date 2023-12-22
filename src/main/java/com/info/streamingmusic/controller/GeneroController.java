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
@RequestMapping(value = "/api/v1/generos", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class GeneroController {

    private final GeneroService generoService;

    @PostMapping
    public ResponseEntity<GeneroDto> crearGenero(@RequestBody GeneroDto generoDto) {
        Genero nuevoGenero = generoService.crearGenero(generoDto);
        GeneroDto nuevoGeneroDto = GeneroMapper.toGeneroDto(nuevoGenero);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoGeneroDto);
    }


    @GetMapping
    public ResponseEntity<List<GeneroDto>> obtenerTodosLosGeneros() {
        List<GeneroDto> generos = generoService.obtenerTodosLosGeneros();
        return ResponseEntity.ok(generos);
    }

    @GetMapping("/{idGenero}")
    public ResponseEntity<GeneroDto> obtenerGeneroPorId(@PathVariable UUID idGenero) {
        GeneroDto genero = generoService.obtenerGeneroPorId(idGenero);
        return ResponseEntity.ok(genero);
    }

    @PutMapping("/{idGenero}")
    public ResponseEntity<GeneroDto> actualizarGenero(@PathVariable UUID idGenero, @RequestBody GeneroDto generoDto) {
        Genero generoActualizado = generoService.actualizarGenero(idGenero, generoDto);
        GeneroDto generoDtoActualizado = GeneroMapper.toGeneroDto(generoActualizado);
        return ResponseEntity.ok(generoDtoActualizado);
    }


    @DeleteMapping("/{idGenero}")
    public ResponseEntity<Void> eliminarGenero(@PathVariable UUID idGenero) {
        generoService.eliminarGenero(idGenero);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}