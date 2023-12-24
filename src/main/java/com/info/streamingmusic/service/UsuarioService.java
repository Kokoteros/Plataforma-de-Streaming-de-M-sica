package com.info.streamingmusic.service;

import com.info.streamingmusic.domain.Usuario;
import com.info.streamingmusic.dto.UsuarioDto;

import java.util.List;
import java.util.UUID;

public interface UsuarioService {
    Usuario crearUsuario(UsuarioDto usuarioDto);

    boolean eliminarUsuario(UUID idUsuario);

    Usuario actualizarUsuario(UUID idUsuario, UsuarioDto usuarioDto);

    UsuarioDto obtenerUsuarioPorId(UUID idUsuario);

    List<UsuarioDto> obtenerTodosLosUsuarios();
}
