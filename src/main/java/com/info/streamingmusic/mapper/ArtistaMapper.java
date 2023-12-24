package com.info.streamingmusic.mapper;

import com.info.streamingmusic.domain.Artista;
import com.info.streamingmusic.dto.ArtistaDto;

public class ArtistaMapper {

    public static ArtistaDto toArtistaDto(Artista artista) {
        ArtistaDto artistaDto = new ArtistaDto();
        artistaDto.setId(artista.getId().toString());
        artistaDto.setNombre(artista.getNombre());
        return artistaDto;
    }

    public static Artista toArtista(ArtistaDto artistaDto) {
        Artista artista = new Artista();
        artista.setNombre(artistaDto.getNombre());
        return artista;
    }
}
