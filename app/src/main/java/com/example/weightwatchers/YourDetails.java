package com.example.weightwatchers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class YourDetails extends AppCompatActivity {

    public static String firstname;
    public static String lastname;
    public static Double height;
    public static Double weight;
    public static Double diff;
    public static Double idealWeight;
    public static String MSG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_details);
    }

    public void calculateMale(View view)
    {

        EditText fname = (EditText) findViewById(R.id.fnametxt);
        firstname = fname.getText().toString();
        EditText lname = (EditText) findViewById(R.id.lnametxt);
        lastname = lname.getText().toString();
        EditText heightEDT = (EditText) findViewById(R.id.heighttxt);
        //height = Double.parseDouble(heightEDT.getText().toString());
        EditText weightEDT = (EditText) findViewById(R.id.weighttxt);
        //weight = Double.parseDouble(weightEDT.getText().toString());

        RadioButton male = (RadioButton) findViewById(R.id.maleRad);
        RadioButton female = (RadioButton) findViewById(R.id.femaleRad);
        if(firstname.matches("") || lastname.matches("") || heightEDT.getText().toString().matches("") ||
            weightEDT.getText().toString().matches(""))
        {
            String str = "Please fill in some details";
            Toast.makeText(getApplicationContext(),str, Toast.LENGTH_SHORT).show();
        }
        else
            {
                height = Double.parseDouble(heightEDT.getText().toString());
                weight = Double.parseDouble(weightEDT.getText().toString());
                if(male.isChecked())
                {
                    idealWeight = (height - 100) - ((height - 150)/4);

                    diff = weight - idealWeight;

                    if(weight > idealWeight)
                    {
                        MSG = "Hello " + firstname+" " + lastname + ", You need to lose " + diff + "kg";
                    }
                    else if(weight < idealWeight)
                    {
                        MSG = "Hello " + firstname+" " + lastname + ", You need to gain " + Math.abs(diff) + "kg";
                    }

                    Intent intent = new Intent(this, ResultsPage.class);
                    startActivity(intent);
                }
                else if(female.isChecked())
                {
                    idealWeight = (height - 100) - (height - 150)/2.5;

                    diff = weight - idealWeight;

                    if(weight > idealWeight)
                    {
                        MSG = "Hello " + firstname+" " + lastname + ", You need to lose " + diff + "kg";
                    }
                    else if(weight < idealWeight)
                    {
                        MSG = "Hello " + firstname+" " + lastname + ", You need to gain " + Math.abs(diff) + "kg";
                    }

                    Intent intent = new Intent(this, ResultsPage.class);
                    startActivity(intent);
                }
                else if(!male.isChecked() && !female.isChecked())
                {
                    String str = "Please choose a Gender!";
                    Toast.makeText(getApplicationContext(),str, Toast.LENGTH_SHORT).show();
                }
            }
    }
}
