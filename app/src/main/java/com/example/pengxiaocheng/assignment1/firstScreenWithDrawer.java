package com.example.pengxiaocheng.assignment1;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;


public class firstScreenWithDrawer extends AppCompatActivity
        {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_screen_with_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.first_screen_with_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



     /*public int resolveJsonToTemp(String tempJson) throws IOException, JSONException {
            JSONArray jsonArray = new JSONArray(tempJson);
                String temp = "";
         for(int i = 0; i < tempJson.length();i++) {
             JSONObject jsonObject = jsonArray.getJSONObject(i);
             temp = jsonObject.getJSONObject("currently").getString("temperature");

         }
            int tempInt = Integer.parseInt(temp);
            return tempInt;
     }
     */

     public String getTemperature(View v) {
         String tempString = "";
         new AsyncTask<Void, Void, String>() {
             @Override
             protected String doInBackground(Void... params) {
                 String result = "";

                 try {
                     result = WeatherClient.getTemperature();
                 } catch (IOException e) {
                     e.printStackTrace();
                 }

                 return result;
             }

             @Override
             protected void onPostExecute(String tempJson) {
                 Double temperature = Double.valueOf(0);
                 try {
                     JSONObject jsonObject = new JSONObject(tempJson);
                     temperature = jsonObject.getJSONObject("currently").getDouble("temperature");
                 } catch (JSONException e) {
                     e.printStackTrace();
                 }
                 String tempString = String.valueOf(temperature);
             }
         }.execute();
         return tempString;
     }

     public void goToLogIn(View v){
            Intent intent = new Intent(firstScreenWithDrawer.this, LoginActivity.class);
         startActivity(intent);
        }

     private void setWelcome

     }

