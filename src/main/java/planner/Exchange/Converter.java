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
        ObjectMapper mapper = new ObjectMapper();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.exchangeratesapi.io/latest?base=PLN"))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            //Move to future logger
            System.out.println("status cod: " + response.statusCode());
            Map<String, Map<String, Integer>> map = mapper.readValue(response.body(), Map.class);
            Map<String, Integer> rates = map.get("rates");
            System.out.println("rate " + currency + " to PLN: " + rates.get(currency.toString()));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
