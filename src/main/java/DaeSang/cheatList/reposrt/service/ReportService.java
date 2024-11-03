package DaeSang.cheatList.reposrt.service;

import DaeSang.cheatList.reposrt.domain.*;
import DaeSang.cheatList.reposrt.repository.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    protected EncryptData encryptData;



    public Report saveReport(Report report) throws Exception {

        // Suspect 저장
        Suspect suspect = new Suspect();
        Suspect encryptSuspect = new Suspect();
        encryptSuspect.setSuspectName(encryptData.encrypt(report.getSuspectName()));
        encryptSuspect.setSuspectPhone(encryptData.encrypt(report.getSuspectPhone()));
        encryptSuspect.setSuspectGender(Suspect.Gender.valueOf(String.valueOf(report.getSuspectGender()))); // Enum 변환
        encryptSuspect.setSuspectInfo(encryptData.encrypt(report.getSuspectInfo()));
        encryptSuspect.setKnow(report.isKnow());
        suspectRepository.save(encryptSuspect);

        // SuspectAccount 저장
        SuspectAccount suspectAccount = new SuspectAccount();
        SuspectAccount encryptSuspectAccount = new SuspectAccount();
        encryptSuspectAccount.setSuspect(suspect);
        encryptSuspectAccount.setAccountNum(encryptData.encrypt(report.getSuspectAccountNum()));
        encryptSuspectAccount.setBankName(encryptData.encrypt(report.getSuspectBankName()));
        suspectAccountRepository.save(encryptSuspectAccount);

        // Victim 저장
        Victim victim = new Victim();
        Victim encryptVictim = new Victim();
        encryptVictim.setVictimName(encryptData.encrypt(report.getVictimName()));
        encryptVictim.setVictimPhone(encryptData.encrypt(report.getVictimPhone()));
        encryptVictim.setVictimEmail(encryptData.encrypt(report.getVictimEmail()));
        victimRepository.save(encryptVictim);

        // VictimAccount 저장
        VictimAccount victimAccount = new VictimAccount();
        VictimAccount encryptVictimAccount = new VictimAccount();
        encryptVictimAccount.setVictim(victim);
        encryptVictimAccount.setAccountNum(encryptData.encrypt(report.getVictimAccountNum()));
        encryptVictimAccount.setBankName(encryptData.encrypt(report.getVictimBankName()));
        victimAccountRepository.save(encryptVictimAccount);

        // DamageCase 저장
        DamageCase damageCase = new DamageCase();
        DamageCase encryptDamageCase = new DamageCase();
        encryptDamageCase.setSuspect(suspect);
        encryptDamageCase.setVictim(victim);
        encryptDamageCase.setDeposit(encryptData.encrypt(report.getDeposit()));
        encryptDamageCase.setDepositDate(report.getDepositDate());
        encryptDamageCase.setAddress(encryptData.encrypt(report.getAddress()));
        encryptDamageCase.setDetailAddress(encryptData.encrypt(report.getDetailAddress()));
        encryptDamageCase.setUrl(encryptData.encrypt(report.getUrl()));
        encryptDamageCase.setSummary(encryptData.encrypt(report.getSummary()));
        encryptDamageCase.setSuspectAccount(suspectAccount);
        encryptDamageCase.setVictimAccount(victimAccount);
        damageCaseRepository.save(encryptDamageCase);
        return report;
    }
}
