package com.info.streamingmusic.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import java.util.UUID;
import java.util.List;
import java.util.ArrayList;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Genero extends PlataformaMusical {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @GenericGenerator(name = "UUID")
    private UUID id;
    @Column(nullable = false)
    private String nombre;

    @ManyToMany(mappedBy = "generos", cascade = CascadeType.ALL)
    private List<Cancion> canciones = new ArrayList<>();
}