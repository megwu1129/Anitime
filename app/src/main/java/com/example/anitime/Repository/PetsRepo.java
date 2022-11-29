package com.example.anitime.Repository;

import com.example.anitime.Models.PetsModel;
import com.example.anitime.R;

import java.util.ArrayList;
import java.util.List;

public class PetsRepo {
    private static PetsRepo petsRepo;
    private ArrayList<PetsModel> petsModelList = new ArrayList<>();

    public PetsRepo() {
        petsModelList.add(new PetsModel("Cupper", "Daniel", "breeder", "8month", R.drawable.pet2, R.drawable.female_icon));
        petsModelList.add(new PetsModel("Yoshi", "Meg", "breeder", "2years", R.drawable.pet1, R.drawable.male_icon));
        petsModelList.add(new PetsModel("MiuMiu", "David", "breeder", "1year", R.drawable.pet3, R.drawable.female_icon));
        petsModelList.add(new PetsModel("Dogge", "Andy", "breeder", "4month", R.drawable.pet4, R.drawable.male_icon));
    }

    public static PetsRepo getPetsRepo() {
        if (petsRepo == null) {
            petsRepo = new PetsRepo();
        }
        return petsRepo;
    }

    public ArrayList<PetsModel> getPetsModelList() {
        return petsModelList;
    }
}
