package com.example.testexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewJournalActivity extends AppCompatActivity {

    private EditText journalName;
    private  EditText date;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_journal);
        final Button button = findViewById(R.id.button);
        journalName=findViewById(R.id.journal);
        date=findViewById(R.id.date);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(journalName.getText())||TextUtils.isEmpty(date.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    String journal = journalName.getText().toString();
                    replyIntent.putExtra("journal", journal);
                    String datejournal = date.getText().toString();
                    replyIntent.putExtra("date", datejournal);

                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });

    }

}