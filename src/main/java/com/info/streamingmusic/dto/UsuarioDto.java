package com.info.streamingmusic.dto;

import com.info.streamingmusic.dto.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
@Getter @Setter
public class UsuarioDto {
    private String id;
    @NotBlank(message = "El campo de usuario no puede ser nulo o vacio")
    private String nombre;
    @NotBlank(message = "El campo de nombre de Usuario no puede ser nulo o vacio")
    private String nombreUsuario;
    private List<ListaDeReproduccionDto> listasdDeReproduccionDto;
}
