package com.example.jeligram;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RgtrdobActivity extends AppCompatActivity {

    private EditText DateOfBirth;
    private ImageView backButton;
    private Button nextButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_rgtrdob);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        DateOfBirth = findViewById(R.id.DateOfBirth);
        nextButton = findViewById(R.id.NextButton);
        backButton = findViewById(R.id.BackButton);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dateofbirth = DateOfBirth.getText().toString();

                if (dateofbirth.isEmpty()){
                    Toast.makeText(RgtrdobActivity.this, "Enter DOB", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent = new Intent(RgtrdobActivity.this, HomeActivity.class);
                    startActivity(intent);
                }
            }
        });
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RgtrdobActivity.this, RgtrnameActivity.class);
                startActivity(intent);
            }
        });
    }
}