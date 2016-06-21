package com.example.android.sendsms;

import android.Manifest;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    EditText eTextMsg,eTextMblNumber;
    Button btnSendSMS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eTextMblNumber=(EditText) findViewById(R.id.etextMblNumber);
        eTextMsg=(EditText)findViewById(R.id.etextMsg);
        btnSendSMS=(Button) findViewById(R.id.btnSendSMS);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, 1);


    }

    public void sendSMS(View view){

        SmsManager sm= SmsManager.getDefault();
        String number=eTextMblNumber.getText().toString();
        String msg=eTextMsg.getText().toString();
        sm.sendTextMessage(number,null,msg,null,null);
    }
}
