/**
 * AI Portal API의 메인 엔트리 포인트 클래스입니다.
 * <p>
 * Spring Boot 애플리케이션을 부트스트랩하고 실행합니다.
 * </p>
 *
 * <p>
 * 사용법: {@code main} 메서드를 실행하여 API 서버를 시작할 수 있습니다.
 * </p>
 */
package com.skax.aiportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * AI Portal API Spring Boot 애플리케이션의 시작 클래스입니다.
 */
@SpringBootApplication
public class AiPortalApiApplication {

    /**
     * 애플리케이션을 실행하는 메인 메서드입니다.
     *
     * @param args 커맨드라인 인자
     */
    public static void main(String[] args) {
        SpringApplication.run(AiPortalApiApplication.class, args);
    }

}

