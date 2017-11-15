package com.example.admin.daytwoweektwoanimal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AnimalCat extends AppCompatActivity {

    private ListView lvCat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_cat);
        lvCat = findViewById(R.id.lvCat);
        TextView tvshowCategories = findViewById(R.id.tvshowCategories);
        DatabaseHelper databaseHelper = new DatabaseHelper(this);
   tvshowCategories.setText(databaseHelper.getAnimal().toString());
       List<AnimalSpecies> animalSpecies = databaseHelper.getSpecies();
        //ListAdapter listAdapter = new ArrayAdapter<>(this, R.layout.activity_animal_cat,animalSpecies);
       SpeciesAdapter speciesAdapter = new SpeciesAdapter(this,R.layout.activity_animal_cat , animalSpecies);
        lvCat.setAdapter(speciesAdapter);

        lvCat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {




                        Intent intent = new Intent(AnimalCat.this, AnimalDetailsAct.class);
                        intent.putExtra("id", (i+1));
                        startActivity(intent);



            }
        });


    }







}
