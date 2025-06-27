package com.skax.aiportal.sample.service;

import com.skax.aiportal.sample.domain.Sample;
import com.skax.aiportal.sample.dto.SampleDto;
import com.skax.aiportal.sample.repository.SampleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 샘플 서비스 구현체
 * <p>
 * SampleService 인터페이스의 실제 비즈니스 로직을 구현합니다.
 */
@Service
@RequiredArgsConstructor
public class SampleServiceImpl implements SampleService {
    /** 샘플 레포지토리 의존성 */
    private final SampleRepository sampleRepository;

    /**
     * 전체 샘플 데이터 페이징 조회
     * @param pageable 페이징 정보
     * @return 샘플 Page 객체
     */
    @Override
    public Page<SampleDto> getAllSamples(Pageable pageable) {
        Page<Sample> page = sampleRepository.findAll(pageable);
        return new PageImpl<>(
            page.getContent().stream().map(this::toDto).collect(Collectors.toList()),
            pageable,
            page.getTotalElements()
        );
    }

    /**
     * ID로 샘플 단건 조회
     * @param id 샘플 ID
     * @return Optional<Sample>
     */
    @Override
    public Optional<SampleDto> getSample(Long id) {
        return sampleRepository.findById(id).map(this::toDto);
    }

    /**
     * 샘플 데이터 생성
     * @param sampleDto 생성할 샘플 DTO
     * @return 생성된 샘플 DTO
     */
    @Override
    public SampleDto createSample(SampleDto sampleDto) {
        Sample sample = toEntity(sampleDto);
        Sample saved = sampleRepository.save(sample);
        return toDto(saved);
    }

    /**
     * 샘플 데이터 수정
     * @param id 수정할 샘플 ID
     * @param sampleDto 수정할 샘플 DTO
     * @return 수정된 샘플 DTO
     */
    @Override
    public SampleDto updateSample(Long id, SampleDto sampleDto) {
        Sample existing = sampleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Sample not found"));
        existing.setName(sampleDto.getName());
        existing.setDescription(sampleDto.getDescription());
        Sample updated = sampleRepository.save(existing);
        return toDto(updated);
    }

    /**
     * 샘플 데이터 삭제
     * @param id 삭제할 샘플 ID
     */
    @Override
    public void deleteSample(Long id) {
        sampleRepository.deleteById(id);
    }

    /**
     * 엔티티를 DTO로 변환
     */
    private SampleDto toDto(Sample sample) {
        return SampleDto.builder()
                .id(sample.getId())
                .name(sample.getName())
                .description(sample.getDescription())
                .build();
    }

    /**
     * DTO를 엔티티로 변환
     */
    private Sample toEntity(SampleDto dto) {
        return Sample.builder()
                .id(dto.getId())
                .name(dto.getName())
                .description(dto.getDescription())
                .build();
    }
}