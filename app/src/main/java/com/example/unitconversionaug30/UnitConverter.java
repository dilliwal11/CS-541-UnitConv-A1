package com.example.unitconversionaug30;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UnitConverter extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    Spinner spinnerList;
    Spinner spinnerUnits, spinnerSecondUnits;
    EditText editTextValue;
    TextView valueTv;
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
       valueTv = findViewById(R.id.valueTv);
       button = findViewById(R.id.button);




    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


        Log.d("selected", "onItemSelected: " +adapterView.getId());

        valueTv.setText("");
        editTextValue.setText("");

        if(i==0){
            state = new String[]{"Kilometer","Miles"};

        }
        if(i==1){

            state = new String[]{"Kilograms","Pounds"};

        }

        if(i==2){

            state = new String[]{"Celsius","Fahrenheit"};


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


        if (editTextValue.getText().toString().isEmpty()) {
            valueTv.setText("");

            return;


        }


        if(Float.valueOf(editTextValue.getText().toString()) == 0 ){

            valueTv.setText("0");
        }


        else {


            DecimalFormat f = new DecimalFormat("##.00");
            float value = 0;
            String unit1 = spinnerUnits.getSelectedItem().toString();
            String unit2 = spinnerSecondUnits.getSelectedItem().toString();
            value = Float.parseFloat(editTextValue.getText().toString());



            if(unit1.equals(unit2)){

                valueTv.setText(editTextValue.getText().toString());
            }


            if (unit1.equals("Kilograms") && unit2.equals("Pounds")) {

                valueTv.setText("" +f.format(value * 2.05));


                Toast.makeText(this, "Value in Pounds is: " + value * 2.05, Toast.LENGTH_LONG).show();
            }
            if (unit1.equals("Kilometer") && unit2.equals("Miles")) {

                valueTv.setText("" + f.format(value / 1.609));
                //valueTv.setFilters(new InputFilter[] {new DecimalDigitsInputFilter(5,2)});

            }

            if(unit1.equals("Pounds") && unit2.equals("Kilograms")){
                valueTv.setText("" + f.format(value / 2.05));

            }

            if (unit1.equals("Miles") && unit2.equals("Kilometer")) {

                valueTv.setText("" + f.format(value * 1.609));
                //valueTv.setFilters(new InputFilter[] {new DecimalDigitsInputFilter(5,2)});

            }
            if (unit1.equals("Fahrenheit") && unit2.equals("Celsius")) {

                valueTv.setText("" + f.format((value-32)*5/9));
                //valueTv.setFilters(new InputFilter[] {new DecimalDigitsInputFilter(5,2)});

            }
            if (unit1.equals("Celsius") && unit2.equals("Fahrenheit")) {

                valueTv.setText("" + f.format((value*9/5)+32));
                //valueTv.setFilters(new InputFilter[] {new DecimalDigitsInputFilter(5,2)});

            }


        }

    }
}
