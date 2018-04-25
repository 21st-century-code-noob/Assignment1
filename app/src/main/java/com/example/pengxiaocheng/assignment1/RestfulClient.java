package com.example.pengxiaocheng.assignment1;

import android.util.Log;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by pengxiaocheng on 2018/4/24.
 */

public class RestfulClient {
    private static String myIP = "118.138.75.145";

    public static String verification(String username, String hashStr) throws Exception{
            final String urlText = "http://"+ myIP + ":8080/Assignment1/webresources/assignmen1pack.residentcred/LoginVerification/" + username +"/" + hashStr ;
            String idString = "";
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

                Scanner inStream = new Scanner(connection.getInputStream());//getInputStream() returns InputStream
                while(inStream.hasNextLine()) {
                    idString = idString + inStream.nextLine();
                }
                //read the input stream and store it as string conn.disconnect();

            }
            catch (Exception e) {
                e.printStackTrace();
                Log.d("LoginActivity", "Something Wrong happened");
            }
            finally {
                connection.disconnect();

            }
            return idString;
        }

        public static String getResObjByResID(String resID){
            final String urlText = "http://"+ myIP + ":8080/Assignment1/webresources/assignmen1pack.resident" + resID;
            String resident = "";
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

                Scanner inStream = new Scanner(connection.getInputStream());//getInputStream() returns InputStream
                while(inStream.hasNextLine()) {
                    resident = resident + inStream.nextLine();
                }
                //read the input stream and store it as string conn.disconnect();

            }
            catch (Exception e) {
                e.printStackTrace();
                Log.d("LoginActivity", "Something Wrong happened");
            }
            finally {
                connection.disconnect();

            }
            return resident;
        }
        }
    }
