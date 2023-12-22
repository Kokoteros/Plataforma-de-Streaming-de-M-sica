package com.info.streamingmusic.service;

import com.info.streamingmusic.domain.Artista;
import com.info.streamingmusic.dto.ArtistaDto
import java.util.List;
import java.util.UUID;

public interface ArtistaService {
    Artista crearArtista(ArtistaDto artistaDto);

    boolean eliminarArtista(UUID idArtista);

    Artista actualizarArtista(UUID idArtista, ArtistaDto artistaDto);

    ArtistaDto obtenerArtistaPorId(UUID idArtista);

    List<ArtistaDto> obtenerArtistasPorNombre(String nombre);

    List<ArtistaDto> obtenerTodosLosArtistas();
}