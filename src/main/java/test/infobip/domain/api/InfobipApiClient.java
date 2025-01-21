package test.infobip.domain.api;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "InfobipApiClient", url = "https://4mwnkn.api.infobip.com", configuration = FeignClientConfig.class)
public class InfobipApiClient {
}
