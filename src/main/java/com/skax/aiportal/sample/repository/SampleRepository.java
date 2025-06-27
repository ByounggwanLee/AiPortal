package com.skax.aiportal.sample.repository;

import com.skax.aiportal.sample.domain.Sample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 샘플 JPA 리포지토리
 */
@Repository
public interface SampleRepository extends JpaRepository<Sample, Long> {
}