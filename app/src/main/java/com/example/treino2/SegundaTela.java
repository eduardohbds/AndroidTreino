package com.example.treino2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SegundaTela extends AppCompatActivity {
    TextView tvCalculadora;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_segunda_tela);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvCalculadora = findViewById(R.id.tv_Calculadora);

        Intent intent = getIntent();
        if(intent.hasExtra("contador")){
            int dadoRecebido = intent.getIntExtra("contador",0);
            Toast.makeText(getApplicationContext(),"Received data: " + dadoRecebido,Toast.LENGTH_LONG).show();
            tvCalculadora.setText(String.valueOf(dadoRecebido));
        }

    }
}