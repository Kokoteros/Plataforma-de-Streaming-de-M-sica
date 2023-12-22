package com.info.streamingmusic.bootstrap;

import com.info.streamingmusic.domain.*;
import com.info.streamingmusic.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
@Component
@AllArgsConstructor
public class BootstrapData implements CommandLineRunner{
    private UsuarioRepository usuarioRepository;
    private ListaDeReproduccionRepository listaDeReproduccionRepository;
    private CancionRepository cancionRepository;
   // private ArtistaRepository artistaRepository;
    //private GeneroRepository generoRepository;


    @Override
    public void run(String... args) throws Exception{
        cargarUsuario();
        cargarListaDeReproduccion();
        //cargarCancion();
        //cargarArtista();
        //cargarGenero();
    }

    public void cargarUsuario(){
        if(usuarioRepository.count() == 0) {
            Usuario usuario = new Usuario();
            usuario.setId(UUID.randomUUID());
            usuario.setNombre("Usuario Prueba");
            usuario.setCreadoEn(LocalDateTime.now());
            usuarioRepository.save(usuario);
        }
    }

    private void cargarListaDeReproduccion(){
        if (listaDeReproduccionRepository.count() == 0){
            ListaDeReproduccion listaDeReproduccion = new ListaDeReproduccion();
            listaDeReproduccion.setId(UUID.randomUUID());
            listaDeReproduccion.setNombre("Lista Prueba");
            listaDeReproduccion.setCanciones(List.of(cancionRepository.findAll().get(0)));
            listaDeReproduccion.setUsuario(usuarioRepository.findAll().get(0));
            listaDeReproduccion.setEsPublica(true);
            listaDeReproduccion.setAleatoria(false);
            listaDeReproduccion.setRepetir(false);
            listaDeReproduccion.setCreadoEn(LocalDateTime.now());
        }
    }
}
