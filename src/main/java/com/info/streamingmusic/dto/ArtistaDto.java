package com.info.streamingmusic.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
@Getter
@Setter
public class ArtistaDto {
    private String id;
    @NotBlank(message = "El campo de nombre no puede ser nulo o vacio")
    private String nombre;
}






