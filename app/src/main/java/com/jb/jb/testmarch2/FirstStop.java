package com.jb.jb.testmarch2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class FirstStop extends Activity {
    private String a;
    private String b;
    private String c;
    private Button arrivedFirstStop;
    private Button departedFirstStop;
    private EditText enteredTrailer;
    private TextView truckTextview;
    private TextView trailerTextview;
    private CheckBox checkBox;
    private EditText notesEditText;
    private TextView userIdStop1;
    private String intentUserId;
    private String intentTrailerNumber;
    private String intentTruckNumber;
    private String intentNewTrailerNumber;
    //edit this to correct server address and update to correct php file
//private static String url_create_product = "http://192.168.0.6:1337/ctxtrack/.php";
//private static String url_create_product = "http://localhost/ctxtrack/.php";
//private static String url_create_product = "http://192.168.56.101/ctxtrack/.php";
    private static String url_create_product = "http://192.168.56.1:1337/ctxtrack/first_stop.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_stop);
        arrivedFirstStop = (Button) findViewById(R.id.arrivedFirstStop);
        departedFirstStop = (Button) findViewById(R.id.departedFirstStop);
        enteredTrailer = (EditText) findViewById(R.id.enterTrailerEditText);
        truckTextview = (TextView) findViewById(R.id.truckNumID);
        trailerTextview = (TextView) findViewById(R.id.trailerNumID);
        checkBox = (CheckBox) findViewById(R.id.checkBox);
        notesEditText = (EditText) findViewById(R.id.notes);
        userIdStop1 = (TextView) findViewById(R.id.userIdStop1);
        Intent intent = getIntent();{
            a = intent.getStringExtra("intentTruckNumber");
            b = intent.getStringExtra("intentTrailerNumber");
            c = intent.getStringExtra("intentUserId");
            truckTextview.setText(a);
            trailerTextview.setText(b);
            userIdStop1.setText(c);
        }
        if(intent != null)
            arrivedFirstStop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), R.string.arrival_time_submitted, Toast.LENGTH_LONG).show();
                    checkBox.setChecked(true);
                }
            });
        departedFirstStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), R.string.departure_time_submitted, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(FirstStop.this, SecondStop.class);
                intentTruckNumber = truckTextview.getText().toString();
                intentTrailerNumber = trailerTextview.getText().toString();
//use trim();????
                intentNewTrailerNumber = enteredTrailer.getText().toString();
                intentUserId = userIdStop1.getText().toString();
//EditText editText = (EditText) findViewById(R.id.edit_message);
//String message = enteredTrailer.getText().toString();
                intent.putExtra("intentTrailerNumber", intentTrailerNumber);
                intent.putExtra("intentTruckNumber", intentTruckNumber);
                intent.putExtra("intentNewTrailerNumber", intentNewTrailerNumber);
                intent.putExtra("intentUserId", intentUserId);
                startActivity(intent);
            }
        });
//startService(new Intent(this, AndroidLocationService.class));
    }
}