package com.example.anitime.Repository;

import com.example.anitime.Models.PetsModel;

import java.util.ArrayList;
import java.util.List;

public class PetsRepo {
    private static PetsRepo petsRepo;
    private ArrayList<PetsModel> petsModelList = new ArrayList<>();

    public PetsRepo() {
        petsModelList.add(new PetsModel("Cupper", "Daniel", "breeder", "8month", "@drawable/pet2", "@drawable/female_icon"));
        petsModelList.add(new PetsModel("Yoshi", "Meg", "breeder", "2years", "@drawable/pet1", "@drawable/male_icon"));
        petsModelList.add(new PetsModel("MiuMiu", "David", "breeder", "1year", "@drawable/pet3", "@drawable/female_icon"));
        petsModelList.add(new PetsModel("Cupper", "Daniel", "breeder", "8month", "@drawable/pet4", "@drawable/female_icon"));
        petsModelList.add(new PetsModel("Dogge", "Andy", "breeder", "4month", "@drawable/pet2", "@drawable/female_icon"));

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
