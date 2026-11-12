package com.example.roombookingapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Button;

public class auth_01_select extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.auth_01_select);

        Button btnEmployee = findViewById(R.id.btnEmployee);
        Button btnManager = findViewById(R.id.btnManager);

        btnEmployee.setOnClickListener(v -> {
            Intent intent = new Intent(this, auth_02_login.class);
            intent.putExtra("Role", "Employee");
            startActivity(intent);
        });

        btnManager.setOnClickListener(v -> {
            Intent intent = new Intent(this, auth_02_login.class);
            intent.putExtra("Role", "Manager");
            startActivity(intent);
        });





        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


}