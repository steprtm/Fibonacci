package com.example.fibonacci;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private int currentFibonacci = 0;
    private TextView textView;
    private Button showFibonacciButton;
    private Button resetButton;
    private int previousFibonacci = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.fibonacciNumberTextView);
        showFibonacciButton = findViewById(R.id.showFibonacciButton);
        resetButton = findViewById(R.id.resetButton);

        showFibonacciButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nextFibonacci = currentFibonacci + previousFibonacci;
                textView.setText(String.valueOf(nextFibonacci));

                String toastMessage = "Nomor Fibonacci: " + nextFibonacci;


                Toast toast = Toast.makeText(MainActivity.this, toastMessage, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP, 0, 0);
                toast.show();

                previousFibonacci = currentFibonacci;
                currentFibonacci = nextFibonacci;
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
