package com.example.lescontacts;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
 Timer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recupContacts();
        timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent=new Intent(MainActivity.this,AppelVocal.class);
                startActivity(intent);
                finish();
            }
        },4000);
    }
    public void recupContacts(){
        ContentResolver contentResolver=this.getContentResolver();
        Cursor cursor=contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                new String[]{ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME_ALTERNATIVE,
                        ContactsContract.CommonDataKinds.Phone.NUMBER},null, null,null);
        if (cursor==null){
            Log.d("recup","********* erreur curseur");
        }
        else{
            EditText txtContacts=(EditText) findViewById(R.id.txtContacts);
            while (cursor.moveToNext()==true){
                String name =cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME_ALTERNATIVE));
                String phone =cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                txtContacts.setText(txtContacts.getText().toString()+"\n\r"+name+ " : "+phone);
            }
            cursor.close();
        }
    }
}