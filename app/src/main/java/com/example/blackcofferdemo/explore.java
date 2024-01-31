package com.example.blackcofferdemo;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link explore#newInstance} factory method to
 * create an instance of this fragment.
 */
public class explore extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public explore() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment explore.
     */
    // TODO: Rename and change types and number of parameters
    public static explore newInstance(String param1, String param2) {
        explore fragment = new explore();
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
        View rootView = inflater.inflate(R.layout.fragment_explore, container, false);
        RecyclerView recyclerView = rootView.findViewById(R.id.recyclerView);
        List<List<String>> dataList = new ArrayList<>();
        recyclerViewAdapter adapter = new recyclerViewAdapter(dataList);

        List<String> item1 = new ArrayList<>();

        item1.add("Kush Jariwala");
        item1.add("Surat | Master Student");
        item1.add("Within 400-500 m");
        item1.add("30");
        item1.add("Coffee | Business | Friendship");
        item1.add("Hi community! I am open to new connections \"😊\"");
        dataList.add(item1);

        List<String> item2 = new ArrayList<>();
        item2.add("John Doe");
        item2.add("New York | Engineer");
        item2.add("Within 1-2 km");
        item2.add("60");
        item2.add("Programming | Travel | Reading");
        item2.add("Hello, I'm John!");
        dataList.add(item2);

        List<String> item3 = new ArrayList<>();
        item3.add("Jane Smith");
        item3.add("Los Angeles | Artist");
        item3.add("Within 3-4 km");
        item3.add("80");
        item3.add("Art | Music | Nature");
        item3.add("Nice to meet you!");
        dataList.add(item3);

        List<String> item4 = new ArrayList<>();
        item4.add("Alice Johnson");
        item4.add("San Francisco | Designer");
        item4.add("Within 2-3 km");
        item4.add("70");
        item4.add("Design | Photography | Travel");
        item4.add("Nice to meet you too!");
        dataList.add(item4);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);

        return rootView;
    }
}