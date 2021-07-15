package com.example.lescontacts;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class AppelVocal extends AppCompatActivity {
  private EditText phone;
  private ImageButton call;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appel_vocal);
        phone =  findViewById(R.id.number);
       call= findViewById(R.id.call);
       call.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String phoneNumber=phone.getText().toString();
               Intent intent=new Intent(Intent.ACTION_CALL);
               intent.setData(Uri.parse("tel"+phoneNumber));
               startActivity(intent);
           }
       });
    }
}