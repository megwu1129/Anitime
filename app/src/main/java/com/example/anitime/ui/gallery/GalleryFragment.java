package com.example.anitime.ui.gallery;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.anitime.R;
import com.example.anitime.Repository.PetsRepo;
import com.example.anitime.databinding.FragmentYourProfileBinding;
import com.example.anitime.databinding.PetDetailBinding;

import javax.xml.transform.Result;

public class GalleryFragment extends Fragment {

    private FragmentYourProfileBinding binding;

    private Button saveInfo;
    private Button editInfo;
    private Button BSelectImage;
    ImageView IVPreviewImage;
    int SELECT_PICTURE = 200;
    EditText etname,etbreed,etage,etgender, etweight, etOwner, etPhone;
    TextView dName, dBreed, dAge, dGender, dWeight, dOwner, dPhone;
    LinearLayout linL3, linL00;

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
        dOwner = (TextView) rootView.findViewById(R.id.disOwner);
        dPhone = (TextView) rootView.findViewById(R.id.disPhone);

        /*
        dName.setText("Name: " + etname.getText().toString());
        dBreed.setText("Breed: " + etbreed.getText().toString());
        dAge.setText("Age: "+ etage.getText().toString());
        dGender.setText("Gender: "+ etgender.getText().toString());
        dWeight.setText("Weight: "+ etweight.getText().toString());
        */

        editInfo.setVisibility(View.VISIBLE);
        saveInfo.setVisibility(View.GONE);
        linL00 = (LinearLayout) rootView.findViewById(R.id.ll00);
        linL3 = (LinearLayout) rootView.findViewById(R.id.ll3);

        linL00.setVisibility(View.GONE);

        BSelectImage = (Button) rootView.findViewById(R.id.BSelectImage);
        IVPreviewImage = (ImageView) rootView.findViewById(R.id.IVPreviewImage);
        BSelectImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageChooser();
            }
        });

        saveInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etname=(EditText) rootView.findViewById(R.id.editTextPetName);
                etbreed=(EditText) rootView.findViewById(R.id.editTextTextPetBreed);
                etage=(EditText) rootView.findViewById(R.id.editTextTextPetAge);
                etgender=(EditText) rootView.findViewById(R.id.editTextTextPetGender);
                etweight=(EditText) rootView.findViewById(R.id.editTextTextPetWeight);
                etOwner=(EditText) rootView.findViewById(R.id.editTextOwner);
                etPhone=(EditText) rootView.findViewById(R.id.editTextPhone);

                //+"\nBreed: "+etbreed.getText().toString()+"\nAge: "+etage.getText().toString()
                // +"\nGender: "+etgender.getText().toString()
                //  +"\nWeight: "+etweight.getText().toString());

                dName.setText(etname.getText().toString());
                dBreed.setText(etbreed.getText().toString());
                dAge.setText(etage.getText().toString());
                dGender.setText(etgender.getText().toString());
                dWeight.setText(etweight.getText().toString());
                dOwner.setText(etOwner.getText().toString());
                dPhone.setText(etPhone.getText().toString());

                linL3.setVisibility(View.VISIBLE);
                linL00.setVisibility(View.GONE);

                saveInfo.setVisibility(View.GONE);
                editInfo.setVisibility(View.VISIBLE);

                PetsRepo.addPet(dName.getText().toString(), dOwner.getText().toString(), dBreed.getText().toString(), dAge.getText().toString());
                PetsRepo.printPets();

            }
        });

        editInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveInfo.setVisibility(View.VISIBLE);
                editInfo.setVisibility(View.GONE);

                linL00.setVisibility(View.VISIBLE);
                linL3.setVisibility(View.GONE);

                }
        });

        final TextView textView = binding.textGallery;
        galleryViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return rootView;
    }

    void imageChooser() {
        // create an instance of the
        // intent of the type image
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);

        // pass the constant to compare it
        // with the returned requestCode
        startActivityForResult(Intent.createChooser(i, "Select Picture"), SELECT_PICTURE);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == android.app.Activity.RESULT_OK) {

            // compare the resultCode with the
            // SELECT_PICTURE constant
            if (requestCode == SELECT_PICTURE) {
                // Get the url of the image from data
                Uri selectedImageUri = data.getData();
                if (null != selectedImageUri) {
                    // update the preview image in the layout
                    IVPreviewImage.setImageURI(selectedImageUri);
                }
            }
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
