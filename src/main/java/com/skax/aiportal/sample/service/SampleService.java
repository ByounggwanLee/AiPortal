package com.skax.aiportal.sample.service;

import com.skax.aiportal.sample.dto.SampleDto;

import java.util.List;

/**
 * 샘플 서비스 인터페이스
 */
public interface SampleService {
    List<SampleDto> getAllSamples();
    SampleDto getSample(Long id);
    SampleDto createSample(SampleDto dto);
    SampleDto updateSample(Long id, SampleDto dto);
    void deleteSample(Long id);
}