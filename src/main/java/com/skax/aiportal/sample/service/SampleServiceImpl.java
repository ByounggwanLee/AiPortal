package com.skax.aiportal.sample.service;

import com.skax.aiportal.sample.domain.Sample;
import com.skax.aiportal.sample.dto.SampleDto;
import com.skax.aiportal.sample.repository.SampleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 샘플 서비스 구현체
 */
@Service
public class SampleServiceImpl implements SampleService {

    private final SampleRepository sampleRepository;

    public SampleServiceImpl(SampleRepository sampleRepository) {
        this.sampleRepository = sampleRepository;
    }

    @Override
    public List<SampleDto> getAllSamples() {
        return sampleRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public SampleDto getSample(Long id) {
        Sample sample = sampleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Sample not found: " + id));
        return toDto(sample);
    }

    @Override
    public SampleDto createSample(SampleDto dto) {
        Sample sample = new Sample();
        sample.setName(dto.getName());
        sample.setDescription(dto.getDescription());
        Sample saved = sampleRepository.save(sample);
        return toDto(saved);
    }

    @Override
    public SampleDto updateSample(Long id, SampleDto dto) {
        Sample sample = sampleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Sample not found: " + id));
        sample.setName(dto.getName());
        sample.setDescription(dto.getDescription());
        Sample updated = sampleRepository.save(sample);
        return toDto(updated);
    }

    @Override
    public void deleteSample(Long id) {
        sampleRepository.deleteById(id);
    }

    private SampleDto toDto(Sample sample) {
        SampleDto dto = new SampleDto();
        dto.setId(sample.getId());
        dto.setName(sample.getName());
        dto.setDescription(sample.getDescription());
        return dto;
    }
}