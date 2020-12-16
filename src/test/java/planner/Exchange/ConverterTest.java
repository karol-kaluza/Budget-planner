package planner.Exchange;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import java.util.Map;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
public class ConverterTest {

    @Test
    public void convertWithMapper() {
        // given
        String testInput = "{\"rates\": {\"CUR1\":\"12\", \"CUR2\":\"15\"}}";
        Converter subject = new Converter();
        // when
        Map<String, Integer> actual = subject.extractRates(testInput, new ObjectMapper());
        // then
        assertTrue(actual.size() == 2);
        assertTrue(actual.containsKey("CUR1"));
        assertTrue(actual.containsKey("CUR2"));
    }
}