package com.mediaocean.ui;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.mediaocean.constants.APIConstants.authorisedGetUri;
import static com.mediaocean.util.ApiUtils.getCall;

public class Main {

    private static Logger apacheLogger = java.util.logging.Logger.getLogger("org.apache.http.client.protocol.ResponseProcessCookies");

    private static String authToken = "8XdvuzLlbr8EheVI79L5H2ZVaYhXiodAD1ZuMNk32y6TzKEDboQ0iUDu4RlxRR4g2APeil-oGigy-3NNQV7ECmhfWgn3Hvn2J--zZhlRTZQ3UDW7xSLMEUvs3GoiLK3UKcDVhsZSrJG6AuP4IoZfIEVwPRNkiG8Yr6eEZOQp1qwLGBKujpx1T2TEByKTijRyI2qjxmSYtEX8COGKvYBcu6kLjzsxm85gm9tQsPu-JXBhp3nMjxGV5I7WI275jWiEvJ1WRaFjl--JEzxa45OwjPbiMae0Q7mGyo8i5QjDIFH8hZJMwcG3U-Su3s7qwqoP5K2SjSzBUOvzLHAaxNta8SgZWaYSSCVeFl1XD2rBiCWR9xBBLzudubiU0o8CyAKTWA_8D7ZKD1VrmUOJ9OHvnPYxh8nlcfSgoznPGTe-ZZKyupBG4DYwBKlwBE2vDM_98GOiErWSSI9rB7MjcGBva34DYtU";

    public static void main(String[] args) {

        //To Suppress Irrelevant Warnings
        apacheLogger.setLevel(Level.OFF);


        //authToken = getAuthToken(authTokenApiUri);
        System.out.println("Auth Token:\n" + "Bearer " + authToken);

        String response = getCall(authorisedGetUri, authToken);
        System.out.println("Pathways:\n" + response);
    }



}
