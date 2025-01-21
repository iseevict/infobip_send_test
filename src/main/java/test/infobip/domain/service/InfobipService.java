package test.infobip.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import test.infobip.domain.api.InfobipApiClient;
import test.infobip.domain.dto.gmsRequestDTO;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InfobipService {

    private final InfobipApiClient infobipApiClient;

    public void sendGmsMessage() {
        gmsRequestDTO.SendGmsMessageRequestDto sendGmsMessageRequestDto = getDto();

        String response = infobipApiClient.sendGmsMessageToInfobip(sendGmsMessageRequestDto);
        System.out.println(response);
    }

    public void getGmsMessageLog(String s) {
        String response = infobipApiClient.getGmsMessageLog(s);
        System.out.println(response);
    }

    public void getGmsMessageLogB(String s) {
        String response = infobipApiClient.getGmsMessageLogBulk(s);
        System.out.println(response);
    }

    private gmsRequestDTO.SendGmsMessageRequestDto getDto() {
        List<gmsRequestDTO.DestinationDto> destinationDtoList = new ArrayList<>();
        List<gmsRequestDTO.MessageDto> messageDtoList = new ArrayList<>();
        List<gmsRequestDTO.TopOptionDto> topOptionDtoList = new ArrayList<>();

        gmsRequestDTO.ContentDto contentDto = gmsRequestDTO.ContentDto.builder()
                .text("테테스스트트")
                .build();

        gmsRequestDTO.DestinationDto destinationDto = gmsRequestDTO.DestinationDto.builder()
                .to("+19284581548")
                .build();

        destinationDtoList.add(destinationDto);

        gmsRequestDTO.TopOptionDto topOptionDto = gmsRequestDTO.TopOptionDto.builder()
                .includeSmsCountInResponse(true)
                .build();

        gmsRequestDTO.DeliveryDto deliveryDto = gmsRequestDTO.DeliveryDto.builder()
                .url("http://118.217.19.210:8080/v1/infobip")
                .build();

        gmsRequestDTO.WebhookDto webhookDto = gmsRequestDTO.WebhookDto.builder()
                .delivery(deliveryDto)
                .build();

        topOptionDtoList.add(topOptionDto);

        gmsRequestDTO.MessageDto messageDto = gmsRequestDTO.MessageDto.builder()
                .sender("18339591275")
                .destinations(destinationDtoList)
                .content(contentDto)
                .webhooks(webhookDto)
                .build();

        messageDtoList.add(messageDto);

        gmsRequestDTO.SendGmsMessageRequestDto sendGmsMessageRequestDto = gmsRequestDTO.SendGmsMessageRequestDto.builder()
                .messages(messageDtoList)
                //.options(topOptionDtoList)
                .build();

        return sendGmsMessageRequestDto;
    }
}
