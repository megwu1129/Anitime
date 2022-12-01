package com.example.anitime.Repository;

import com.example.anitime.Models.PetsModel;
import com.example.anitime.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class PetsRepo {
    private static PetsRepo petsRepo;
    private static ArrayList<PetsModel> petsModelList = new ArrayList<>();

    public PetsRepo() {
        petsModelList.add(new PetsModel("Cupper", "Daniel", "breeder", "8month", R.drawable.pet2, R.drawable.female_icon));
        petsModelList.add(new PetsModel("Yoshi", "Meg", "breeder", "2years", R.drawable.pet1, R.drawable.male_icon));
        petsModelList.add(new PetsModel("MiuMiu", "David", "breeder", "1year", R.drawable.pet3, R.drawable.female_icon));
        petsModelList.add(new PetsModel("Dogge", "Andy", "breeder", "4month", R.drawable.pet4, R.drawable.male_icon));
    }

    public static void addPet(String name,  String owner, String breeder, String age, String gender) {
        petsModelList.add(new PetsModel(name, owner, breeder, age, R.drawable.pet2, getGenderImage(gender)));
    }

    public static int getGenderImage(String gender) {
        if (gender.equalsIgnoreCase("m")) {
            return R.drawable.male_icon;
        } else {
            return R.drawable.female_icon;
        }
    }

    public static void printPets() {
        for (int i = 0; i < petsModelList.size(); i++) {
            PetsModel p = petsModelList.get(i);
            System.out.println(p.getPetName() + " " + p.getOwnerName());
        }

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
