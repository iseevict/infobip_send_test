package test.infobip.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

public class gmsRequestDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class SendGmsMessageRequestDto {
        private List<MessageDto> messages;
        private TopOptionDto options;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class MessageDto {
        private String sender;
        private List<DestinationDto> destinations;
        private ContentDto content;
        private WebhookDto webhooks;
        private MessageOptionDto options;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class MessageOptionDto {
        private ValidityPeriodDto validityPeriod;
        private DeliveryTimeWindowDto deliveryTimeWindow;
        private Boolean flash;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class ValidityPeriodDto {
        private Integer amount;
        private String timeUnit;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class DeliveryTimeWindowDto {
        private List<String> days;
        private DeliveryTimeFromDto from;
        private DeliveryTimeToDto to;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class DeliveryTimeFromDto {
        private Integer hour;
        private Integer minute;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class DeliveryTimeToDto {
        private Integer hour;
        private Integer minute;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class WebhookDto {
        private DeliveryDto delivery;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class DeliveryDto {
        private String url;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class ContentDto {
        private String text;
        private String transliteration;
        private LanguageDto language;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class LanguageDto {
        private String languageCode;
        private Boolean singleShift;
        private Boolean lockingShift;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class DestinationDto {
        private String to;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class TopOptionDto {
        private Boolean includeSmsCountInResponse;
        private ScheduleDto schedule;
        private TrackingDto tracking;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class TrackingDto {
        private Boolean shortenUrl;
        private Boolean removeProtocol;
        private String customDomain;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class ScheduleDto {
        private String sendAt;
    }
}
