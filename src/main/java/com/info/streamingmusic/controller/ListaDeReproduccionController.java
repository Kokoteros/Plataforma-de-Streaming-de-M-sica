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
@RequestMapping(value = "/api/v1/listasreproduccion", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class ListaDeReproduccionController {

    private final ListaDeReproduccionService listaDeReproduccionService;

    @PostMapping
    public ResponseEntity<ListaDeReproduccionDto> crearListaDeReproduccion(@RequestBody ListaDeReproduccionDto listaDto) {
        ListaDeReproduccion nuevaLista = listaDeReproduccionService.crearListaDeReproduccion(listaDto);
        ListaDeReproduccionDto nuevaListaDto = ListaDeReproduccionMapper.toListaDeReproduccionDto(nuevaLista);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaListaDto);
    }

    @GetMapping
    public ResponseEntity<List<ListaDeReproduccionDto>> obtenerTodasLasListasDeReproduccion() {
        List<ListaDeReproduccionDto> listas = listaDeReproduccionService.obtenerTodasLasListasDeReproduccion();
        return ResponseEntity.ok(listas);
    }

    @GetMapping("/{idLista}")
    public ResponseEntity<ListaDeReproduccionDto> obtenerListaDeReproduccionPorId(@PathVariable UUID idLista) {
        ListaDeReproduccionDto lista = listaDeReproduccionService.obtenerListaDeReproduccionPorId(idLista);
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<ListaDeReproduccionDto>> obtenerListasPorUsuario(@PathVariable UUID idUsuario) {
        List<ListaDeReproduccionDto> listas = listaDeReproduccionService.obtenerListasDeReproduccionPorUsuario(idUsuario);
        return ResponseEntity.ok(listas);
    }

    @PutMapping("/{idLista}")
    public ResponseEntity<ListaDeReproduccionDto> actualizarListaDeReproduccion(@PathVariable UUID idLista, @RequestBody ListaDeReproduccionDto listaDto) {
        ListaDeReproduccion listaActualizada = listaDeReproduccionService.actualizarListaDeReproduccion(idLista, listaDto);
        ListaDeReproduccionDto listaDtoActualizada = ListaDeReproduccionMapper.toListaDeReproduccionDto(listaActualizada);
        return ResponseEntity.ok(listaDtoActualizada);
    }

    @PostMapping("/{idLista}/canciones/{idCancion}/{idUsuario}")
    public ResponseEntity<?> agregarCancionALista(@PathVariable UUID idLista, @PathVariable UUID idCancion, @PathVariable UUID idUsuario) {
        listaDeReproduccionService.agregarCancionALista(idLista, idCancion, idUsuario);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{idLista}/canciones/{idCancion}/{idUsuario}")
    public ResponseEntity<?> eliminarCancionDeLista(@PathVariable UUID idLista, @PathVariable UUID idCancion, @PathVariable UUID idUsuario) {
        listaDeReproduccionService.eliminarCancionDeLista(idLista, idCancion, idUsuario);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{idLista}")
    public ResponseEntity<Void> eliminarListaDeReproduccion(@PathVariable UUID idLista) {
        listaDeReproduccionService.eliminarListaDeReproduccion(idLista);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}