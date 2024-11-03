package DaeSang.cheatList.reposrt.controller;

import DaeSang.cheatList.reposrt.domain.Address;
import DaeSang.cheatList.reposrt.domain.Correction;
import DaeSang.cheatList.reposrt.domain.DamageCase;
import DaeSang.cheatList.reposrt.domain.Report;
import DaeSang.cheatList.reposrt.repository.DamageCaseRepository;
import DaeSang.cheatList.reposrt.service.FindCaseService;
import DaeSang.cheatList.reposrt.service.ReportService;
import DaeSang.cheatList.reposrt.service.CorrectService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class ReportController {
    private final ReportService reportService;
    private final CorrectService correctService;
    private final FindCaseService findCaseService;

    @PostMapping("/test")
    public String hello(){
        return "heelo";
    }

    @PostMapping("/list")
    public ResponseEntity<DamageCase> getList(@RequestBody Address address) {
        DamageCase damageCase = findCaseService.findByAddress(address); // 인스턴스 메서드 호출
        return ResponseEntity.ok(damageCase);
    }

    @PostMapping("/report")
    public Report createReport(@RequestBody Report report) throws Exception {
        Report savedReport = reportService.saveReport(report); // 인스턴스 메서드 호출
        return ResponseEntity.ok(savedReport).getBody();
    }

    @PostMapping("/correction")
    public ResponseEntity<Correction> createCorrection(@RequestBody CorrectionDto correctionDto) {
        Correction savedCorrection = correctService.saveCorrection(correctionDto); // 인스턴스 메서드 호출
        return ResponseEntity.ok(savedCorrection);
    }


    @PostMapping("/list/page")
    public ResponseEntity<Page<DamageCase>> getList(@RequestBody Address address, Pageable pageable) {
        Page<DamageCase> damageCases = findCaseService.findByPagingAddress(address, pageable);
        return ResponseEntity.ok(damageCases);
    }

}
