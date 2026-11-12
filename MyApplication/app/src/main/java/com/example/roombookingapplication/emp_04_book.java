package com.example.roombookingapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class emp_04_book extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.emp_04_book);

        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> {
            finish();
        });

        Button btnAccount = findViewById(R.id.btnAccount);
        btnAccount.setOnClickListener(v -> {
            finish();
        });

        Button btnBook = findViewById(R.id.btnBook);
        btnBook.setOnClickListener(v -> {

            boolean missingData = true;

                    if (missingData == false) {
                        Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "Booking confirmed", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(this, emp_01_dashboard.class);
                        startActivity(intent);
                    }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}