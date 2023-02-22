package com.example.efm_regional_java_v1_xml;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText editTextWeight, editTextHeight;
    private Button buttonCalculateBMI;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextWeight = findViewById(R.id.editTextWeight);
        editTextHeight = findViewById(R.id.editTextHeight);
        buttonCalculateBMI = findViewById(R.id.buttonCalculateBMI);

        buttonCalculateBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(editTextWeight.getText().toString()) || TextUtils.isEmpty(editTextHeight.getText().toString())) {
                    Toast.makeText(MainActivity.this, "Please enter your weight and height", Toast.LENGTH_SHORT).show();
                    return;
                }

                double weight = Double.parseDouble(editTextWeight.getText().toString());
                double height = Double.parseDouble(editTextHeight.getText().toString()) / 100.0;

                double bmi = weight / (height * height);

                String state = "";
                if (bmi < 18.5) {
                    state = "Underweight";
                } else if (bmi < 25) {
                    state = "Normal";
                } else if (bmi < 40) {
                    state = "Overweight";
                } else {
                    state = "Obese";
                }

                Toast.makeText(MainActivity.this, "BMI: " + String.format("%.2f", bmi) + "\nState: " + state, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
