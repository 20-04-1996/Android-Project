package com.dholakiya.pankaj.customjsondemo;

public class GetJsonData {

    String heroName;
    String heroSurname;
    String imageUrl;

    GetJsonData(String name, String surname,String imageUrl){
        this.heroName = name;
        this.heroSurname = surname;
        this.imageUrl = imageUrl;

    }

    public String getHeroName() {
        return heroName;
    }

    public String getHeroSurname() {
        return heroSurname;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
