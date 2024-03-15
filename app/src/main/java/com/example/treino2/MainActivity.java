package com.example.treino2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnContador,btnCalculadora;
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
        tvContador = findViewById(R.id.tv_contador);
        btnCalculadora = findViewById(R.id.btn_calculadora);
        btnContador = findViewById(R.id.btn_contador);

        btnContador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contador++;
                tvContador.setText(String.valueOf(contador));
            }
        });
        btnCalculadora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChamaSegundaTela();
            }
        });
    }
    public void ChamaSegundaTela(){
        Intent intentChamaCalculadora = new Intent(MainActivity.this,SegundaTela.class);
        intentChamaCalculadora.putExtra("contador",contador);
        startActivity(intentChamaCalculadora);
    }
}