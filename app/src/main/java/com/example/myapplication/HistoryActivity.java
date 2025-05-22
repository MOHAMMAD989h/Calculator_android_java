package com.example.myapplication;

import static com.example.myapplication.MainActivity.dataHistory;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class HistoryActivity extends AppCompatActivity {
    TextView textView;

    Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.history_layout);

        textView = findViewById(R.id.textView);


        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        String savedData = sharedPreferences.getString("myKey", dataHistory);

        textView.setText(savedData);

        backBtn = findViewById(R.id.backBtn);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HistoryActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

}
