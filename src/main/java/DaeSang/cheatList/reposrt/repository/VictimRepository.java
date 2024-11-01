package DaeSang.cheatList.reposrt.repository;

import DaeSang.cheatList.reposrt.domain.Victim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VictimRepository extends JpaRepository<Victim, Long> {
}
