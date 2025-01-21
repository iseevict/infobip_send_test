package test.infobip.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import test.infobip.domain.api.InfobipApiClient;

@Service
@RequiredArgsConstructor
public class InfobipService {

    private final InfobipApiClient infobipApiClient;


}
