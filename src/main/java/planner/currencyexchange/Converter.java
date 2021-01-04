package planner.currencyexchange;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.lang.Double;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class Converter {

    final static Logger logger = Logger.getLogger(Converter.class);

    private String serverResponse;

    public enum Currency {
        EUR, USD, CHF, GBP, PLN
    }

    public Double getRate(Currency currency) {
        serverResponse = getDataFromAPI();
        return getRateFromRates(currency);
    }

    private String getDataFromAPI() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.exchangeratesapi.io/latest?base=PLN"))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            logger.info("HTTPRequest status code: " + response.statusCode());
            return response.body();
        } catch (Exception e) {
            logger.error("Connection to api error: ", e);
        }
        return "";
    }

    private Double getRateFromRates(Currency currency) {
        Map<String, Double> rates = convertToMap(serverResponse, new ObjectMapper());
        logger.info("Rate for " + currency + ": " + rates.get(currency.toString()));
        return rates.get(currency.toString());
    }

    protected Map<String, Double> convertToMap(String responseBody, ObjectMapper mapper) {
        try {
            Map<String, Map<String, Double>> map = mapper.readValue(responseBody, Map.class);
            return map.get("rates");
        } catch (IOException e) {
            logger.error("Cannot parse JSON to map", e);
        }
        return null;
    }
}
