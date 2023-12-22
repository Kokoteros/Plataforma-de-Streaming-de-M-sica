package com.info.streamingmusic.controller;

import com.info.streamingmusic.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping(value = "api/v1/usuarios", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
public class UsuarioController {
    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> crearUsuario(@RequestBody UsuarioDto usuarioDto) {
        Usuario nuevoUsuario = usuarioService.crearUsuario(usuarioDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoUsuario);
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<UsuarioDto> obtenerUsuarioPorId(@PathVariable UUID idUsuario) {
        UsuarioDto usuarioDto = usuarioService.obtenerUsuarioPorId(idUsuario);
        return ResponseEntity.ok(usuarioDto);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDto>> obtenerTodosLosUsuarios() {
        List<UsuarioDto> usuarios = usuarioService.obtenerTodosLosUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    @PutMapping("/{idUsuario}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable UUID idUsuario, @RequestBody UsuarioDto usuarioDto) {
        Usuario usuarioActualizado = usuarioService.actualizarUsuario(idUsuario, usuarioDto);
        return ResponseEntity.ok(usuarioActualizado);
    }

    @DeleteMapping("/{idUsuario}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable UUID idUsuario) {
        usuarioService.eliminarUsuario(idUsuario);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
}
