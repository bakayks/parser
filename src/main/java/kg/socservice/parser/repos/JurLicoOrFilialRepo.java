package kg.socservice.parser.repos;

import kg.socservice.parser.entities.JurLicoOrFilial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JurLicoOrFilialRepo extends JpaRepository<JurLicoOrFilial, Long> {
}
