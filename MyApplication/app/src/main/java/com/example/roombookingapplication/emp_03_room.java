package com.example.roombookingapplication;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Calendar;

public class emp_03_room extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.emp_03_room);

        Intent intent = getIntent();
        String roomType = intent.getStringExtra("roomType");
        String roomName = intent.getStringExtra("roomName");

        TextView textView = findViewById(R.id.textView);
        textView.setText(roomName + " " + roomType);

        Button btnDateInput = findViewById(R.id.btnDateInput);

        btnDateInput.setOnClickListener(v -> {
            DialogFragment dateFragment = new DatePickerFragment();
            dateFragment.show(getSupportFragmentManager(), "datePicker");
        });

        Button btnBack = findViewById(R.id.btnBack);
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        btnDateInput.setText(day + "/" + (month + 1) + "/" + year);

        btnBack.setOnClickListener(v -> {
            finish();
        });

        Button btnAccount = findViewById(R.id.btnAccount);
        btnAccount.setOnClickListener(v -> {
            finish();
        });

        Button btnBook = findViewById(R.id.btnBook);
        btnBook.setOnClickListener(v -> {
            Intent intent2 = new Intent(this, emp_04_book.class);
            startActivity(intent2);
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ArrayList<TimeSlot> timeSlots = new ArrayList<>();
        timeSlots.add(new TimeSlot("8:00 - 9:00", false));
        timeSlots.add(new TimeSlot("9:00 - 10:00", true));
        timeSlots.add(new TimeSlot("10:00 - 11:00", false));
        timeSlots.add(new TimeSlot("11:00 - 12:00", false));
        timeSlots.add(new TimeSlot("12:00 - 13:00", true));
        timeSlots.add(new TimeSlot("13:00 - 14:00", false));
        timeSlots.add(new TimeSlot("14:00 - 15:00", false));
        timeSlots.add(new TimeSlot("15:00 - 16:00", false));
        timeSlots.add(new TimeSlot("16:00 - 17:00", true));
        timeSlots.add(new TimeSlot("17:00 - 18:00", false));


        RecyclerView timeSlotView = findViewById(R.id.timeSlotView);
        timeSlotView.setLayoutManager(new LinearLayoutManager(this));
        timeSlotView.setAdapter(new TimeSlotAdapter(timeSlots));
    }

    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker.
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it.
            return new DatePickerDialog(requireContext(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            Button btnDateInput = getActivity().findViewById(R.id.btnDateInput);
            btnDateInput.setText(day + "/" + (month + 1) + "/" + year);
        }


    }

}

