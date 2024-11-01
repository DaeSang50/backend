package DaeSang.cheatList.reposrt.service;

import DaeSang.cheatList.reposrt.domain.Correction;
import DaeSang.cheatList.reposrt.repository.CorrectRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional
public class CorrectService {
    private final CorrectRepository correctRepository;
    public Correction saveCorrection(Correction correction) {
        return correctRepository.save(correction);
    }

}