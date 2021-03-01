//package com.planner.currency;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.mockito.BDDMockito.given;
//
//@ExtendWith(MockitoExtension.class)
//class CurrencyRateProviderTest {
//
//    @Mock
//    private CurrencyRestClient client;
//
//    @Mock
//    private HttpResponseToCurrencyMapConverter converter;
//
//    @Mock
//    private ObjectMapper objectMapper;
//
//    @InjectMocks
//    private CurrencyRateProvider subject;
//
//    @Test
//    public void getProperRateForNoResponseFromREST() {
//        //given
//        double result;
//        //when
//        given(client.getDataFromAPI()).willReturn(null);
//        result = subject.getRate(CurrencyRateProvider.Currency.EUR);
//        //then
//        assertThat(result).isEqualTo(-1);
//    }
//}