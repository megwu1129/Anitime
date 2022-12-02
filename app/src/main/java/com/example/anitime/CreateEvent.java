package com.example.anitime;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.anitime.Repository.EventsRepo;
import com.example.anitime.databinding.FragmentYourProfileBinding;
import com.example.anitime.ui.gallery.GalleryViewModel;

public class CreateEvent extends AppCompatActivity implements View.OnClickListener{

    private Button editInfo;
    private Button createInfo;
    LinearLayout displayEvent, createEvent;
    EditText editTextEventName, editTextMonth, editTextDate, editTextEventTime,
            editTextEventLoc, editTextEventDesc;
    TextView disEventName, disEventDate, disEventTime, disEventLoc, disEventDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_event);

        editInfo = (Button) findViewById(R.id.editEventButton);
        createInfo = (Button) findViewById(R.id.createEventButton);
        createInfo.setVisibility(View.GONE);

        displayEvent = (LinearLayout) findViewById(R.id.displayEvent);
        createEvent = (LinearLayout) findViewById(R.id.createEvent);
        createEvent.setVisibility(View.GONE);

        disEventName = (TextView) findViewById(R.id.disEventName);
        disEventDate = (TextView) findViewById(R.id.disEventDate);
        disEventTime = (TextView) findViewById(R.id.disEventTime);
        disEventLoc = (TextView) findViewById(R.id.disEventLoc);
        disEventDesc = (TextView) findViewById(R.id.disEventDesc);

        editInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editInfo.setVisibility(View.GONE);
                createInfo.setVisibility(View.VISIBLE);

                displayEvent.setVisibility(View.GONE);
                createEvent.setVisibility(View.VISIBLE);
            }
        });

        createInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextEventName = (EditText) findViewById(R.id.editTextEventName);
                editTextMonth = (EditText) findViewById(R.id.editTextMonth);
                editTextDate = (EditText) findViewById(R.id.editTextDate);
                editTextEventTime = (EditText) findViewById(R.id.editTextEventTime);
                editTextEventLoc = (EditText) findViewById(R.id.editTextEventLoc);
                editTextEventDesc = (EditText) findViewById(R.id.editTextEventDesc);

                disEventName.setText(editTextEventName.getText().toString());
                disEventDate.setText(editTextMonth.getText().toString() + " " + editTextDate.getText().toString());
                disEventTime.setText(editTextEventTime.getText().toString());
                disEventLoc.setText(editTextEventLoc.getText().toString());
                disEventDesc.setText(editTextEventDesc.getText().toString());

                editInfo.setVisibility(View.VISIBLE);
                createInfo.setVisibility(View.GONE);

                displayEvent.setVisibility(View.VISIBLE);
                createEvent.setVisibility(View.GONE);

                EventsRepo.addEvent(disEventName.getText().toString(), editTextMonth.getText().toString(), editTextDate.getText().toString(), disEventLoc.getText().toString());
                EventsRepo.printEvents();

            }
        });


    }

    @Override
    public void onClick(View view) {

    }
}