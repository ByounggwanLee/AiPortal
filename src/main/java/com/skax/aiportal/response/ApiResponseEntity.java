package com.skax.aiportal.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * API 응답을 표준화하기 위한 ResponseEntity 확장 클래스입니다.
 *
 * @param <T> 응답 데이터 타입
 */
public class ApiResponseEntity<T> extends ResponseEntity<T> {
    /** 요청 성공 여부 */
    private final boolean success;
    /** 응답 메시지 */
    private final String message;

    /**
     * ApiResponseEntity 생성자
     *
     * @param body    응답 데이터
     * @param status  HTTP 상태 코드
     * @param success 성공 여부
     * @param message 응답 메시지
     */
    public ApiResponseEntity(T body, HttpStatus status, boolean success, String message) {
        super(body, status);
        this.success = success;
        this.message = message;
    }

    /**
     * 요청 성공 여부 반환
     * @return 성공 여부
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * 응답 메시지 반환
     * @return 메시지
     */
    public String getMessage() {
        return message;
    }
}