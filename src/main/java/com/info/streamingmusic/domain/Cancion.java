package com.info.streamingmusic.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Cancion extends PlataformaMusical{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @GenericGenerator(name = "UUID")
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int ranking;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Genero> generos = new ArrayList<>();

    @Column(nullable = false)
    private int duracion;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "cancion_artista", joinColumns = @JoinColumn(name = "cancion_id"), inverseJoinColumns = @JoinColumn(name = "artista_id"))
    private List<Artista> artistas = new ArrayList<>();

    private String album;
}
