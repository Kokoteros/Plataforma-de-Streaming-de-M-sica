package com.info.streamingmusic.mapper;

import com.info.streamingmusic.domain.ListaDeReproduccion;
import com.info.streamingmusic.dto.ListaDeReproduccionDto;

import java.util.stream.Collectors;

public class ListaDeReproduccionMapper {

    public static ListaDeReproduccionDto toListaDeReproduccionDto(ListaDeReproduccion lista) {
        ListaDeReproduccionDto listaDto = new ListaDeReproduccionDto();
        listaDto.setId(lista.getId().toString());
        listaDto.setNombre(lista.getNombre());
        listaDto.setUsuarioId(lista.getUsuario().getId().toString());
        listaDto.setCancionesIds(lista.getCanciones().stream()
                .map(cancion -> cancion.getId().toString())
                .collect(Collectors.toList()));
        listaDto.setEsPublica(lista.isEsPublica());
        listaDto.setRepetir(lista.isRepetir());
        listaDto.setAleatoria(lista.isAleatoria());
        return listaDto;
    }

    public static ListaDeReproduccion toListaDeReproduccion(ListaDeReproduccionDto listaDto) {
        ListaDeReproduccion lista = new ListaDeReproduccion();
        lista.setNombre(listaDto.getNombre());
        return lista;
    }
}