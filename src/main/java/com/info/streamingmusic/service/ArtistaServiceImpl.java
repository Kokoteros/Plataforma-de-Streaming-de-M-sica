package com.info.streamingmusic.service;

import com.info.streamingmusic.domain.Artista;
import com.info.streamingmusic.repository.ArtistaRepository;
import com.info.streamingmusic.dto.ArtistaDto;
import com.info.streamingmusic.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ArtistaServiceImpl implements ArtistaService {

    private final ArtistaRepository artistaRepository;

    @Override
    public Artista crearArtista(ArtistaDto artistaDto) {
        Artista artista = ArtistaMapper.toArtista(artistaDto);
        return artistaRepository.save(artista);
    }

    @Override
    public ArtistaDto obtenerArtistaPorId(UUID id) {
        Artista artista = artistaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Artista", "ID", id.toString()));
        return ArtistaMapper.toArtistaDto(artista);
    }

    @Override
    public boolean eliminarArtista(UUID idArtista) {
        if (!artistaRepository.existsById(idArtista)) {
            return false;
        }
        artistaRepository.deleteById(idArtista);
        return true;
    }


    @Override
    public Artista actualizarArtista(UUID idArtista, ArtistaDto artistaDto) {
        Artista artistaExistente = artistaRepository.findById(idArtista)
                .orElseThrow(() -> new NotFoundException("Artista", "ID", idArtista.toString()));

        if (artistaDto.getNombre() != null && !artistaDto.getNombre().isEmpty()) {
            artistaExistente.setNombre(artistaDto.getNombre());
        }

        return artistaRepository.save(artistaExistente);
    }

    @Override
    public List<ArtistaDto> obtenerArtistasPorNombre(String nombre) {
        List<Artista> artistas = artistaRepository.findByNombreContaining(nombre);
        return artistas.stream()
                .map(ArtistaMapper::toArtistaDto)
                .collect(Collectors.toList());
    }
    @Override
    public List<ArtistaDto> obtenerTodosLosArtistas() {
        List<Artista> artistas = artistaRepository.findAll();
        return artistas.stream()
                .map(ArtistaMapper::toArtistaDto)
                .collect(Collectors.toList());
    }
}
