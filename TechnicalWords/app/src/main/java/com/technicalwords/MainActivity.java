package com.technicalwords;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    public EditText word;
    public Button search;
    public TextView result_definition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        word=findViewById(R.id.words);
        search=findViewById(R.id.search_button);
        result_definition=findViewById(R.id.result);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatabaseAccess databaseAccess= DatabaseAccess.getInstance(getApplicationContext());
                databaseAccess.open();

                String w = word.getText().toString();
                String definition = databaseAccess.getDefinition(w);

                result_definition.setText(definition);

                databaseAccess.close();
            }
        });

    }

    public void add(View view) {
        Intent intent = new Intent(this, AddSection.class);
        startActivity(intent);
    }
}