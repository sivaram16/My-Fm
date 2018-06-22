package com.w3app.admin.tamilfmpart1.Util;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ParserM3UToURL {

    public static String parse(String urlM3u, String type) {

        String ligne = null;

        try {
            URL urlPage = new URL(urlM3u);
            HttpURLConnection connection = (HttpURLConnection) urlPage.openConnection();
            InputStream inputStream = connection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            StringBuffer stringBuffer = new StringBuffer();

            if (type.equals("m3u")) {
                while ((ligne = bufferedReader.readLine()) != null) {
                    if (ligne.contains("http")) {
                        connection.disconnect();
                        bufferedReader.close();
                        inputStream.close();
                        return ligne;
                    }
                    stringBuffer.append(ligne);
                }
            } else {
                while ((ligne = bufferedReader.readLine()) != null) {
                    if (ligne.contains("http")) {
                        connection.disconnect();
                        bufferedReader.close();
//                        inputStream.close();
                        ligne = ligne.split("http")[1];
                        ligne = "http" + ligne;
                        Log.e("line", ligne);
                        return ligne;
                    }
                    stringBuffer.append(ligne);
                }
            }
            connection.disconnect();
            bufferedReader.close();
            inputStream.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}