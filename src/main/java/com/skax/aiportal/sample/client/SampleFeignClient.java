package com.skax.aiportal.sample.client;

import com.skax.aiportal.sample.domain.Sample;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 샘플 데이터 외부 호출용 FeignClient 예제
 */
@Tag(name = "SampleFeignClient", description = "샘플 FeignClient API")
@FeignClient(name = "sample-external", url = "http://localhost:8081")
public interface SampleFeignClient {
    /**
     * 외부 샘플 단건 조회
     * @param id 샘플 ID
     * @return Sample 엔티티
     */
    @Operation(summary = "외부 샘플 단건 조회", description = "외부 서비스에서 샘플 데이터를 조회합니다.")
    @GetMapping("/api/samples/{id}")
    Sample getSampleById(@PathVariable("id") Long id);
}
