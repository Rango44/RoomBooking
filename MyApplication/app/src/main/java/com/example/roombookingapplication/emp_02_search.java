package com.example.roombookingapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class emp_02_search extends AppCompatActivity {

    private String roomType;
    private String roomName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.emp_02_search);

        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> {
            finish();
        });

        Button btnAccount = findViewById(R.id.btnAccount);
        btnAccount.setOnClickListener(v -> {
            finish();
        });

        Button btnSem1 = findViewById(R.id.btnSem1);
        btnSem1.setOnClickListener(v -> {
            roomType = "Seminar room";
            roomName = "Charles";
            Intent intent = new Intent(this, emp_03_room.class);
            intent.putExtra("roomType", roomType);
            intent.putExtra("roomName", roomName);
            startActivity(intent);
        });

        Button btnSem2 = findViewById(R.id.btnSem2);
        btnSem2.setOnClickListener(v -> {
            roomType = "Seminar room";
            roomName = "Levinsky";
            Intent intent = new Intent(this, emp_03_room.class);
            intent.putExtra("roomType", roomType);
            intent.putExtra("roomName", roomName);
            startActivity(intent);
        });


        Button btnMeet1 = findViewById(R.id.btnMeet1);
        btnMeet1.setOnClickListener(v -> {
            roomType = "Meeting room";
            roomName = "Rolle";
            Intent intent = new Intent(this, emp_03_room.class);
            intent.putExtra("roomType", roomType);
            intent.putExtra("roomName", roomName);
            startActivity(intent);
        });

        Button btnMeet2 = findViewById(R.id.btnMeet2);
        btnMeet2.setOnClickListener(v -> {
            roomType = "Meeting room";
            roomName = "Babbage";
            Intent intent = new Intent(this, emp_03_room.class);
            intent.putExtra("roomType", roomType);
            intent.putExtra("roomName", roomName);
            startActivity(intent);
        });


        Button btnMeet3 = findViewById(R.id.btnMeet3);
        btnMeet3.setOnClickListener(v -> {
            roomType = "Meeting room";
            roomName = "Smeaton";
            Intent intent = new Intent(this, emp_03_room.class);
            intent.putExtra("roomType", roomType);
            intent.putExtra("roomName", roomName);
            startActivity(intent);
        });

        Button btnMeet4 = findViewById(R.id.btnMeet4);
        btnMeet4.setOnClickListener(v -> {
            roomType = "Meeting room";
            roomName = "Library";
            Intent intent = new Intent(this, emp_03_room.class);
            intent.putExtra("roomType", roomType);
            intent.putExtra("roomName", roomName);
            startActivity(intent);
        });

        Button btnMeet5 = findViewById(R.id.btnMeet5);
        btnMeet5.setOnClickListener(v -> {
            roomType = "Meeting room";
            roomName = "Portland";
            Intent intent = new Intent(this, emp_03_room.class);
            intent.putExtra("roomType", roomType);
            intent.putExtra("roomName", roomName);
            startActivity(intent);
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}