package com.example.treino2;

import android.content.Intent;
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

public class MainActivity extends AppCompatActivity {

    Button btnContador,btnCalculadora;
    EditText edtContador;
    TextView tvContador;
    int contador = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnCalculadora = findViewById(R.id.btn_calculadora);
        btnContador = findViewById(R.id.btn_contador);
        edtContador = findViewById(R.id.edt_contador);


        btnContador.setOnClickListener(v -> ChamaContadorTela());
        btnCalculadora.setOnClickListener(v -> ChamaCalculadoraActivity());

    }
    public void ChamaSegundaTela(){
        Intent intentChamaCalculadora = new Intent(MainActivity.this,SegundaTela.class);
        intentChamaCalculadora.putExtra("contador",contador);
        startActivity(intentChamaCalculadora);
    }
    public void ChamaCalculadoraActivity(){
        Intent intent = new Intent(MainActivity.this, CalculadoraActivity.class);
        startActivity(intent);
    }
    public void ChamaContadorTela(){
        contador = Integer.parseInt(edtContador.getText().toString().trim());
        Intent intentChamaContador = new Intent(MainActivity.this, ContadorActivity.class);
        intentChamaContador.putExtra("contador",contador);
        Toast.makeText(this,"" + contador,Toast.LENGTH_LONG).show();
        Log.i("Contador","contador value"+ contador);
        startActivity(intentChamaContador);
    }
}