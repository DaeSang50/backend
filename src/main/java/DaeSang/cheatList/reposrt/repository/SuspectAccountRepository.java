package DaeSang.cheatList.reposrt.repository;

import DaeSang.cheatList.reposrt.domain.SuspectAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuspectAccountRepository extends JpaRepository<SuspectAccount, Long> {
}
