package DaeSang.cheatList.reposrt.repository;

import DaeSang.cheatList.reposrt.domain.Suspect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuspectRepository extends JpaRepository<Suspect, Long> {
}
