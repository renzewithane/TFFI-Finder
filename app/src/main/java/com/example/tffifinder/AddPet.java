package com.example.tffifinder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;

public class AddPet extends AppCompatActivity {

    EditText editText;
    TextInputEditText pname, breed, weight, allergies, treats, meds, vetName, vetContact;
    Button add;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pet);

        editText = findViewById(R.id.bdate);

        pname = findViewById(R.id.petName);
        breed = findViewById(R.id.breed);
        weight = findViewById(R.id.weight);
        allergies = findViewById(R.id.allergies);
        treats = findViewById(R.id.treats);
        meds = findViewById(R.id.medications);
        vetName = findViewById(R.id.vetName);
        vetContact = findViewById(R.id.vet_contact);
        add = findViewById(R.id.submit);

        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        // Set the custom back arrow as the navigation icon
        myToolbar.setNavigationIcon(R.drawable.ic_arrow_back);

        // Set a click listener on the navigation icon
        myToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(AddPet.this);
                myDB.addPet(pname.getText().toString().trim(),
                        breed.getText().toString().trim(),
                        Integer.valueOf(editText.getText().toString().trim()),
                        Integer.valueOf(weight.getText().toString().trim()),
                        allergies.getText().toString().trim(),
                        treats.getText().toString().trim(),
                        meds.getText().toString().trim(),
                        vetName.getText().toString().trim(),
                        vetContact.getText().toString().trim());
            }
        });

        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    showDatePickerDialog();
                }
            }
        });
    }
    private void showDatePickerDialog() {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        // Update the text of the EditText with the selected date
                        editText.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                    }
                }, year, month, dayOfMonth);

        // Show the dialog
        datePickerDialog.show();
    }
}