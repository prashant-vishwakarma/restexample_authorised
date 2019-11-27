package com.mediaocean.ui;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.mediaocean.constants.APIConstants.authorisedGetUri;
import static com.mediaocean.util.ApiUtils.getCall;

public class Main {

    private static Logger apacheLogger = java.util.logging.Logger.getLogger("org.apache.http.client.protocol.ResponseProcessCookies");

    private static String authToken = "";

    public static void main(String[] args) {

        //To Suppress Irrelevant Warnings
        apacheLogger.setLevel(Level.OFF);


        //authToken = getAuthToken(authTokenApiUri);
        System.out.println("Auth Token:\n" + "Bearer " + authToken);

        String response = getCall(authorisedGetUri, authToken);
        System.out.println("Pathways:\n" + response);
    }



}
