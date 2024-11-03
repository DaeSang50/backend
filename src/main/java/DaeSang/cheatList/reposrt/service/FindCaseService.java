package DaeSang.cheatList.reposrt.service;


import DaeSang.cheatList.reposrt.domain.Address;
import DaeSang.cheatList.reposrt.domain.DamageCase;
import DaeSang.cheatList.reposrt.repository.DamageCaseRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class FindCaseService {
    private final DamageCaseRepository damageCaseRepository;

    public DamageCase findByAddress(Address address) {
        // 두 개의 매개변수를 보내야 하는 경우
        return damageCaseRepository.findByAddress(address.getAddress(), address.getDetailAddress())
                .orElseThrow(() -> new IllegalArgumentException("해당 주소에 대한 사건을 찾을 수 없습니다."));
    }


    public Page<DamageCase> findByPagingAddress(Address address, Pageable pageable) {
        return damageCaseRepository.findByAddress(address.getAddress(), address.getDetailAddress(), pageable);
    }

}
