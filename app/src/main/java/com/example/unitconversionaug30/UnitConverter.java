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
    String state[] = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_unit_converter);


        spinnerList = (Spinner) findViewById(R.id.spinnerListMeasurement);
        spinnerList.setOnItemSelectedListener(this);
       spinnerUnits =  findViewById(R.id.spinnerListUnits);
        //


       // spinnerList.setAdapter(arrayAdapter);

       // Toast.makeText(this,spinnerList.toString(),Toast.LENGTH_LONG).show();




    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {



        Toast.makeText(this,"selected "+i,Toast.LENGTH_LONG).show();

        if(i==0){
            state = new String[]{"Kilometer","Miles"};

        }
        if(i==1){

            state = new String[]{"Kilograms","Pounds"};

        }


        ArrayAdapter <String> arrayAdapter = new ArrayAdapter<String>(UnitConverter.this,R.layout.support_simple_spinner_dropdown_item, state);

       spinnerUnits.setAdapter(arrayAdapter);



    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

        Toast.makeText(this,"not selected" ,Toast.LENGTH_LONG).show();


    }
}
