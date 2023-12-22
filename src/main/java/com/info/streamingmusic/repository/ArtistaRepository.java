package com.info.streamingmusic.repository;
import com.info.streamingmusic.domain.Artista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;
@Repository
public interface ArtistaRepository extends JpaRepository<Artista, UUID>{

}
