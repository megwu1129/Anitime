package com.example.anitime.ui.gallery;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.anitime.R;
import com.example.anitime.databinding.FragmentYourProfileBinding;

public class GalleryFragment extends Fragment {

    private FragmentYourProfileBinding binding;

    private Button saveInfo;
    private Button editInfo;
    EditText etname,etbreed,etage,etgender, etweight;
    TextView dName, dBreed, dAge, dGender, dWeight, display;
    LinearLayout linL0, linL1, linL2, linL3;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentYourProfileBinding.inflate(inflater, container, false);
        View rootView = binding.getRoot();

        //View rootView = inflater.inflate(R.layout.fragment_your_profile, container, false);
        saveInfo = (Button) rootView.findViewById(R.id.ypButton);
        editInfo = (Button) rootView.findViewById(R.id.editButton);
        dName = (TextView) rootView.findViewById(R.id.disName);
        dBreed = (TextView) rootView.findViewById(R.id.disBreed);
        dAge = (TextView) rootView.findViewById(R.id.disAge);
        dGender = (TextView) rootView.findViewById(R.id.disGender);
        dWeight = (TextView) rootView.findViewById(R.id.disWeight);

        /*
        dName.setText("Name: " + etname.getText().toString());
        dBreed.setText("Breed: " + etbreed.getText().toString());
        dAge.setText("Age: "+ etage.getText().toString());
        dGender.setText("Gender: "+ etgender.getText().toString());
        dWeight.setText("Weight: "+ etweight.getText().toString());
        */

        editInfo.setVisibility(View.VISIBLE);
        saveInfo.setVisibility(View.GONE);
        linL0 = (LinearLayout) rootView.findViewById(R.id.ll0);
        linL1 = (LinearLayout) rootView.findViewById(R.id.ll1);
        linL2 = (LinearLayout) rootView.findViewById(R.id.ll2);
        linL3 = (LinearLayout) rootView.findViewById(R.id.ll3);
        linL0.setVisibility(View.GONE);
        linL1.setVisibility(View.GONE);
        linL2.setVisibility(View.GONE);

        saveInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etname=(EditText) rootView.findViewById(R.id.editTextPetName);
                etbreed=(EditText) rootView.findViewById(R.id.editTextTextPetBreed);
                etage=(EditText) rootView.findViewById(R.id.editTextTextPetAge);
                etgender=(EditText) rootView.findViewById(R.id.editTextTextPetGender);
                etweight=(EditText) rootView.findViewById(R.id.editTextTextPetWeight);

                //+"\nBreed: "+etbreed.getText().toString()+"\nAge: "+etage.getText().toString()
                // +"\nGender: "+etgender.getText().toString()
                //  +"\nWeight: "+etweight.getText().toString());

                dName.setText("Name: " + etname.getText().toString());
                dBreed.setText("Breed: " + etbreed.getText().toString());
                dAge.setText("Age: "+ etage.getText().toString());
                dGender.setText("Gender: "+ etgender.getText().toString());
                dWeight.setText("Weight: "+ etweight.getText().toString());

                linL3.setVisibility(View.VISIBLE);

                linL0.setVisibility(View.GONE);
                linL1.setVisibility(View.GONE);
                linL2.setVisibility(View.GONE);

                saveInfo.setVisibility(View.GONE);
                editInfo.setVisibility(View.VISIBLE);

            }
        });

        editInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveInfo.setVisibility(View.VISIBLE);
                editInfo.setVisibility(View.GONE);

                linL0.setVisibility(View.VISIBLE);
                linL1.setVisibility(View.VISIBLE);
                linL2.setVisibility(View.VISIBLE);

                linL3.setVisibility(View.GONE);
            }
        });

        final TextView textView = binding.textGallery;
        galleryViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
