package test.infobip.global.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import feign.Logger;
import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientConfig {

    @Value("${server.api_key}")
    private String apiKey;

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("Authorization", "App " + apiKey);
            requestTemplate.header("Content-Type", "application/json");
            requestTemplate.header("Accept", "application/json");

            System.out.println("Request URL: " + requestTemplate.url());
            System.out.println("Request Headers: " + requestTemplate.headers());
            logRequestBody(requestTemplate.body());
        };
    }

    private void logRequestBody(byte[] body) {
        try {
            if (body != null) {
                // Jackson ObjectMapper를 사용하여 JSON을 예쁘게 포맷팅
                ObjectMapper objectMapper = new ObjectMapper();
                Object jsonObject = objectMapper.readValue(body, Object.class);

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
            System.out.println("Request Body (Raw): " + new String(body));
        }
    }

    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
