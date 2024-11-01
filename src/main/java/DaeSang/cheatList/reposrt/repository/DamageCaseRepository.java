package DaeSang.cheatList.reposrt.repository;

import DaeSang.cheatList.reposrt.domain.DamageCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DamageCaseRepository extends JpaRepository<DamageCase, Long> {
}
