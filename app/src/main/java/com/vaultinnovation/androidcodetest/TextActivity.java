package com.vaultinnovation.androidcodetest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class TextActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String message = extras.getString("MESSAGE");
            ((TextView) findViewById(R.id.message)).setText(message);
        }
    }
}
