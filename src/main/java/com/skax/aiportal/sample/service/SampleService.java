package com.skax.aiportal.sample.service;

import com.skax.aiportal.sample.dto.SampleDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * 샘플 서비스 인터페이스
 * <p>
 * 샘플 도메인에 대한 CRUD 및 페이징 서비스 정의
 */
public interface SampleService {
    /**
     * 전체 샘플 데이터 페이징 조회
     * @param pageable 페이징 정보
     * @return 샘플 Page 객체
     */
    Page<SampleDto> getAllSamples(Pageable pageable);

    /**
     * ID로 샘플 단건 조회
     * @param id 샘플 ID
     * @return Optional<SampleDto>
     */
    Optional<SampleDto> getSample(Long id);

    /**
     * 샘플 데이터 생성
     * @param sampleDto 생성할 샘플 DTO
     * @return 생성된 샘플 DTO
     */
    SampleDto createSample(SampleDto sampleDto);

    /**
     * 샘플 데이터 수정
     * @param id 수정할 샘플 ID
     * @param sampleDto 수정할 데이터
     * @return 수정된 샘플 DTO
     */
    SampleDto updateSample(Long id, SampleDto sampleDto);

    /**
     * 샘플 데이터 삭제
     * @param id 삭제할 샘플 ID
     */
    void deleteSample(Long id);
}