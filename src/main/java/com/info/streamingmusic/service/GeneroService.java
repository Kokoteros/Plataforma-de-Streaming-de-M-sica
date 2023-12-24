package com.info.streamingmusic.service;

import com.info.streamingmusic.domain.Genero;
import com.info.streamingmusic.dto.GeneroDto;

import java.util.List;
import java.util.UUID;

public interface GeneroService {
    Genero crearGenero(GeneroDto generoDto);

    void eliminarGenero(UUID idGenero);

    Genero actualizarGenero(UUID idGenero, GeneroDto generoDto);

    GeneroDto obtenerGeneroPorId(UUID idGenero);

    List<GeneroDto> obtenerGenerosPorNombre(String nombre);

    List<GeneroDto> obtenerTodosLosGeneros();
}
