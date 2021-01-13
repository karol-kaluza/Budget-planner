package com.planner.currency;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.assertj.core.util.VisibleForTesting;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

public class DataConverter {

    final static Logger logger = Logger.getLogger(DataConverter.class);

    @VisibleForTesting
    Map<String, Double> convertToMap(String responseBody, ObjectMapper mapper) {
        try {
            Map<String, Map<String, Double>> map = mapper.readValue(responseBody, Map.class);
            return map.get("rates");
        } catch (Exception e) {
            logger.error("Cannot parse JSON to map");
        }
        return null;
    }
}
