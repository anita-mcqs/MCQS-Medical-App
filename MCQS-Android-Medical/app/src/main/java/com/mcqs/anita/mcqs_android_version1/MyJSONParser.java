package com.mcqs.anita.mcqs_android_version1;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;

import android.util.Log;


/**
 * Created by david-MCQS on 07/09/2015.
 */
public class MyJSONParser {

    static InputStream is = null;
    static JSONObject json = null;
    static String outPut = "";
    HttpURLConnection conn = null;
    Integer result = 0;


    // constructor
    public MyJSONParser() {

    }

    public JSONObject getJSONFromUrl(String url) {


        // Making the HTTP request - API uses Http Get
        try {
               CookieManager cookieManager = new CookieManager();
              CookieHandler.setDefault(cookieManager);

            URL myURL = new URL(url);
             conn = (HttpURLConnection) myURL.openConnection();

             /* optional request header */
           // conn.setRequestProperty("Content-Type", "application/json");
                /* optional request header */
         //   conn.setRequestProperty("Accept", "application/json");
           // conn.setRequestProperty("Cookie", "McqsUserSessionUserId=224;");
           // conn.setReadTimeout(10000 /* milliseconds */);
          //  conn.setConnectTimeout(15000 /* milliseconds */);
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            conn.setDoOutput(true);
            // Starts the query
            conn.connect();

           // String query = URLEncoder.encode("key", "UTF-8") + "=" + URLEncoder.encode("value", "UTF-8");
         //   CookieManager cookieManager = new CookieManager();
          //  CookieHandler.setDefault(cookieManager);
         //   URL myURL = new URL(url);
         //   urlConnection = (HttpURLConnection) myURL.openConnection();
         //   urlConnection.setRequestProperty("Cookie", "McqsUserSessionUserId=224;");
        //    urlConnection.setRequestMethod("POST");
         //   urlConnection.setDoInput(true);
        //    urlConnection.setDoOutput(true);

        //    DataOutputStream out = new DataOutputStream(urlConnection.getOutputStream());
         //   out.writeBytes(query);
         //   out.flush();
          //  out.close();



           // urlConnection.connect();


            int statusCode = conn.getResponseCode();
            System.out.println("code: " + statusCode);

            /* 200 represents HTTP OK */
            if(statusCode == 200){
                System.out.println("status 200");
                StringBuilder sb = new StringBuilder();
                result=1;
            //    is = new BufferedInputStream(conn.getInputStream());
                try {
                    is = new BufferedInputStream(conn.getInputStream());
                    BufferedReader in = new BufferedReader(new InputStreamReader(
                            is));

                    String line = null;
                    while ((line = in.readLine()) != null) {
                        sb.append(line + "\n");
                    }


                    outPut = sb.toString();
                    //System.out.print("myJSONParser: "+ outPut);
                    Log.e("JSON", outPut);

                } catch (Exception e) {
                    Log.e("Buffer Error", "Error converting result " + e.toString());
                }

                try {
                    json = new JSONObject(outPut);
                } catch (JSONException e) {
                    Log.e("JSON Parser", "Error parsing data " + e.toString());
                }
                finally{
                    is.close();
                    conn.disconnect();
                }
                //String response = convertInputStreamToString(is);
            }
            else{
                result = 0;
                System.out.println("bad status");
            }

          //  DefaultHttpClient httpClient = new DefaultHttpClient();
          //  HttpGet httpGet = new HttpGet(url);

         //   HttpResponse httpResponse = httpClient.execute(httpGet);
          //  HttpEntity httpEntity = httpResponse.getEntity();
          //  is = httpEntity.getContent();

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

       /* try {
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    is, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = in.readLine()) != null) {
                sb.append(line + "\n");
            }

            is.close();
            outPut = sb.toString();
            Log.e("JSON", outPut);
        } catch (Exception e) {
            Log.e("Buffer Error", "Error converting result " + e.toString());
        }

        try {
            json = new JSONObject(outPut);
        } catch (JSONException e) {
            Log.e("JSON Parser", "Error parsing data " + e.toString());
        }*/

        // return JSON String
        return json;

    }
}
