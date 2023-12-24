package com.info.streamingmusic.service;

import com.info.streamingmusic.domain.Genero;
import com.info.streamingmusic.mapper.GeneroMapper;
import com.info.streamingmusic.dto.GeneroDto;
import com.info.streamingmusic.service.GeneroService;
import com.info.streamingmusic.repository.GeneroRepository;
import com.info.streamingmusic.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GeneroServiceImpl implements GeneroService {

    private final GeneroRepository generoRepository;

    @Override
    public Genero crearGenero(GeneroDto generoDto) {
        Genero genero = GeneroMapper.toGenero(generoDto);
        return generoRepository.save(genero);
    }


    @Override
    public GeneroDto obtenerGeneroPorId(UUID id) {
        Genero genero = generoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Género", "ID", id.toString()));
        return GeneroMapper.toGeneroDto(genero);
    }

    @Override
    public List<GeneroDto> obtenerGenerosPorNombre(String nombre) {
        List<Genero> generos = generoRepository.findByNombreContaining(nombre);
        return generos.stream()
                .map(GeneroMapper::toGeneroDto)
                .collect(Collectors.toList());
    }


    @Override
    public void eliminarGenero(UUID id) {
        if (!generoRepository.existsById(id)) {
            throw new NotFoundException("Género", "ID", id.toString());
        }
        generoRepository.deleteById(id);
    }

    @Override
    public Genero actualizarGenero(UUID idGenero, GeneroDto generoDto) {
        Genero generoExistente = generoRepository.findById(idGenero)
                .orElseThrow(() -> new NotFoundException("Género", "ID", idGenero.toString()));


        if (generoDto.getNombre() != null) {
            generoExistente.setNombre(generoDto.getNombre());
        }

        return generoRepository.save(generoExistente);
    }
    @Override
    public List<GeneroDto> obtenerTodosLosGeneros() {
        List<Genero> generos = generoRepository.findAll();
        return generos.stream()
                .map(GeneroMapper::toGeneroDto)
                .collect(Collectors.toList());
    }



}
