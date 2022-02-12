package com.example.time_dialog;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnSelectTime;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnSelectTime=(Button)findViewById(R.id.btnTime);
        btnSelectTime.setOnClickListener(this);
    }

    public void onClick(View v)
    {
        if(v==btnSelectTime)
        {
            Calendar systemCalendar = Calendar.getInstance();

            int hour = systemCalendar.get(Calendar.HOUR_OF_DAY);
            int minute = systemCalendar.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(this,new SetYourTime(),hour,minute,true);
            timePickerDialog.show();;

        }


    }



    public class  SetYourTime implements TimePickerDialog.OnTimeSetListener
    {

        public void onTimeSet (TimePicker view, int hourOfDay, int minute)
        {
            String str = "Time is :" + hourOfDay +":" + minute;
            
            btnSelectTime.setText(str);

        }
    }
}