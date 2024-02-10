package com.example.atakhodzhaev_akbar_m3_hw1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.net.URI;

public class MainActivity extends AppCompatActivity {
    private Button send;
    private EditText etTo,etTheme,etMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etTo=findViewById(R.id.Email);
        etTheme=findViewById(R.id.Theme);
        etMessage=findViewById(R.id.Message);
        send=findViewById(R.id.Send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String To=etTo.getText().toString();
                String Theme=etTheme.getText().toString();
                String Message=etMessage.getText().toString();

                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL,new String[]{To});
                email.putExtra(Intent.EXTRA_SUBJECT,Theme);
                email.putExtra(Intent.EXTRA_TEXT,Message);
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Choose an Email client :"));
            }
        });
    }
}