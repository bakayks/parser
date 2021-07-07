package kg.socservice.parser.repos;

import kg.socservice.parser.entities.Founder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FounderRepo extends JpaRepository<Founder, Long> {
}
