package com.example.blackcofferdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link refine#newInstance} factory method to
 * create an instance of this fragment.
 */
public class refine extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public refine() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment refine.
     */
    // TODO: Rename and change types and number of parameters
    public static refine newInstance(String param1, String param2) {
        refine fragment = new refine();
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

        View rootView = inflater.inflate(R.layout.fragment_refine, container, false);

        Spinner spinner = rootView.findViewById(R.id.spinner);

        int[] purposeButtonIds = {
                R.id.purpose1, R.id.purpose2, R.id.purpose3, R.id.purpose4,
                R.id.purpose5, R.id.purpose6, R.id.purpose7, R.id.purpose8
        };
        HashMap<String, Integer> purposeSelected = new HashMap<String, Integer>();

        for (int buttonId : purposeButtonIds) {
            Button purposeButton = rootView.findViewById(buttonId);
            purposeSelected.put(String.valueOf(buttonId), 0);
            purposeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (purposeSelected.get(String.valueOf(purposeButton.getId())).equals(0)) {
                        // Change the background to R.drawable.rounded_selected_button
                        purposeButton.setBackgroundResource(R.drawable.rounded_selected_button);
                        purposeSelected.replace(String.valueOf(purposeButton.getId()), 1);
                        purposeButton.setTextColor(Color.WHITE);
                    }else{
                        purposeButton.setBackgroundResource(R.drawable.rounded_button);
                        purposeSelected.replace(String.valueOf(purposeButton.getId()), 0);
                        purposeButton.setTextColor(Color.BLACK);

                    }
                }
            });
        }



        String[] items = { "Available | Hey Let Us Connect", "Away | Stay Discrete And Watch",
                "Busy | Do Not Disturb | Will Catch Up Later", "SOS | Emergency! Need Assistance! HELP"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(rootView.getContext(), android.R.layout.simple_spinner_dropdown_item, items);

        spinner.setAdapter(adapter);

        return rootView;
    }
}