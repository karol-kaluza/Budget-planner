package planner.Exchange;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class ConverterTest {

    @Test
    public void convertWithMapper() {
        // given
        String testInput = "{\"rates\": {\"CUR1\":\"12\", \"CUR2\":\"15\"}}";
        Converter subject = new Converter();
        // when
        Map<String, Integer> actual = subject.extractRates(testInput, new ObjectMapper());
        // then
        assertEquals(actual.get("CUR1"), "12");
    }
}