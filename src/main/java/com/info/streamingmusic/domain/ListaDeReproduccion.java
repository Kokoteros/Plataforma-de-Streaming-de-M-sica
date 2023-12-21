package com.info.streamingmusic.domain;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class ListaDeReproduccion extends PlataformaMusical{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @GenericGenerator(name = "UUID")
    private UUID id;
    private String nombre;

    @ManyToOne
    private Usuario usuario;

    @ManyToMany
    @JoinTable(name = "lista_canciones", joinColumns = @JoinColumn(name = "lista_id"), inverseJoinColumns = @JoinColumn(name = "cancion_id"))
    private List<Cancion> canciones = new ArrayList<>();

    private boolean esPublica;
    private boolean repetir;
    private boolean aleatoria;
}
