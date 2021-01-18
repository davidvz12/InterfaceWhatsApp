package com.example.interfacewhatsapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Toast;

import com.example.interfacewhatsapp.Adapter.AdapterCalls;
import com.example.interfacewhatsapp.Adapter.AdapterChat;
import com.example.interfacewhatsapp.Model.Calls;
import com.example.interfacewhatsapp.Model.Chat;
import com.example.interfacewhatsapp.R;
import com.example.interfacewhatsapp.WebService.Asynchtask;
import com.example.interfacewhatsapp.WebService.WebService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragmento_calls#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragmento_calls extends Fragment implements Asynchtask {
    RecyclerView recyclerView;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public fragmento_calls() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragmento_calls.
     */
    // TODO: Rename and change types and number of parameters
    public static fragmento_calls newInstance(String param1, String param2) {
        fragmento_calls fragment = new fragmento_calls();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View calls = inflater.inflate(R.layout.fragment_fragmento_calls, container, false);

        recyclerView = (RecyclerView) calls.findViewById(R.id.recyclerViewCalls);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("https://interfacewhatsapp-6dbcd-default-rtdb.firebaseio.com/Chat.json",
                datos, getContext(),fragmento_calls.this);
        ws.execute("GET");
        return calls;
    }

    @Override
    public void processFinish(String result) throws JSONException {
        ArrayList<Calls> lstCalls = new ArrayList<Calls>();
        try {
            JSONObject JSONlista =  new JSONObject(result);
            JSONArray JSONlistaCalls=  JSONlista.getJSONArray("Calls");

            lstCalls = Calls.JsonObjectsBuild(JSONlistaCalls);

            AdapterCalls adapterCalls = new AdapterCalls(getActivity(), lstCalls);

            int resId = R.anim.layout_animation_down_to_up;
            LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(getActivity(),
                    resId);
            recyclerView.setLayoutAnimation(animation);
            recyclerView.setAdapter(adapterCalls);
        }catch (JSONException e)
        {
            Toast.makeText(this.getActivity(),e.getMessage(),Toast.LENGTH_LONG);
        }
    }
}