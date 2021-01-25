<<<<<<< HEAD
package com.planner.currency;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertTrue;


class ExchangeRatesAPITest {

    @Autowired
    ExchangeRatesRestClient restClient;

    @Test
    public void getDataFromApi() {
        //given
        String result;
        //when
        result = restClient.getDataFromAPI();
        //then
        assertTrue(result.getClass() == String.class);
    }
}
=======
//package com.planner.currency;
//
//import com.planner.AppConfig;
//import com.planner.currency2.ExchangeRatesRestClient;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mock;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = AppConfig.class)
//class ExchangeRatesAPITest {
//
//    @Mock
//    ExchangeRatesRestClient restClient;
//
//
//    @Test
//    public void getDataFromApi() {
//        //given
//        String result;
//        //when
//        result = restClient.getDataFromAPI();
//        //then
//        assertTrue(result.getClass() == String.class);
//    }
//}
>>>>>>> ebf11ba396b46e949857de40ae4e1ae7ec4bd793
