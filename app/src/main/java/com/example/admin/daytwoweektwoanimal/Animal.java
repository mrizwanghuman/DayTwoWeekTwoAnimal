package com.example.admin.daytwoweektwoanimal;

import java.util.List;

/**
 * Created by  Admin on 11/14/2017.
 */

public class Animal {


    String Id;
    String Name;
    String Description;
    String Cat_id;

    @Override
    public String toString() {
        return "Animal{" +
                "Id='" + Id + '\'' +
                ", Name='" + Name + '\'' +
                ", Description='" + Description + '\'' +
                ", Cat_id='" + Cat_id + '\'' +
                '}';
    }

    public Animal(String id, String name, String description, String cat_id) {
        Id = id;
        Name = name;
        Description = description;
        Cat_id = cat_id;
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

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getCat_id() {
        return Cat_id;
    }

    public void setCat_id(String cat_id) {
        Cat_id = cat_id;
    }
}
