package planner.Exchange;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class Converter {

    private String serverResponse;

    public enum Currency {
        EUR, USD, CHF, GBP, PLN
    }

    public void getRate(Currency currency) {
        serverResponse = getDataFromAPI();
        convertWithMapper(currency, new ObjectMapper());
    }

    private String getDataFromAPI() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.exchangeratesapi.io/latest?base=PLN"))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            //TODO Move to future logger
            System.out.println(response.statusCode());
            return response.body();
        } catch (Exception e) {
            //TODO log error to logger
            System.out.println(e);
        }
        return "";
    }

    private void convertWithMapper(Currency currency, ObjectMapper mapper) {
        Map<String, Integer> rates = extractRates(serverResponse, mapper);
        System.out.println(rates.get(currency.toString()));
    }

    protected Map<String, Integer> extractRates(String responseBody, ObjectMapper mapper) {
        try {
        Map<String, Map<String, Integer>> map = mapper.readValue(responseBody, Map.class);
        return map.get("rates");
        } catch (IOException e) {
            //TODO log error to logger
            System.out.println(e);
        }
        return null;
    }
}
