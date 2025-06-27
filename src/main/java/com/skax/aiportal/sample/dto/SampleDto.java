package com.skax.aiportal.sample.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 샘플 DTO
 */
@Data
@Schema(description = "샘플 데이터 전송 객체")
public class SampleDto {
    @Schema(description = "샘플 ID", example = "1")
    private Long id;

    @Schema(description = "샘플 이름", example = "테스트")
    private String name;

    @Schema(description = "샘플 설명", example = "샘플 설명입니다.")
    private String description;
}