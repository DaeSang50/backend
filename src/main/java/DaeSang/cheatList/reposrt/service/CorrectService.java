package DaeSang.cheatList.reposrt.service;

import DaeSang.cheatList.reposrt.domain.Correction;
import DaeSang.cheatList.reposrt.repository.CorrectRepository;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CorrectService {
    private final CorrectRepository correctRepository;
    public Correction saveCorrection(Correction correction) {
        return correctRepository.save(correction);
    }

}