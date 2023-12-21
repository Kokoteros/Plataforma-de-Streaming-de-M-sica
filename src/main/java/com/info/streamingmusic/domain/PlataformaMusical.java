package com.info.streamingmusic.domain;

import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public abstract class PlataformaMusical {
    private LocalDateTime creadoEn;
    private String creadoPor;
    private LocalDateTime actualizadoEn;
    private String actualizadoPor;
}
