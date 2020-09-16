package com.example.weightwatchers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;

public class ResultsPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results_page);

        String msg = YourDetails.MSG;
        TextView statusText = (TextView) findViewById(R.id.statmsglbl);
        statusText.setText(msg);
    }

    public void calculateAgain(View view)
    {
        YourDetails.firstname = "";
        YourDetails.lastname = "";
        YourDetails.height = 0.00;
        YourDetails.weight = 0.00;
        YourDetails.diff = 0.00;
        YourDetails.idealWeight = 0.00;
        YourDetails.MSG = "";

        Intent intent = new Intent(this, YourDetails.class);
        startActivity(intent);
    }
}
