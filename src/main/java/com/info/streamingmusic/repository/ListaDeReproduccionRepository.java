package com.info.streamingmusic.repository;
import com.info.streamingmusic.domain.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface ListaDeReproduccionRepository extends JpaRepository<Genero, UUID> {
}
