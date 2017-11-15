package com.example.admin.daytwoweektwoanimal;

/**
 * Created by  Admin on 11/14/2017.
 */

public class AnimalSpecies {
     String Id;
     String Name;

    @Override
    public String toString() {
        return "AnimalSpecies{" +
                "Id='" + Id + '\'' +
                ", Name='" + Name + '\'' +
                '}';
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public AnimalSpecies(String id, String name) {
        Id = id;
        Name = name;
    }
}
