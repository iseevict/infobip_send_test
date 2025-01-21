package test.infobip.domain.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.infobip.domain.service.InfobipService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/infobip")
public class InfobipController {

    private final InfobipService infobipService;

    @GetMapping("/send/result")

}
