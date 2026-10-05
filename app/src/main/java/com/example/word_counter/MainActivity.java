package com.example.word_counter;

import static android.widget.Toast.LENGTH_LONG;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    EditText editText;

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
        editText = findViewById(R.id.editTextText);
        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.selection,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    public void counting(View view) {
        Toast.makeText(this, spinner.getSelectedItem().toString(), LENGTH_LONG).show();
        TextView text = findViewById(R.id.textView);
        String input = editText.getText().toString();
        String option = spinner.getSelectedItem().toString();
        if (input.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Nothing written", Toast.LENGTH_SHORT).show();
            return;
        }
            int count = 0;
            switch (option) {
                case "Sentences":
                    count = Counter.countSentences(input);
                    break;
                case "Words":
                    count = Counter.countWords(input);
                    break;
                case "Characters":
                    count = Counter.countChars(input);
                    break;
            }

            text.setText("There is: " + count);
    }
}