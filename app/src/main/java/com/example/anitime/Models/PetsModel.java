package com.example.anitime.Models;

public class PetsModel {
    private String petName, ownerName, breeder, age;
    private int urlPic, urlGender;

    public PetsModel(String petName, String ownerName, String breeder, String age, int urlPic, int urlGender) {
        this.petName = petName;
        this.ownerName = ownerName;
        this.breeder = breeder;
        this.age = age;
        this.urlPic = urlPic;
        this.urlGender = urlGender;
    }

    public String getPetName() {
        return petName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getBreeder() {
        return breeder;
    }

    public String getAge() {
        return age;
    }

    public int getUrlPic() {
        return urlPic;
    }

    public int getUrlGender() {
        return urlGender;
    }
}
