package com.info.streamingmusic.dto;

import com.info.streamingmusic.dto.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter

public class CancionDto {
    private String id;
    @NotBlank(message = "El campo de nombre no puede ser nulo o vacio")
    private String nombre;
    @NotNull(message = "El campo de ranking no puede ser nulo")
    @PositiveOrZero(message = "El campo de ranking debe ser mayor o igual a 0")
    @Max(value = 10)
    private int ranking;
    @NotNull(message = "El campo de duración no puede ser nulo")
    @Positive(message = "El campo de duración debe ser mayor a 0")
    private float duracion;
    @Valid
    @NotNull(message = "El campo de artista no puede estar vacio")
    private ArtistaDto artistaDTO;
    @NotBlank(message = "El campo de álbum no puede ser nulo o vacio")
    private String album;
    @Valid
    private List<GeneroDto> generosDto = new ArrayList<>();
}
