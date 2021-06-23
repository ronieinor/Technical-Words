package com.technicalwords;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import database.DBHandler;

public class AddSection extends AppCompatActivity {

    EditText edWord, edDefine;
    DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_section);

        edWord = findViewById(R.id.title);
        edDefine = findViewById(R.id.content);

        dbHandler = new DBHandler(this);
    }
    public void btnAdd(View v){

        String titles = edWord.getText().toString();
        String contents = edDefine.getText().toString();

        boolean  status = dbHandler.addWord(titles,contents);

        if (status)
            Toast.makeText(this, "Inserted Successfully", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Insert Failed", Toast.LENGTH_SHORT).show();


    }
}
