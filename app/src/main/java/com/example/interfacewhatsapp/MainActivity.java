package com.example.interfacewhatsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ListView;
import android.widget.Toast;

import com.example.interfacewhatsapp.Adapter.AdapterChat;
import com.example.interfacewhatsapp.Model.Chat;
import com.example.interfacewhatsapp.WebService.Asynchtask;
import com.example.interfacewhatsapp.WebService.WebService;
import com.google.android.material.tabs.TabLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Toolbar toolbar;

    viewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewpager);
        toolbar =  findViewById(R.id.myToolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("WhatsApp");

        viewPagerAdapter = new viewPagerAdapter(getSupportFragmentManager());
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setSelectedTabIndicatorColor(Color.WHITE);
        tabLayout.setSelectedTabIndicatorHeight(18);

        viewPager.setAdapter(viewPagerAdapter);

    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.overflow, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id == R.id.itemMessages){
            Toast.makeText(this, "Mensajes Destacados",Toast.LENGTH_SHORT).show();
        }else if(id == R.id.itemNewDiffusion) {
            Toast.makeText(this, "Nueva difusión", Toast.LENGTH_SHORT).show();
        }else if (id == R.id.itemNewGroup){
            Toast.makeText(this, "Nuevo grupo", Toast.LENGTH_SHORT).show();
        }else if (id == R.id.itemWW) {
            Toast.makeText(this, "WhatsApp Web", Toast.LENGTH_SHORT).show();
        }else if (id == R.id.itemSettings) {
            Toast.makeText(this, "Ajustes", Toast.LENGTH_SHORT).show();
        }
        else if (id == R.id.itemSearch) {
            Toast.makeText(this, "Buscar", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }


}