package com.example.anitime.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.anitime.Adapters.PetsRecyclerViewAdapter;
import com.example.anitime.Pet_details;
import com.example.anitime.R;
import com.example.anitime.RegisterUser;
import com.example.anitime.Repository.PetsRepo;
//import com.example.anitime.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment  {

    RecyclerView recyclerView;
    PetsRecyclerViewAdapter petsRecyclerViewAdapter;
//    private ImageView peekButton;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_pet_profiles, container, false);
//        peekButton = (ImageView) rootView.findViewById(R.id.card_image3);
//        peekButton.setOnClickListener(this);
//        recyclerView = findViewById(R.id.recyclerView);
        recyclerView = rootView.findViewById(R.id.recyclerView);
        petsRecyclerViewAdapter = new PetsRecyclerViewAdapter(PetsRepo.getPetsRepo().getPetsModelList());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
        recyclerView.setAdapter(petsRecyclerViewAdapter);
        return rootView;
    }
//    void initRecyclerView(){
//        FragmentManager fragmentManager = new FragmentManager(this);
//        petsRecyclerViewAdapter = new PetsRecyclerViewAdapter(PetsRepo.getPetsRepo().getPetsModelList());
//        Log.i("data-->",""+PetsRepo.getPetsRepo().getPetsModelList().size());
//        recyclerView.setLayoutManager(linearLayoutManager);
//        recyclerView.setAdapter(petsRecyclerViewAdapter);
//        petsRecyclerViewAdapter.notifyDataSetChanged();
//
//    }

//    public void onClick(View v) {
//        if (v.getId() == R.id.card_image3) {
//            Intent intent = new Intent(v.getContext(),Pet_details.class);
//            startActivity(intent);
//        }
//    }

//    private FragmentHomeBinding binding;
//
//    public View onCreateView(@NonNull LayoutInflater inflater,
//                             ViewGroup container, Bundle savedInstanceState) {
//        HomeViewModel homeViewModel =
//                new ViewModelProvider(this).get(HomeViewModel.class);
//
//        binding = FragmentHomeBinding.inflate(inflater, container, false);
//        View root = binding.getRoot();
//
//        final NestedScrollView textView = binding.textHome;
//        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
//        return root;
//    }
//
//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        binding = null;
//    }
}
//public class HomeFragment extends Fragment {
//    RecyclerView recyclerView;
//    PetsRecyclerViewAdapter petsRecyclerViewAdapter;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.fragment_pet_profiles);
//
//        recyclerView = findViewById(R.id.recyclerView);
//        initRecyclerView();
//    }
//    void initRecyclerView(){
//        FragmentManager fragmentManager = new FragmentManager(this);
//        petsRecyclerViewAdapter = new PetsRecyclerViewAdapter(PetsRepo.getPetsRepo().getPetsModelList());
//        Log.i("data-->",""+PetsRepo.getPetsRepo().getPetsModelList().size());
//        recyclerView.setLayoutManager(linearLayoutManager);
//        recyclerView.setAdapter(petsRecyclerViewAdapter);
//        petsRecyclerViewAdapter.notifyDataSetChanged();
//
//    }
//}
