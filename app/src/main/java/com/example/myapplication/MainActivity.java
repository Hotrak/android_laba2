package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText amountText;
    EditText routeLengthText;
    EditText priceText;

    TextView avgValueText;
    TextView priceValueText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        amountText = (EditText) findViewById(R.id.amount);
        routeLengthText = (EditText) findViewById(R.id.route_length);
        priceText = (EditText) findViewById(R.id.price);

        avgValueText = (TextView) findViewById(R.id.avg_value);
        priceValueText = (TextView) findViewById(R.id.price_value);


        Button calculateButton = (Button) findViewById(R.id.calculate_btn);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calculateResult(v);
            }
        });
    }
    private void calculateResult(View v){
        String requiredMessage = "Поле обязательно для заполнения!";

        double amount = 0;
        try {
            amount = Double.parseDouble(amountText.getText().toString());
        }catch (Exception e){
            amountText.setError(requiredMessage);
            return;
        }
        double routeLength = 0;
        try {
            routeLength = Double.parseDouble(routeLengthText.getText().toString());
        }catch (Exception e){
            routeLengthText.setError(requiredMessage);
            return;
        }
        double price = 0;
        try {
            price = Double.parseDouble(priceText.getText().toString());
        }catch (Exception e){
            priceText.setError(requiredMessage);
            return;
        }

        double avgResult = amount / routeLength * 100;
        double priceResult = price / routeLength * amount;

        DecimalFormat formatter = new DecimalFormat("0.00");
        avgValueText.setText(formatter.format(avgResult));
        priceValueText.setText(formatter.format(priceResult));
    }


}