package DaeSang.cheatList.reposrt.repository;

import DaeSang.cheatList.reposrt.domain.VictimAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VictimAccountRepository extends JpaRepository<VictimAccount, Long> {
}
