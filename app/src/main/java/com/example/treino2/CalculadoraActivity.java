package com.example.treino2;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CalculadoraActivity extends AppCompatActivity {

    Button btnSum,btnMinus,btnMult,btnDiv;
    TextView tvResult;
    EditText editFirstNum,editSecondNum;
    String firstNum,secondNum;
    Double num1,num2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculadora);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        num1=num2=0.0;

        btnSum = findViewById(R.id.btn_sum);
        btnMinus = findViewById(R.id.btn_minus);
        btnMult = findViewById(R.id.btn_mult);
        btnDiv = findViewById(R.id.btn_div);

        tvResult = findViewById(R.id.tv_result);

        editFirstNum = findViewById(R.id.edit_first_num);
        editSecondNum = findViewById(R.id.edit_second_num);

        firstNum = editFirstNum.getText().toString().trim();
        Log.i("CalculadoraActivity",firstNum);
        secondNum = editSecondNum.getText().toString().trim();
        Log.i("CalculadoraActivity",secondNum);
        try {
            num1 = Double.parseDouble(firstNum);
            num2 = Double.parseDouble(secondNum);
        } catch (NumberFormatException e ) {
            Toast.makeText(this,"Invalid Number",Toast.LENGTH_SHORT).show();
        }

        setButtonListener();

    }
    public void setButtonListener(){
        btnSum.setOnClickListener(v -> calculate("+"));
        btnMinus.setOnClickListener(v -> calculate("-"));
        btnMult.setOnClickListener(v -> calculate("*"));
        btnDiv.setOnClickListener(v -> calculate("/"));
    }

    public void ResetEditText(){
        editFirstNum.getText().clear();
        editSecondNum.getText().clear();
    }
    public void calculate(String operator){
        try {
            num1 = Double.parseDouble(editFirstNum.getText().toString().trim());
            num2 = Double.parseDouble(editSecondNum.getText().toString().trim());
        }catch (NumberFormatException e ){
            Toast.makeText(this, "Invalid number format!", Toast.LENGTH_SHORT).show();
            return;
        }

        double result = 0.0;
                switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 == 0) {
                    Toast.makeText(this, "Division by zero!", Toast.LENGTH_SHORT).show();
                    return;
                }
                result = num1 / num2;
                break;
        }

        // Display the result
        tvResult.setText(String.valueOf(result));
    }
}