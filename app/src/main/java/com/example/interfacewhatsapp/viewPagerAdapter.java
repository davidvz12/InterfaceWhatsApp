package com.example.interfacewhatsapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.interfacewhatsapp.Fragments.fragmento_calls;
import com.example.interfacewhatsapp.Fragments.fragmento_chats;
import com.example.interfacewhatsapp.Fragments.fragmento_status;

public class viewPagerAdapter extends FragmentPagerAdapter {

    public viewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0: return "CHATS";
            case 1: return "ESTADOS";
            case 2: return "LLAMADAS";
        }
        return null;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0: return  new fragmento_chats();
            case 1: return new fragmento_status();
            case 2: return new fragmento_calls();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
