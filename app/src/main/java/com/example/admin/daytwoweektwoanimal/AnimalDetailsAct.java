package com.example.admin.daytwoweektwoanimal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class AnimalDetailsAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_details);

        Intent getCatId = getIntent();
        String getCateids=getCatId.getStringExtra("id");
        Toast.makeText(this, getCateids, Toast.LENGTH_SHORT).show();
    }
}
