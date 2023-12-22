package com.info.streamingmusic.dto;
import com.info.streamingmusic.dto.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter @Setter
public class ListaDeReproduccionDto {
    private String id;
    @NotBlank(message = "El campo de nombre no puede ser nulo o vacio")
    private String nombre;
    @Valid
    private List<CancionDto> listaCancionesDTO;
}
