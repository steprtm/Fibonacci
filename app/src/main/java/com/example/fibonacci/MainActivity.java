package com.example.fibonacci;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;


public class MainActivity extends AppCompatActivity {
    private static final int NUM_COLORS = 7;

    private int currentFibonacci = 0;
    private TextView textView;
    private Button showFibonacciButton;
    private Button resetButton;
    private int previousFibonacci = 1;
    private void changeTextColor() {
        Resources res = getResources();
        TypedArray colors = res.obtainTypedArray(R.array.fibonacci_colors);

        int randomIndex = new Random().nextInt(NUM_COLORS);
        int randomColor = colors.getColor(randomIndex, 0);

        textView.setTextColor(randomColor);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.fibonacciNumberTextView);
        showFibonacciButton = findViewById(R.id.showFibonacciButton);
        resetButton = findViewById(R.id.resetButton);


        Button showToastButton = findViewById(R.id.showToastButton);

    showFibonacciButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nextFibonacci = currentFibonacci + previousFibonacci;
                textView.setText(String.valueOf(nextFibonacci));
                changeTextColor();
                previousFibonacci = currentFibonacci;
                currentFibonacci = nextFibonacci;

            }
        });
    showToastButton = findViewById(R.id.showToastButton);
    showToastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toastMessage = "Fibonacci Number: " + currentFibonacci;
                Toast toast = Toast.makeText(MainActivity.this, toastMessage, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP, 0, 16);
                toast.show();
            }
        });


        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentFibonacci = 0;
                previousFibonacci = 1;
                textView.setText("0");
            }
        });
    }
}
