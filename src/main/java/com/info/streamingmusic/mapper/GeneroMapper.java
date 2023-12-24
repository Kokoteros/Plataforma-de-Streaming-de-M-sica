package com.info.streamingmusic.mapper;

import com.info.streamingmusic.domain.Genero;
import com.info.streamingmusic.dto.GeneroDto;

public class GeneroMapper {

    public static GeneroDto toGeneroDto(Genero genero) {
        GeneroDto generoDto = new GeneroDto();
        generoDto.setId(genero.getId().toString());
        generoDto.setNombre(genero.getNombre());
        return generoDto;
    }

    public static Genero toGenero(GeneroDto generoDto) {
        Genero genero = new Genero();
        genero.setNombre(generoDto.getNombre());
        return genero;
    }
}
