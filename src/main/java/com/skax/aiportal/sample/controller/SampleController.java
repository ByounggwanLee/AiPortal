package com.skax.aiportal.sample.controller;

import com.skax.aiportal.sample.dto.SampleDto;
import com.skax.aiportal.sample.service.SampleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
     * 모든 샘플 데이터 조회
     */
    @Operation(summary = "샘플 전체 조회", description = "모든 샘플 데이터를 조회합니다.")
    @GetMapping
    public List<SampleDto> getAllSamples() {
        return sampleService.getAllSamples();
    }

    /**
     * 샘플 단건 조회
     */
    @Operation(summary = "샘플 단건 조회", description = "ID로 샘플 데이터를 조회합니다.")
    @GetMapping("/{id}")
    public SampleDto getSample(@PathVariable Long id) {
        return sampleService.getSample(id);
    }

    /**
     * 샘플 데이터 등록
     */
    @Operation(summary = "샘플 등록", description = "샘플 데이터를 등록합니다.")
    @PostMapping
    public SampleDto createSample(@RequestBody SampleDto dto) {
        return sampleService.createSample(dto);
    }

    /**
     * 샘플 데이터 수정
     */
    @Operation(summary = "샘플 수정", description = "ID로 샘플 데이터를 수정합니다.")
    @PutMapping("/{id}")
    public SampleDto updateSample(@PathVariable Long id, @RequestBody SampleDto dto) {
        return sampleService.updateSample(id, dto);
    }

    /**
     * 샘플 데이터 삭제
     */
    @Operation(summary = "샘플 삭제", description = "ID로 샘플 데이터를 삭제합니다.")
    @DeleteMapping("/{id}")
    public void deleteSample(@PathVariable Long id) {
        sampleService.deleteSample(id);
    }
}
