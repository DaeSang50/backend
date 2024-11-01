package DaeSang.cheatList.reposrt.controller;

import DaeSang.cheatList.reposrt.domain.Correction;
import DaeSang.cheatList.reposrt.domain.Report;
import DaeSang.cheatList.reposrt.service.ReportService;
import DaeSang.cheatList.reposrt.service.CorrectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class ReportController {
    private final ReportService reportService;
    private final CorrectService correctService;

    @PostMapping("/report")
    public Report createReport(@RequestBody Report report){
        Report savedReport = reportService.saveReport(report); // 인스턴스 메서드 호출
        return ResponseEntity.ok(savedReport).getBody();
    }

    @PostMapping("/correction")
    public ResponseEntity<Correction> createCorrection(@RequestBody Correction correction) {
        correction.setCreatedAt(java.time.LocalDateTime.now());
        Correction savedCorrection = correctService.saveCorrection(correction); // 인스턴스 메서드 호출
        return ResponseEntity.ok(savedCorrection);
    }

}
