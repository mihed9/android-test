package com.vaultinnovation.androidcodetest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ArrayAdapter arrayAdapter;
    private List<String> messageList = new ArrayList<>();
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createListView();
        createArrayAdapter(messageList);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messageList.add(getTextFromEditField());
                clearEditField();
                Collections.sort(messageList);
                arrayAdapter.notifyDataSetChanged();
            }
        });
    }

    private String getTextFromEditField() {
        return ((EditText) findViewById(R.id.editText)).getText().toString();
    }

    private void clearEditField() {
        ((EditText) findViewById(R.id.editText)).setText("");
    }

    private void createListView() {
        listView = (ListView) findViewById(R.id.listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1,
                                    int position, long arg3) {
                String message = ((TextView) arg1.findViewById(R.id.message)).getText().toString();
                startTextActivity(message);
            }
        });
    }

    private void startTextActivity(String message) {
        Intent i = new Intent(this, TextActivity.class);
        i.putExtra("MESSAGE", message);
        startActivity(i);
    }

    private void createArrayAdapter(List<String> data) {
        arrayAdapter = new ArrayAdapter(this, R.layout.activity_text, R.id.message, data);
        listView.setAdapter(arrayAdapter);
    }
}
