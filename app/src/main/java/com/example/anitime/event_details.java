package com.example.anitime;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.example.anitime.Adapters.EventsRecyclerViewAdapter;
import com.example.anitime.Models.EventModel;

import java.util.ArrayList;

public class event_details extends AppCompatActivity implements View.OnClickListener{
    private TextView button;
    ArrayList<EventModel> eventModelArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_detail2);

        button = (TextView) findViewById(R.id.attendButton2);
        button.setOnClickListener(this);
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.attendButton2:
                addAttendee();
                break;
        }
    }

    public void addAttendee() {
        Toast.makeText(this, "You have been added to the list of attendee!",
                Toast.LENGTH_SHORT).show();

        System.out.println(eventModelArrayList.size());
    }
}