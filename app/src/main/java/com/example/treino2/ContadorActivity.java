package com.example.treino2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ContadorActivity extends AppCompatActivity {
    Button btnContador;
    TextView tvContador;
    int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_contador);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnContador = findViewById(R.id.btn_count);
        tvContador = findViewById(R.id.tv_contador);
        Intent intent = getIntent();
        count = intent.getIntExtra("contador",0);
        Toast.makeText(this,"" + count,Toast.LENGTH_LONG).show();

        tvContador.setText(String.valueOf(count));
        Log.i("Contador","contador value"+ count);

        btnContador.setOnClickListener( v -> {
             count+=1;
             tvContador.setText(String.valueOf(count));
        });

    }


}