package com.info.streamingmusic.mapper;

import com.info.streamingmusic.domain.Cancion;
import com.info.streamingmusic.dto.CancionDto;

public class CancionMapper {

    public static CancionDto toCancionDto(Cancion cancion) {
        CancionDto cancionDto = new CancionDto();
        cancionDto.setId(cancion.getId().toString());
        cancionDto.setNombre(cancion.getNombre());
        cancionDto.setDuracion(cancion.getDuracion());
        cancionDto.setRanking(cancion.getRanking());
        cancionDto.setAlbum(cancion.getAlbum());
        return cancionDto;
    }

    public static Cancion toCancion(CancionDto cancionDto) {
        Cancion cancion = new Cancion();
        cancion.setNombre(cancionDto.getNombre());
        cancion.setDuracion(cancionDto.getDuracion());
        cancion.setRanking(cancionDto.getRanking());
        cancion.setAlbum(cancionDto.getAlbum());
        return cancion;
    }
}