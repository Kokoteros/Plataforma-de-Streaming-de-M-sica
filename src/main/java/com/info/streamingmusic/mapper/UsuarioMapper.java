package com.info.streamingmusic.mapper;

import com.info.streamingmusic.domain.Usuario;
import com.info.streamingmusic.dto.*;

import java.util.stream.Collectors;

public class UsuarioMapper {

    public static UsuarioDto toUsuarioDto(Usuario usuario) {
        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.setId(usuario.getId().toString());
        usuarioDto.setNombreUsuario(usuario.getNombreUsuario());
        usuarioDto.setNombre(usuario.getNombre());
        usuarioDto.setListasDeReproduccion(usuario.getListasDeReproduccion().stream()
                .map(lista -> new ListaDeReproduccionResumenDto(
                        lista.getId().toString(),
                        lista.getNombre(),
                        lista.getCanciones().size()))
                .collect(Collectors.toList()));
        return usuarioDto;
    }


    public static Usuario toUsuario(UsuarioDto usuarioDto) {
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario(usuarioDto.getNombreUsuario());
        usuario.setNombre(usuarioDto.getNombre());
        return usuario;
    }
}