package DaeSang.cheatList.reposrt.service;

import DaeSang.cheatList.reposrt.controller.CorrectionDto;
import DaeSang.cheatList.reposrt.domain.Correction;
import DaeSang.cheatList.reposrt.domain.DamageCase;
import DaeSang.cheatList.reposrt.repository.CorrectRepository;
import DaeSang.cheatList.reposrt.repository.DamageCaseRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class CorrectService {
    private final CorrectRepository correctRepository;
    private final DamageCaseRepository damageCaseRepository;
    public Correction saveCorrection(CorrectionDto correctionDto) {
        Optional<DamageCase> byAddress = damageCaseRepository.findByAddress(correctionDto.getAddress(), correctionDto.getDetailAddress());
        DamageCase damageCase = byAddress.get();
        Correction correction = new Correction();
        correction.setImage(correctionDto.getImage());
        correction.setName(correctionDto.getName());
        correction.setPhone(correctionDto.getPhone());
        correction.setReason(correctionDto.getReason());
        correction.setAddress(correctionDto.getAddress());
        correction.setDetailAddress(correctionDto.getDetailAddress());
        correction.setDamageCase(damageCase);
        return correctRepository.save(correction);
    }

}