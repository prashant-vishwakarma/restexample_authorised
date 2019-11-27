package com.mediaocean.util;

import com.google.gson.Gson;
import org.apache.http.Consts;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ApiUtils {
    public static String getAuthToken(String tokenUri) {
        //String paramString = "someParameterString";

        //Client is Executed for REST Call
        HttpClient client = HttpClients.createDefault();

        try {
            //Build Appropriate URI using Apache Utils
            URIBuilder builder = new URIBuilder(tokenUri);
            //Request Params can be added if required.
            //builder.addParameter("", "");

            //Build URI After adding Parameters
            String builtUri = builder.build().toString();
            System.out.println(builtUri);
            //For GET Method: HttpGet

            HttpPost httpPost = new HttpPost(builtUri);
            //Add Headers to Post Request
            httpPost.addHeader(HttpHeaders.ACCEPT, "application/x-www-form-urlencoded");

            //String jsonBody = "{\"name\":\"Prashant\",\"salary\":\"123\",\"age\":\"22\"}";
            //StringEntity entity = new StringEntity(jsonBody);

            List<NameValuePair> bodyItems = new ArrayList<NameValuePair>();
            bodyItems.add(new BasicNameValuePair("grant_type", "grant_type"));
            bodyItems.add(new BasicNameValuePair("client_id", "clientId"));
            bodyItems.add(new BasicNameValuePair("client_secret", "client_secret"));
            bodyItems.add(new BasicNameValuePair("scope", "scope"));
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(bodyItems, Consts.UTF_8);

            //Add body to Post Request
            httpPost.setEntity(entity);

            //Execute client for REST Call
            HttpResponse httpResponse;
            httpResponse = client.execute(httpPost);

            //Check StatusCode for Success (200)
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if (statusCode < 200 || statusCode >= 300) {
                //Handle Status Code other than 2XX here
                System.out.println("Request Did Not Succeed");
                return "Status:" + statusCode;
            }

            //Get Response Body
            String response = EntityUtils.toString(httpResponse.getEntity());

            Map jsonJavaRootObject = new Gson().fromJson(response, Map.class);
            String accessToken = (String) jsonJavaRootObject.get("access_token");
            //Print/ Return Response

            return accessToken;

        } catch (URISyntaxException e) {
            //Trigger when URI Builder Fails
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            //Trigger when client Execute Fails
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "Exception Occured";
    }

    static public String getCall(String uri, String bearerToken) {
        //String paramString = "someParameterString";

        //Client is Executed for REST Call
        HttpClient client = HttpClients.createDefault();

        try {
            //Build Appropriate URI using Apache Utils
            URIBuilder builder = new URIBuilder(uri);
            //Request Params can be added if required.
            //builder.addParameter('paramName', paramString);

            //Build URI After adding Parameters
            String builtUri = builder.build().toString();
            System.out.println(builtUri);
            //For GET Method: HttpGet
            HttpGet httpGet = new HttpGet(builtUri);
            //Add Headers to GET Request
            httpGet.addHeader(HttpHeaders.AUTHORIZATION, bearerToken);

            //Execute client for REST Call
            HttpResponse httpResponse = client.execute(httpGet);

            //Check StatusCode for Success (200)
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if (statusCode < 200 || statusCode >= 300) {
                //Handle Status Code other than 2XX here
                System.out.println("Request Did Not Succeed");
                return "Status:" + statusCode;
            }

            //Get Response Body
            //Print/ Return Response
            return EntityUtils.toString(httpResponse.getEntity());

        } catch (URISyntaxException e) {
            //Trigger when URI Builder Fails
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            //Trigger when client Execute Fails
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "Exception Occured";
    }

    static public String postCall(String uri, String bearerToken) {
        //String paramString = "someParameterString";

        //Client is Executed for REST Call
        HttpClient client = HttpClients.createDefault();

        try {
            //Build Appropriate URI using Apache Utils
            URIBuilder builder = new URIBuilder(uri);
            //Request Params can be added if required.
            builder.addParameter("scope", "pathways=read,content:read,completions:read");

            //Build URI After adding Parameters
            String builtUri = builder.build().toString();
            System.out.println(builtUri);
            //For GET Method: HttpGet
            HttpPost httpPost = new HttpPost(builtUri);
            //Add Headers to Post Request
            httpPost.addHeader(HttpHeaders.AUTHORIZATION, bearerToken);

            //String jsonBody = "{\"name\":\"Prashant\",\"salary\":\"123\",\"age\":\"22\"}";
            //StringEntity entity = new StringEntity(jsonBody);

            //Add body to Post Request
            //httpPost.setEntity(entity);

            //Execute client for REST Call
            HttpResponse httpResponse;
            httpResponse = client.execute(httpPost);

            //Check StatusCode for Success (200)
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if (statusCode < 200 || statusCode >= 300) {
                //Handle Status Code other than 2XX here
                System.out.println("Request Did Not Succeed");
                return "Status:" + statusCode;
            }

            //Get Response Body
            //Print/ Return Response
            return EntityUtils.toString(httpResponse.getEntity());

        } catch (URISyntaxException e) {
            //Trigger when URI Builder Fails
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            //Trigger when client Execute Fails
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "Exception Occured";
    }
}
