package com.planner.currency;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.VisibleForTesting;

import java.util.Map;

@Slf4j
public class DataConverter {

    @VisibleForTesting
    Map<String, Double> convertToMap(String responseBody, ObjectMapper mapper) {
        try {
            Map<String, Map<String, Double>> map = mapper.readValue(responseBody, Map.class);
            return map.get("rates");
        } catch (Exception e) {
            log.error("Cannot parse JSON to map");
        }
        return null;
    }
}
