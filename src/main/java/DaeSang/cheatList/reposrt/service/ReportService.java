package DaeSang.cheatList.reposrt.service;

import DaeSang.cheatList.reposrt.domain.*;
import DaeSang.cheatList.reposrt.repository.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class ReportService {

    private final SuspectRepository suspectRepository;
    private final SuspectAccountRepository suspectAccountRepository;
    private final VictimRepository victimRepository;
    private final VictimAccountRepository victimAccountRepository;
    private final DamageCaseRepository damageCaseRepository;

    public Report saveReport(Report report) {
        // Suspect 저장
        Suspect suspect = new Suspect();
        suspect.setSuspectName(report.getSuspectName());
        suspect.setSuspectPhone(report.getSuspectPhone());
        suspect.setSuspectGender(Suspect.Gender.valueOf(String.valueOf(report.getSuspectGender()))); // Enum 변환
        suspect.setSuspectInfo(report.getSuspectInfo());
        suspect.setKnow(report.isKnow());
        suspectRepository.save(suspect);

        // SuspectAccount 저장
        SuspectAccount suspectAccount = new SuspectAccount();
        suspectAccount.setSuspect(suspect);
        suspectAccount.setAccountNum(report.getSuspectAccountNum());
        suspectAccount.setBankName(report.getSuspectBankName());
        suspectAccountRepository.save(suspectAccount);

        // Victim 저장
        Victim victim = new Victim();
        victim.setVictimName(report.getVictimName());
        victim.setVictimPhone(report.getVictimPhone());
        victim.setVictimEmail(report.getVictimEmail());
        victimRepository.save(victim);

        // VictimAccount 저장
        VictimAccount victimAccount = new VictimAccount();
        victimAccount.setVictim(victim);
        victimAccount.setAccountNum(report.getVictimAccountNum());
        victimAccount.setBankName(report.getVictimBankName());
        victimAccountRepository.save(victimAccount);

        // DamageCase 저장
        DamageCase damageCase = new DamageCase();
        damageCase.setSuspect(suspect);
        damageCase.setVictim(victim);
        damageCase.setDeposit(report.getDeposit());
        damageCase.setDepositDate(report.getDepositDate());
        damageCase.setAddress(report.getAddress());
        damageCase.setDetailAddress(report.getDetailAddress());
        damageCase.setUrl(report.getUrl());
        damageCase.setSummary(report.getSummary());
        damageCase.setSuspectAccount(suspectAccount);
        damageCase.setVictimAccount(victimAccount);
        damageCaseRepository.save(damageCase);
        return report;
    }
}
