package com.yogadimas.trafficsigns.view.warning;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yogadimas.trafficsigns.R;
import com.yogadimas.trafficsigns.adapter.Adapter;
import com.yogadimas.trafficsigns.model.Signs;

import java.util.ArrayList;

public class WarningActivity extends AppCompatActivity {

    private final ArrayList<Signs> signsArrayList = new ArrayList<>();
    private RecyclerView rvSigns;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warning);

        rvSigns = findViewById(R.id.rv_signs);
        rvSigns.setHasFixedSize(true);

        signsArrayList.addAll(getListSigns());
        showRecyclerList();

    }

    public ArrayList<Signs> getListSigns() {
        String[] dataDescription = getResources().getStringArray(R.array.data_warning_description);
        @SuppressLint("Recycle")
        TypedArray dataPhoto = getResources().obtainTypedArray(R.array.data_warning_photo);
        ArrayList<Signs> listSigns = new ArrayList<>();
        for (int i = 0; i < dataDescription.length; i++) {
            Signs signs = new Signs();
            signs.setDescription(dataDescription[i]);
            signs.setPhoto(dataPhoto.getResourceId(i, -1));
            listSigns.add(signs);
        }
        return listSigns;
    }

    private void showRecyclerList() {
        if (getApplicationContext().getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            rvSigns.setLayoutManager(new GridLayoutManager(this, 2));
        } else {
            rvSigns.setLayoutManager(new LinearLayoutManager(this));
        }
        Adapter adapter = new Adapter(signsArrayList);
        rvSigns.setAdapter(adapter);
    }
}