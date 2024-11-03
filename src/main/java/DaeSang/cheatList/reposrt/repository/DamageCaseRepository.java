package DaeSang.cheatList.reposrt.repository;

import DaeSang.cheatList.reposrt.domain.Address;
import DaeSang.cheatList.reposrt.domain.DamageCase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DamageCaseRepository extends JpaRepository<DamageCase, Long> {
    @Query("SELECT d FROM DamageCase d WHERE d.address = :address AND d.detailAddress = :detailAddress")
    Optional<DamageCase> findByAddress(@Param("address") String address, @Param("detailAddress") String detailAddress);

    @Query("SELECT d FROM DamageCase d WHERE d.address = :address AND d.detailAddress = :detailAddress")
    Page<DamageCase> findByAddress(@Param("address") String address, @Param("detailAddress") String detailAddress, Pageable pageable);
}
