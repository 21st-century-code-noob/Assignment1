package com.example.pengxiaocheng.assignment1;

/**
 * Created by pengxiaocheng on 2018/4/15.
 */
import android.util.Log;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net
        .URL;
import java.util.Scanner;

public class WeatherClient {

    private static String MY_KEY = "AIzaSyBW11wi9oscnqFcLddlHFyvewO7mt1MxOc";

    static public String getTemperature(String latitude, String longitude) throws IOException {
        final String urlText = "https://api.darksky.net/forecast/e15cbfa45021486aac5557b12bc7f6ca/"
                + latitude + "," + longitude + "?exclude=daily,hourly,minutely,alerts,flags";

        String tempString = "";
        URL url = null;
        HttpURLConnection connection = null;
        try {
            url = new URL(urlText);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setReadTimeout(10000);
            connection.setConnectTimeout(15000);

            Scanner inStream = new Scanner(connection.getInputStream()); //getInputStream() returns InputStream
            while (inStream.hasNextLine()) {
                tempString += inStream.nextLine();
                //read the input stream and store it as string conn.disconnect();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            Log.d("firstScreenWithDrawer", "Something Wrong happened");
        }
        finally {
                connection.disconnect();

        }
        return tempString;
    }

    static public String convertAddrToCoordinate(String addr) throws IOException{
        String addrPlus = addr.replace(' ', '+');
        final String urlText = "https://maps.googleapis.com/maps/api/geocode/json?address=" + addrPlus + "&key=" + MY_KEY;
        String coordinateString = "";
        URL url = null;
        HttpURLConnection connection = null;
        try {
            url = new URL(urlText);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setReadTimeout(10000);
            connection.setConnectTimeout(15000);

            Scanner inStream = new Scanner(connection.getInputStream()); //getInputStream() returns InputStream
            while (inStream.hasNextLine()) {
                coordinateString += inStream.nextLine();
                //read the input stream and store it as string conn.disconnect();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            Log.d("firstScreenWithDrawer", "Something Wrong happened");
        }
        finally {
            connection.disconnect();

        }
        return coordinateString;

    }
}

