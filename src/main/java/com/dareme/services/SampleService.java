package com.dareme.services;

import com.dareme.co.SampleCO;
import com.dareme.dto.SampleResponseDTO;
import org.springframework.stereotype.Service;

/**
 * The {@link SampleService} handles actual logic for api's.
 *
 * @author Vikram Jakhar
 */
@Service
public class SampleService {
    public SampleResponseDTO sampleMethod(SampleCO sampleCO) {
        sampleCO.validate();
        SampleResponseDTO dto = new SampleResponseDTO();
        dto.setStr1("Wowwww!!!");
        dto.setFlag(true);
        return dto;
    }
}
