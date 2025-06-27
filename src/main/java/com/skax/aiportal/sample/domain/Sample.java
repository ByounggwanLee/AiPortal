package com.skax.aiportal.sample.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

/**
 * 샘플 엔티티
 */
@Entity
@Table(name = "sample")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "샘플 엔티티")
public class Sample {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "샘플 ID", example = "1")
    private Long id;

    @Column(nullable = false)
    @Schema(description = "샘플 이름", example = "샘플명")
    private String name;

    @Schema(description = "샘플 설명", example = "샘플 설명입니다.")
    private String description;
}