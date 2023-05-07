package com.example.tffifinder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class EditInfo extends AppCompatActivity {
    String[] items = new String[]{"Male", "Female"};
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_info);

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

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, items);
        AutoCompleteTextView textView = findViewById(R.id.autoCompleteTextView);
        textView.setAdapter(adapter);

        editText = findViewById(R.id.editText);

        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    showDatePickerDialog();
                }
            }
        });

    }


    public void setSupportActionBar(Toolbar myToolbar) {
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