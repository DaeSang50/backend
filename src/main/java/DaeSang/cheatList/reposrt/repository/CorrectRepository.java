package DaeSang.cheatList.reposrt.repository;

import DaeSang.cheatList.reposrt.domain.Correction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorrectRepository extends JpaRepository<Correction, Long> {
}
