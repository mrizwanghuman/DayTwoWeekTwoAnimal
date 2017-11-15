package com.example.admin.daytwoweektwoanimal;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by  Admin on 11/14/2017.
 */

public class SpeciesAdapter extends ArrayAdapter<AnimalSpecies> {
    List<AnimalSpecies> animalSpecies = new ArrayList<>();
    public SpeciesAdapter(@NonNull Context context, int resource, @NonNull List<AnimalSpecies> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView== null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.animal_species, null);
            TextView tvCelebName = convertView.findViewById(R.id.tvCelebName);
            TextView tvCelebAge = convertView.findViewById(R.id.tvCelebAge);

            AnimalSpecies species = getItem(position);
            if(species!=null){
                tvCelebName.setText(species.getId());
                tvCelebAge.setText(species.getName());

            }

        }
        return  convertView;

    }
}
