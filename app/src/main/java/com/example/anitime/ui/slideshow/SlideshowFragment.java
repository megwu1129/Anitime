package com.example.anitime.ui.slideshow;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.anitime.Adapters.EventsRecyclerViewAdapter;
import com.example.anitime.Adapters.PetsRecyclerViewAdapter;
import com.example.anitime.EventActivity;
import com.example.anitime.R;
import com.example.anitime.RegisterUser;
import com.example.anitime.Repository.EventsRepo;
import com.example.anitime.Repository.PetsRepo;

//public class SlideshowFragment extends Fragment implements View.OnClickListener {
//
//    private ImageView eventDetailButton;
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        View rootView = inflater.inflate(R.layout.fragment_events, container, false);
//        eventDetailButton = (ImageView) rootView.findViewById(R.id.card_image1);
//        eventDetailButton.setOnClickListener(this);
//        return rootView;
//    }
//
//    public void onClick(View v) {
//        if (v.getId() == R.id.card_image1) {
//            Intent intent = new Intent(v.getContext(), EventActivity.class);
//            startActivity(intent);
//        }
//    }
//}

public class SlideshowFragment extends Fragment {
    RecyclerView recyclerView;
    EventsRecyclerViewAdapter eventsRecyclerViewAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_events, container, false);
        recyclerView = rootView.findViewById(R.id.recyclerView);
        eventsRecyclerViewAdapter = new EventsRecyclerViewAdapter(EventsRepo.getEventsRepo().getEventModelList());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
        recyclerView.setAdapter(eventsRecyclerViewAdapter);
        return rootView;
    }
}