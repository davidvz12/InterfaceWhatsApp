package com.example.interfacewhatsapp.Model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Chat {

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

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    String username;
    String time;
    String urlImage;
    String description;


    public Chat(JSONObject a) throws JSONException {
        username = a.getString("username").toString();
        time = a.getString("time").toString();
        urlImage = a.getString("urlImage");
        description = a.getString("description");
    }

    public static ArrayList<Chat> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<Chat> chat = new ArrayList<>();

        for (int i = 0; i < datos.length(); i++) {
            chat.add(new Chat(datos.getJSONObject(i)));
        }
        return chat;
    }
}
