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

public class RgtrnameActivity extends AppCompatActivity {

    private EditText firstname, lastname;
    private Button nextbutton;
    private ImageView backButton;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_rgtrname);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        firstname = findViewById(R.id.FirstName);
        lastname = findViewById(R.id.LastName);
        nextbutton = findViewById(R.id.NextButton);
        backButton = findViewById(R.id.BackButton);

        nextbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String FirstName = firstname.getText().toString();
                String LastName = lastname.getText().toString();

                if (FirstName.isEmpty() || LastName.isEmpty()){
                    Toast.makeText(RgtrnameActivity.this, "Fill your name", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(RgtrnameActivity.this, RgtrdobActivity.class);
                    startActivity(intent);
                }
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RgtrnameActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}