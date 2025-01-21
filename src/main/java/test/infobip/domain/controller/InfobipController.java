package test.infobip.domain.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.infobip.domain.service.InfobipService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/infobip")
public class InfobipController {

    private final InfobipService infobipService;

    @GetMapping("/send/result")
    public void getResult() {
        infobipService.sendGmsMessage();
    }

    @GetMapping("/log/result")
    public void getLog(@RequestParam("messageId") String s) {
        infobipService.getGmsMessageLog(s);
    }

    @GetMapping("/bulk/result")
    public void getLogB(@RequestParam("bulkId") String s) {
        infobipService.getGmsMessageLogB(s);
    }

    @PostMapping
    public ResponseEntity<Void> receive(@RequestBody String deliveryReport) {
        System.out.println("Report: " + deliveryReport);
        return ResponseEntity.ok().build();
    }
}
