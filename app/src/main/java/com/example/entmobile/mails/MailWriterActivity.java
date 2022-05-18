package com.example.entmobile.mails;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.entmobile.R;

public class MailWriterActivity extends AppCompatActivity {

    private EditText email_destination;
    private EditText email_subject;
    private EditText email_content;
    private Button send_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mails);

        //Associates the local variables to their correspondence in the view
        email_destination = findViewById(R.id.txtTo);
        email_subject = findViewById(R.id.txtSub);
        email_content = findViewById(R.id.txtMsg);
        send_button = findViewById(R.id.btnSend);

        //Sets up the Send button listener
        send_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creates a new intent
                Intent it = new Intent(Intent.ACTION_SEND);
                //Adds the mail's data to the intent
                it.putExtra(Intent.EXTRA_EMAIL, new String[]{email_destination.getText().toString()});
                it.putExtra(Intent.EXTRA_SUBJECT, email_subject.getText().toString());
                it.putExtra(Intent.EXTRA_TEXT, email_content.getText());
                it.setType("message/rfc822");

                //Starts the activity with the preset intent
                startActivity(Intent.createChooser(it,"Choose Mail App"));
            }
        });
    }
}