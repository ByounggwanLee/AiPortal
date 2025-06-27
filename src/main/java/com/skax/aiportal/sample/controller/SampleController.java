package com.skax.aiportal.sample.controller;

import com.skax.aiportal.sample.dto.SampleDto;
import com.skax.aiportal.sample.service.SampleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * 샘플 데이터 REST API 컨트롤러
 */
@Tag(name = "Sample", description = "샘플 데이터 API")
@RestController
@RequestMapping("/api/samples")
public class SampleController {
    private final SampleService sampleService;

    public SampleController(SampleService sampleService) {
        this.sampleService = sampleService;
    }

    /**
     * 샘플 전체 조회 (페이징)
     */
    @Operation(summary = "샘플 전체 조회", description = "모든 샘플 데이터를 페이징하여 조회합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "성공적으로 샘플 목록을 반환함",
            content = @Content(schema = @Schema(implementation = Page.class)))
    })
    @GetMapping
    public ResponseEntity<Page<SampleDto>> getAllSamples(
            @Parameter(description = "페이지 번호", example = "0") @RequestParam(defaultValue = "0") int page,
            @Parameter(description = "페이지 크기", example = "10") @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(sampleService.getAllSamples(pageable));
    }

    /**
     * 샘플 단건 조회
     */
    @Operation(summary = "샘플 단건 조회", description = "ID로 샘플 데이터를 조회합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "성공적으로 샘플을 반환함",
            content = @Content(schema = @Schema(implementation = SampleDto.class))),
        @ApiResponse(responseCode = "404", description = "샘플을 찾을 수 없음")
    })
    @GetMapping("/{id}")
    public ResponseEntity<SampleDto> getSample(@PathVariable Long id) {
        Optional<SampleDto> result = sampleService.getSample(id);
        return result.map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    /**
     * 샘플 데이터 등록
     */
    @Operation(summary = "샘플 등록", description = "샘플 데이터를 등록합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "성공적으로 샘플을 생성함",
            content = @Content(schema = @Schema(implementation = SampleDto.class)))
    })
    @PostMapping
    public ResponseEntity<SampleDto> createSample(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "생성할 샘플 데이터", required = true)
            @RequestBody SampleDto sampleDto) {
        SampleDto created = sampleService.createSample(sampleDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    /**
     * 샘플 데이터 수정
     */
    @Operation(summary = "샘플 수정", description = "ID로 샘플 데이터를 수정합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "성공적으로 샘플을 수정함",
            content = @Content(schema = @Schema(implementation = SampleDto.class))),
        @ApiResponse(responseCode = "404", description = "샘플을 찾을 수 없음")
    })
    @PutMapping("/{id}")
    public ResponseEntity<SampleDto> updateSample(@PathVariable Long id, @RequestBody SampleDto sampleDto) {
        try {
            SampleDto updated = sampleService.updateSample(id, sampleDto);
            return ResponseEntity.ok(updated);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    /**
     * 샘플 데이터 삭제
     */
    @Operation(summary = "샘플 삭제", description = "ID로 샘플 데이터를 삭제합니다.")
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "성공적으로 샘플을 삭제함"),
        @ApiResponse(responseCode = "404", description = "샘플을 찾을 수 없음")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSample(@PathVariable Long id) {
        try {
            sampleService.deleteSample(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
