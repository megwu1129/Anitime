package com.example.anitime.Repository;

import com.example.anitime.Models.EventModel;
import com.example.anitime.R;

import java.util.ArrayList;

public class EventsRepo {
    private static EventsRepo eventsRepo;
    private ArrayList<EventModel> eventModelList = new ArrayList<>();

    public EventsRepo(){
        eventModelList.add(new EventModel("29", "NOV", "Puppy Social", "Helms Park, Champaign", "12", R.drawable.event3));
        eventModelList.add(new EventModel("2", "DEC", "Dogs Walking", "Main Quad, UIUC", "6", R.drawable.event5));
        eventModelList.add(new EventModel("15", "JAN", "1:1 Dog Training Class", "Online", "1", R.drawable.event1));
        eventModelList.add(new EventModel("4", "FEB", "Meeting New Friends!", "Pet-Friendly Restaurant", "27", R.drawable.event2));
    }

    public static EventsRepo getEventsRepo() {
        if(eventsRepo == null) {
            eventsRepo = new EventsRepo();
        }
        return eventsRepo;
    }
    public ArrayList<EventModel> getEventModelList() {
        return eventModelList;
    }
}
