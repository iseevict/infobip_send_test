package test.infobip.domain.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
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
        logToPretty(response);
    }

    public void getGmsMessageLogB(String s) {
        String response = infobipApiClient.getGmsMessageLogBulk(s);
        logToPretty(response);
    }

    private void logToPretty(String s) {
        try {
            if (s != null) {
                // Jackson ObjectMapper를 사용하여 JSON을 예쁘게 포맷팅
                ObjectMapper objectMapper = new ObjectMapper();
                Object jsonObject = objectMapper.readValue(s, Object.class);

                // Pretty Printing 적용
                ObjectWriter writer = objectMapper.writerWithDefaultPrettyPrinter();
                String prettyJson = writer.writeValueAsString(jsonObject);

                // 포맷팅된 JSON 출력
                System.out.println("Request Body (Pretty): \n" + prettyJson);
            } else {
                System.out.println("Request Body: No Body");
            }
        } catch (Exception e) {
            System.out.println("Failed to format JSON: " + e.getMessage());
            System.out.println("Request Body (Raw): " + new String(s));
        }
    }

    private gmsRequestDTO.SendGmsMessageRequestDto getDto() {
        List<gmsRequestDTO.DestinationDto> destinationDtoList = new ArrayList<>();
        List<gmsRequestDTO.MessageDto> messageDtoList = new ArrayList<>();

        gmsRequestDTO.LanguageDto languageDto = gmsRequestDTO.LanguageDto.builder()
                //.languageCode("TR")
                .singleShift(true)
                .lockingShift(false)
                .build();

        gmsRequestDTO.ContentDto contentDto = gmsRequestDTO.ContentDto.builder()
                .text("노션노션노션 https://jungle-friday-d03.notion.site/And-1818dd1cbf4780dbba3aec18c674c71c?pvs=4")
                //.transliteration("NONE")
                //.language(languageDto)
                .build();

        gmsRequestDTO.DestinationDto destinationDto = gmsRequestDTO.DestinationDto.builder()
                .to("+19284581548")
                .build();

        destinationDtoList.add(destinationDto);

        // 예약전송
        /*gmsRequestDTO.ScheduleDto scheduleDto = gmsRequestDTO.ScheduleDto.builder()
                .sendAt("2025-01-22T02:42:00.000+0000")
                .build();*/

        gmsRequestDTO.TrackingDto trackingDto = gmsRequestDTO.TrackingDto.builder()
                .shortenUrl(true)
                //.removeProtocol(true)
                //.customDomain("short.emfoplus.pst")
                .build();

        gmsRequestDTO.TopOptionDto topOptionDto = gmsRequestDTO.TopOptionDto.builder()
                .includeSmsCountInResponse(true)
                //.schedule(scheduleDto)
                //.tracking(trackingDto)
                .build();

        // 메시지 전송 보고서 받기 실패
        /*gmsRequestDTO.DeliveryDto deliveryDto = gmsRequestDTO.DeliveryDto.builder()
                .url("http://118.217.19.210:8080/v1/infobip")
                .build();*/

        /*gmsRequestDTO.WebhookDto webhookDto = gmsRequestDTO.WebhookDto.builder()
                .delivery(deliveryDto)
                .build();*/

        gmsRequestDTO.DeliveryTimeFromDto from = gmsRequestDTO.DeliveryTimeFromDto.builder() // 전송 시작 시간
                .hour(1)
                .minute(0)
                .build();

        gmsRequestDTO.DeliveryTimeToDto to = gmsRequestDTO.DeliveryTimeToDto.builder() // 전송 종료 시간
                .hour(18)
                .minute(0)
                .build();

        List<String> days = new ArrayList<>();
        days.add("MONDAY");
        days.add("TUESDAY");
        days.add("WEDNESDAY");
        days.add("THURSDAY");
        days.add("FRIDAY");
        days.add("SATURDAY");
        days.add("SUNDAY");

        gmsRequestDTO.DeliveryTimeWindowDto deliveryTimeWindow = gmsRequestDTO.DeliveryTimeWindowDto.builder()
                .days(days)
                .from(from)
                .to(to)
                .build();

        gmsRequestDTO.ValidityPeriodDto validityPeriod = gmsRequestDTO.ValidityPeriodDto.builder()
                .amount(1)
                .timeUnit("HOURS")
                .build();

        gmsRequestDTO.MessageOptionDto messageOption = gmsRequestDTO.MessageOptionDto.builder()
                //.deliveryTimeWindow(deliveryTimeWindow)
                //.validityPeriod(validityPeriod)
                //.flash(true)
                .build();

        gmsRequestDTO.MessageDto messageDto = gmsRequestDTO.MessageDto.builder()
                .sender("18339591275")
                .destinations(destinationDtoList)
                .content(contentDto)
                //.webhooks(webhookDto)
                .options(messageOption)
                .build();

        messageDtoList.add(messageDto);

        gmsRequestDTO.SendGmsMessageRequestDto sendGmsMessageRequestDto = gmsRequestDTO.SendGmsMessageRequestDto.builder()
                .messages(messageDtoList)
                .options(topOptionDto)
                .build();

        return sendGmsMessageRequestDto;
    }
}
