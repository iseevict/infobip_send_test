package test.infobip.domain.dto;

import lombok.*;

import java.util.List;

public class gmsRequestDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SendGmsMessageRequestDto {
        private List<MessageDto> messages;
        //private List<TopOptionDto> options;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MessageDto {
        private String sender;
        private List<DestinationDto> destinations;
        private ContentDto content;
        private WebhookDto webhooks;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class WebhookDto {
        private DeliveryDto delivery;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DeliveryDto {
        private String url;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ContentDto {
        private String text;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DestinationDto {
        private String to;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TopOptionDto {
        private boolean includeSmsCountInResponse;
    }
}
