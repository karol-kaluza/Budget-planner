package planner.Exchange;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class Converter {

    public enum Currency {
        EUR, USD, CHF, GBP, PLN
    }

    public void convert(Currency currency) {
        convertWithMapper(currency, new ObjectMapper());
    }

    void convertWithMapper(Currency currency, ObjectMapper mapper) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.exchangeratesapi.io/latest?base=PLN"))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            //TODO Move to future logger
            System.out.println(response.statusCode());
            Map<String, Integer> rates = extractRates(response.body(), mapper);
            System.out.println(rates.get(currency.toString()));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    Map<String, Integer> extractRates(String responseBody, ObjectMapper mapper) {
        try {
        Map<String, Map<String, Integer>> map = mapper.readValue(responseBody, Map.class);
        return map.get("rates");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
