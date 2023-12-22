package com.info.streamingmusic.controller;

import com.info.streamingmusic.domain.Artista;
import com.info.streamingmusic.service.ArtistaService;
import com.info.streamingmusic.dto.ArtistaDto;
import com.info.streamingmusic.mapper.ArtistaMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1/artistas", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class ArtistaController {

    private final ArtistaService artistaService;

    @GetMapping
    public ResponseEntity<List<ArtistaDto>> obtenerTodosLosArtistas() {
        List<ArtistaDto> artistas = artistaService.obtenerTodosLosArtistas();
        return ResponseEntity.ok(artistas);
    }
    @GetMapping("/{idArtista}")
    public ResponseEntity<ArtistaDto> obtenerArtistaPorId(@PathVariable UUID idArtista) {
        ArtistaDto artistaDto = artistaService.obtenerArtistaPorId(idArtista);
        return ResponseEntity.ok(artistaDto);
    }

    @PutMapping("/{idArtista}")
    public ResponseEntity<?> actualizarArtista(@PathVariable UUID idArtista, @RequestBody ArtistaDto artistaDto) {
        Artista artistaActualizado = artistaService.actualizarArtista(idArtista, artistaDto);
        ArtistaDto artistaDtoActualizado = ArtistaMapper.toArtistaDto(artistaActualizado);
        return ResponseEntity.ok(artistaDtoActualizado);
    }

    @DeleteMapping("/{idArtista}")
    public ResponseEntity<?> eliminarArtista(@PathVariable UUID idArtista) {
        artistaService.eliminarArtista(idArtista);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
