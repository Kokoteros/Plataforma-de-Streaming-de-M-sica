package com.info.streamingmusic.service;

import com.info.streamingmusic.domain.Cancion;
import com.info.streamingmusic.mapper.CancionMapper;
import com.info.streamingmusic.dto.CancionDto;
import com.info.streamingmusic.service.CancionService;
import com.info.streamingmusic.repository.CancionRepository;
import com.info.streamingmusic.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CancionServiceImpl implements CancionService {

    private final CancionRepository cancionRepository;

    @Override
    public Cancion crearCancion(CancionDto cancionDto) {
        Cancion cancion = CancionMapper.toCancion(cancionDto);
        return cancionRepository.save(cancion);
    }

    @Override
    public CancionDto obtenerCancionPorId(UUID id) {
        Cancion cancion = cancionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Canción", "ID", id.toString()));
        return CancionMapper.toCancionDto(cancion);
    }


    @Override
    public void eliminarCancion(UUID id) {
        if (!cancionRepository.existsById(id)) {
            throw new NotFoundException("Canción", "ID", id.toString());
        }
        cancionRepository.deleteById(id);
    }

    @Override
    public Cancion actualizarCancion(UUID idCancion, CancionDto cancionDto) {
        Cancion cancionExistente = cancionRepository.findById(idCancion)
                .orElseThrow(() -> new NotFoundException("Canción", "ID", idCancion.toString()));

        return cancionRepository.save(cancionExistente);
    }

    @Override
    public List<CancionDto> obtenerCancionesPorFiltro(String nombre, String genero, String artista) {
        List<Cancion> canciones;

        if (nombre != null && !nombre.isEmpty()) {
            canciones = cancionRepository.findByNombreContaining(nombre);
        } else if (genero != null && !genero.isEmpty()) {
            canciones = cancionRepository.findByGeneroNombre(genero);
        } else if (artista != null && !artista.isEmpty()) {
            canciones = cancionRepository.findByArtistaNombre(artista);
        } else {
            canciones = cancionRepository.findAll();
        }

        return canciones.stream()
                .map(CancionMapper::toCancionDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<CancionDto> obtenerTodasLasCanciones() {
        return null;
    }

    public List<CancionDto> obtenerCancionesAleatorias() {
        List<Cancion> todasLasCanciones = cancionRepository.findAll();
        Collections.shuffle(todasLasCanciones);
        return todasLasCanciones.stream().map(CancionMapper::toCancionDto).collect(Collectors.toList());
    }

    @Override
    public List<CancionDto> buscarCanciones(String titulo, String genero, String artista, String album) {
        return null;
    }
}