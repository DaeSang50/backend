package DaeSang.cheatList.reposrt.controller;

import DaeSang.cheatList.reposrt.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class ReportController {
    private final ReportService reportService;

    @GetMapping("/list")
    public ResponseEntity getList(@RequestBody String address) {
//        reportService.getList(address);
        return null;
    }
}
