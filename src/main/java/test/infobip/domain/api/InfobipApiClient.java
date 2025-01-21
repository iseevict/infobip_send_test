package test.infobip.domain.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import test.infobip.domain.dto.gmsRequestDTO;
import test.infobip.global.config.FeignClientConfig;

@FeignClient(name = "InfobipApiClient", url = "https://4mwnkn.api.infobip.com", configuration = FeignClientConfig.class)
public interface InfobipApiClient {

    @PostMapping("/sms/3/messages")
    String sendGmsMessage(@RequestBody gmsRequestDTO.sendGmsMessageRequestDto request);
}
