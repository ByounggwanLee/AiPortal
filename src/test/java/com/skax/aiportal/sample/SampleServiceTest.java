package com.skax.aiportal.sample;

import com.skax.aiportal.sample.domain.Sample;
import com.skax.aiportal.sample.dto.SampleDto;
import com.skax.aiportal.sample.repository.SampleRepository;
import com.skax.aiportal.sample.service.SampleServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * SampleService 단위 테스트 클래스
 * <p>
 * SampleService의 CRUD 및 페이징 기능을 검증합니다.
 */
class SampleServiceTest {
    /**
     * 샘플 레포지토리(Mock)
     */
    @Mock
    private SampleRepository sampleRepository;

    /**
     * 테스트 대상 서비스 구현체
     */
    @InjectMocks
    private SampleServiceImpl sampleService;

    /**
     * 각 테스트 실행 전 Mock 객체 초기화
     */
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * getAllSamples: 전체 샘플 데이터 페이징 조회 테스트
     * - Sample 엔티티 리스트를 Page로 반환하고, 서비스에서 SampleDto로 변환되는지 검증
     */
    @Test
    void getAllSamples() {
        List<Sample> samples = Arrays.asList(
                new Sample(1L, "name1", "desc1"),
                new Sample(2L, "name2", "desc2")
        );
        Page<Sample> page = new PageImpl<>(samples);
        when(sampleRepository.findAll(any(Pageable.class))).thenReturn(page);
        Page<SampleDto> result = sampleService.getAllSamples(PageRequest.of(0, 10));
        assertThat(result.getContent()).hasSize(2);
        assertThat(result.getContent().get(0).getName()).isEqualTo("name1");
    }

    /**
     * getSample: ID로 단건 조회 테스트
     * - Sample 엔티티를 반환하고, 서비스에서 SampleDto로 변환되는지 검증
     */
    @Test
    void getSample() {
        Sample sample = new Sample(1L, "name", "desc");
        when(sampleRepository.findById(1L)).thenReturn(Optional.of(sample));
        Optional<SampleDto> result = sampleService.getSample(1L);
        assertThat(result).isPresent();
        assertThat(result.get().getName()).isEqualTo("name");
    }

    /**
     * createSample: 샘플 데이터 생성 테스트
     * - SampleDto를 받아 Sample 엔티티로 저장 후, 다시 SampleDto로 반환되는지 검증
     */
    @Test
    void createSample() {
        SampleDto dto = SampleDto.builder().name("name").description("desc").build();
        Sample saved = new Sample(1L, "name", "desc");
        when(sampleRepository.save(any(Sample.class))).thenReturn(saved);
        SampleDto result = sampleService.createSample(dto);
        assertThat(result.getId()).isEqualTo(1L);
        assertThat(result.getName()).isEqualTo("name");
    }

    /**
     * updateSample: 샘플 데이터 수정 테스트
     * - 기존 엔티티를 찾아 SampleDto 값으로 수정 후, SampleDto로 반환되는지 검증
     */
    @Test
    void updateSample() {
        Sample existing = new Sample(1L, "old", "old");
        SampleDto update = SampleDto.builder().name("new").description("new").build();
        when(sampleRepository.findById(1L)).thenReturn(Optional.of(existing));
        when(sampleRepository.save(any(Sample.class))).thenReturn(new Sample(1L, "new", "new"));
        SampleDto result = sampleService.updateSample(1L, update);
        assertThat(result.getName()).isEqualTo("new");
    }

    /**
     * deleteSample: 샘플 데이터 삭제 테스트
     * - deleteById가 1회 호출되는지 검증
     */
    @Test
    void deleteSample() {
        doNothing().when(sampleRepository).deleteById(1L);
        sampleService.deleteSample(1L);
        verify(sampleRepository, times(1)).deleteById(1L);
    }
}
