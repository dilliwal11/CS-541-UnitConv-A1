package com.example.unitconversionaug30;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class UnitConverter extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    Spinner spinnerList;
    Spinner spinnerUnits, spinnerSecondUnits;
    EditText editTextValue;
    Button button;
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
       spinnerSecondUnits = findViewById(R.id.spinnerSecondUnit);
       editTextValue = findViewById(R.id.editText);
       button = findViewById(R.id.button);
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
       spinnerSecondUnits.setAdapter(arrayAdapter);



    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

        Toast.makeText(this,"not selected" ,Toast.LENGTH_LONG).show();


    }

    public void convert(View view) {

        int value= 0;
        String unit1 = spinnerUnits.getSelectedItem().toString();
        String unit2 = spinnerSecondUnits.getSelectedItem().toString();
        value = Integer.parseInt(editTextValue.getText().toString());
        if(unit1.equals("Kilograms") && unit2.equals("Pounds")){



            Toast.makeText(this,"Value in Pounds is: "+value*2.05,Toast.LENGTH_LONG).show();



        }




    }
}
