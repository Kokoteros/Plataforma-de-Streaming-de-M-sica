package com.info.streamingmusic.service;

import com.info.streamingmusic.domain.ListaDeReproduccion;
import com.info.streamingmusic.mapper.ListaDeReproduccionMapper;
import com.info.streamingmusic.dto.ListaDeReproduccionDto;
import com.info.streamingmusic.service.ListaDeReproduccionService;
import com.info.streamingmusic.repository.ListaDeReproduccionRepository;
import com.info.streamingmusic.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ListaDeReproduccionServiceImpl implements ListaDeReproduccionService {

    private final ListaDeReproduccionRepository listaDeReproduccionRepository;
    private final CancionRepository cancionRepository;

    @Override
    public ListaDeReproduccion crearListaDeReproduccion(ListaDeReproduccionDto listaDto) {
        ListaDeReproduccion lista = ListaDeReproduccionMapper.toListaDeReproduccion(listaDto);
        return listaDeReproduccionRepository.save(lista);
    }

    @Override
    public List<ListaDeReproduccionDto> obtenerListasDeReproduccionPorUsuario(UUID idUsuario) {
        List<ListaDeReproduccion> listas = listaDeReproduccionRepository.findByUsuarioId(idUsuario);
        return listas.stream()
                .map(ListaDeReproduccionMapper::toListaDeReproduccionDto)
                .collect(Collectors.toList());
    }

    @Override
    public void eliminarListaDeReproduccion(UUID id) {
        if (!listaDeReproduccionRepository.existsById(id)) {
            throw new NotFoundException("Lista de reproducción", "ID", id.toString());
        }
        listaDeReproduccionRepository.deleteById(id);
    }

    @Override
    public ListaDeReproduccion actualizarListaDeReproduccion(UUID idLista, ListaDeReproduccionDto listaDto) {
        ListaDeReproduccion listaExistente = listaDeReproduccionRepository.findById(idLista)
                .orElseThrow(() -> new NotFoundException("Lista de reproducción", "ID", idLista.toString()));
        return listaDeReproduccionRepository.save(listaExistente);
    }

    @Override
    public List<ListaDeReproduccionDto> obtenerTodasLasListasDeReproduccion() {
        List<ListaDeReproduccion> listas = listaDeReproduccionRepository.findAll();
        return listas.stream().map(ListaDeReproduccionMapper::toListaDeReproduccionDto).collect(Collectors.toList());
    }

    @Override
    public ListaDeReproduccionDto obtenerListaDeReproduccionPorId(UUID id) {
        ListaDeReproduccion lista = listaDeReproduccionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Lista de reproducción", "ID", id.toString()));
        return ListaDeReproduccionMapper.toListaDeReproduccionDto(lista);
    }

    public void agregarCancionALista(UUID idLista, UUID idCancion, UUID idUsuario) {
        ListaDeReproduccion lista = listaDeReproduccionRepository.findById(idLista)
                .orElseThrow(() -> new NotFoundException("Lista de reproducción", "ID", idLista.toString()));
        if (!lista.getUsuario().getId().equals(idUsuario)) {
            throw new IllegalStateException("Solo el creador de la lista puede modificarla.");
        }
        Cancion cancion = cancionRepository.findById(idCancion)
                .orElseThrow(() -> new NotFoundException("Canción", "ID", idCancion.toString()));

        lista.getCanciones().add(cancion);
        listaDeReproduccionRepository.save(lista);
    }

    public void eliminarCancionDeLista(UUID idLista, UUID idCancion, UUID idUsuario) {
        ListaDeReproduccion lista = listaDeReproduccionRepository.findById(idLista)
                .orElseThrow(() -> new NotFoundException("Lista de reproducción", "ID", idLista.toString()));
        if (!lista.getUsuario().getId().equals(idUsuario)) {
            throw new IllegalStateException("Solo el creador de la lista puede modificarla.");
        }
        Cancion cancion = cancionRepository.findById(idCancion)
                .orElseThrow(() -> new NotFoundException("Canción", "ID", idCancion.toString()));

        lista.getCanciones().remove(cancion);
        listaDeReproduccionRepository.save(lista);
    }
}