package com.info.streamingmusic.service;

import com.info.streamingmusic.domain.Usuario;
import com.info.streamingmusic.mapper.UsuarioMapper;
import com.info.streamingmusic.dto.UsuarioDto;
import com.info.streamingmusic.service.UsuarioService;
import com.info.streamingmusic.repository.UsuarioRepository;
import com.info.streamingmusic.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public Usuario crearUsuario(UsuarioDto usuarioDto) {
        Usuario usuario = UsuarioMapper.toUsuario(usuarioDto);
        return usuarioRepository.save(usuario);
    }

    @Override
    public UsuarioDto obtenerUsuarioPorId(UUID id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Usuario", "ID", id.toString()));
        return UsuarioMapper.toUsuarioDto(usuario);
    }

    @Override
    public boolean eliminarUsuario(UUID idUsuario) {
        if (!usuarioRepository.existsById(idUsuario)) {
            return false;
        }
        usuarioRepository.deleteById(idUsuario);
        return true;
    }

    @Override
    public Usuario actualizarUsuario(UUID idUsuario, UsuarioDto usuarioDto) {
        Usuario usuarioExistente = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new NotFoundException("Usuario", "ID", idUsuario.toString()));


        return usuarioRepository.save(usuarioExistente);
    }

    @Override
    public List<UsuarioDto> obtenerTodosLosUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream().map(UsuarioMapper::toUsuarioDto).collect(Collectors.toList());
    }

}
