package test.infobip.domain.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import test.infobip.domain.dto.gmsRequestDTO;
import test.infobip.global.config.FeignClientConfig;

@FeignClient(name = "InfobipApiClient", url = "https://4mwnkn.api.infobip.com", configuration = FeignClientConfig.class)
public interface InfobipApiClient {

    @PostMapping("/sms/3/messages")
    String sendGmsMessageToInfobip(@RequestBody gmsRequestDTO.SendGmsMessageRequestDto request);

    @GetMapping("/sms/3/logs")
    String getGmsMessageLog(@RequestParam("messageId") String messageId); // @RequestParam("messageId") String messageId

    @GetMapping("/sms/3/logs")
    String getGmsMessageLogBulk(@RequestParam("bulkId") String bulkId);
}
