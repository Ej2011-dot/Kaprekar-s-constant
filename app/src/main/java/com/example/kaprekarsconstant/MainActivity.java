package com.example.kaprekarsconstant;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private EditText etInput;
    private TextView tvSteps, tvResult;
    private Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etInput      = findViewById(R.id.etInput);
        tvSteps      = findViewById(R.id.tvSteps);
        tvResult     = findViewById(R.id.tvResult);
        btnCalculate = findViewById(R.id.btnCalculate);

        btnCalculate.setOnClickListener(v -> calculate());
    }

    private void calculate() {
        String input = etInput.getText().toString().trim();

        if (input.length() != 4) {
            Toast.makeText(this, "Enter exactly 4 digits!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (input.chars().distinct().count() == 1) {
            Toast.makeText(this, "All digits are the same — try another number!", Toast.LENGTH_SHORT).show();
            return;
        }

        StringBuilder steps = new StringBuilder();
        int current = Integer.parseInt(input);
        int stepCount = 0;

        while (current != 6174) {
            String padded = String.format("%04d", current);
            char[] digits = padded.toCharArray();
            Arrays.sort(digits);

            int smallest = Integer.parseInt(new String(digits));
            int largest  = Integer.parseInt(new StringBuilder(new String(digits)).reverse().toString());

            int next = largest - smallest;
            stepCount++;

            steps.append("Step ").append(stepCount).append(":  ")
                    .append(String.format("%04d", largest))
                    .append(" - ")
                    .append(String.format("%04d", smallest))
                    .append(" = ")
                    .append(String.format("%04d", next))
                    .append("\n");

            current = next;
            if (stepCount > 10) break;
        }

        tvSteps.setText(steps.toString());
        tvResult.setText("✓ Reached 6174 in " + stepCount + " steps!");
    }
}