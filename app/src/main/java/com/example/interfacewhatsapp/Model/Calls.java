package com.example.interfacewhatsapp.Model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Calls {

    String username;
    String time;
    String urlIcon;
    String urlImage;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUrlIcon() {
        return urlIcon;
    }

    public void setUrlIcon(String urlIcon) {
        this.urlIcon = urlIcon;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public Calls(JSONObject a) throws JSONException {
        username = a.getString("username");
        time = a.getString("time");
        urlImage = a.getString("urlImage");
        urlIcon = a.getString("urlicon");

    }

    public static ArrayList<Calls> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<Calls> calls = new ArrayList<>();

        for (int i = 0; i < datos.length(); i++) {
            calls.add(new Calls(datos.getJSONObject(i)));
        }
        return calls;
    }
}
