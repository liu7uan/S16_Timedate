package com.aq.s16_timedate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    private TimePicker firstTimePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstTimePicker = (TimePicker) findViewById(R.id.firstTimer);
        TimeListerner tl1=new TimeListerner();
        firstTimePicker.setOnTimeChangedListener(tl1);
        firstTimePicker.setIs24HourView(true);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new ButtonListenner());

    }

    class ButtonListenner implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            int hour = firstTimePicker.getCurrentHour();
            int minute = firstTimePicker.getCurrentMinute();
            System.out.println("h:" + hour + "m:" + minute);
        }
    }

    class TimeListerner implements TimePicker.OnTimeChangedListener {

        /* view:  TimePicker owin
         hourofDay :select date    of day
         minute:select minute*/
        @Override
        public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
            System.out.println("Hour" + hourOfDay + ",minute:" + minute);
        }
    }
}
