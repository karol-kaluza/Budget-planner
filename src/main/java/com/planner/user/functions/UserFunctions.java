package com.planner.user.functions;

import com.planner.cash_flow.model.Expense;
import com.planner.cash_flow.model.Income;
import com.planner.currency.CurrencyRateProvider;
import com.planner.user.model.User;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.ArrayList;
import java.util.Map;
import java.util.function.Function;

public class UserFunctions {

    public static final Function<OAuth2User, Map<String, Object>> oAuth2UserToMap = oAuth2User -> oAuth2User.getAttributes();

    public static final Function<Map<String, Object>, User> dataMapToUser = map -> new User(
            map.get("id").toString(),
            String.valueOf(map.get("login")),
            String.valueOf(map.get("avatar_url")),
                new ArrayList<Expense>(),
                new ArrayList<Income>(),
            CurrencyRateProvider.Currency.PLN);
}
