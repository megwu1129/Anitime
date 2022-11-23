package com.example.anitime.Models;

public class PetsModel {
    private String petName, ownerName, breeder, age, urlPic, urlGender;

    public PetsModel(String petName, String ownerName, String breeder, String age, String urlPic, String urlGender) {
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

    public String getUrlPic() {
        return urlPic;
    }

    public String getUrlGender() {
        return urlGender;
    }
}
