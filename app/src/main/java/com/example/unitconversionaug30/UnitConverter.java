package com.example.unitconversionaug30;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class UnitConverter extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    Spinner spinnerList;
    Spinner spinnerUnits;
    List<String> paths = new ArrayList<String>();
    List<String> units = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_unit_converter);
        paths.add("Length");
        paths.add("Weight");

        spinnerList = findViewById(R.id.spinnerListMeasurement);
        spinnerUnits =  findViewById(R.id.spinnerListUnits);
        ArrayAdapter <String> arrayAdapter = new ArrayAdapter<String>(UnitConverter.this,R.layout.support_simple_spinner_dropdown_item
        , paths);


        spinnerList.setAdapter(arrayAdapter);

        Toast.makeText(this,spinnerList.toString(),Toast.LENGTH_LONG).show();




    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        Log.d("hello", "onItemSelected: "+adapterView);
        Toast.makeText(this,"hello",Toast.LENGTH_LONG).show();
        if (adapterView.equals(spinnerList)) {
            //
            Log.d("hello", "onItemSelected: "+adapterView);


            if(spinnerList.getSelectedItem().equals("Length")){
                units.add("Kilometers");
                units.add("Miles");
                ArrayAdapter<String> arrayAdapterUnits = new ArrayAdapter<String>(UnitConverter.this, R.layout.support_simple_spinner_dropdown_item
                        , units);

                spinnerUnits.setAdapter(arrayAdapterUnits);

            }






        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
