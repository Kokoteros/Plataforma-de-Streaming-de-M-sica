package com.info.streamingmusic.service;

import com.info.streamingmusic.domain.Cancion;
import com.info.streamingmusic.dto.CancionDto;

import java.util.List;
import java.util.UUID;

public interface CancionService {

    Cancion crearCancion(CancionDto cancionDto);

    void eliminarCancion(UUID id);

    CancionDto obtenerCancionPorId(UUID id);

    Cancion actualizarCancion(UUID idCancion, CancionDto cancionDto);

    List<CancionDto> obtenerCancionesPorFiltro(String nombre, String genero, String artista);

    List<CancionDto> obtenerTodasLasCanciones();

    List<CancionDto> obtenerCancionesAleatorias();

    List<CancionDto> buscarCanciones(String titulo, String genero, String artista, String album);
}
