package DaeSang.cheatList.reposrt.repository;

import DaeSang.cheatList.reposrt.domain.Address;
import DaeSang.cheatList.reposrt.domain.DamageCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DamageCaseRepository extends JpaRepository<DamageCase, Long> {
    Optional<DamageCase> findByAddress(String address, String detailAddress);
}
