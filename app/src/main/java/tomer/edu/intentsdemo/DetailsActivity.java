package tomer.edu.intentsdemo;

import android.content.Intent;
import android.os.Build;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;

public class DetailsActivity extends AppCompatActivity implements TimePicker.OnTimeChangedListener {
    TimePicker picker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        //1) get The Intent:
        Intent intent = getIntent();

        //2) get The Extras:
        String userName = intent.getStringExtra(MainActivity.EXTRA_USER_NAME);

        Toast.makeText(this, "Hello, " + userName, Toast.LENGTH_LONG).show();


        picker = (TimePicker) findViewById(R.id.timePicker);
        picker.setOnTimeChangedListener(this);
    }

    @Override
    public void onTimeChanged(TimePicker timePicker, int hour, int minutes) {
        //

    }

    //<uses-permission ...
    // <uses-permission android:name="com.android.alarm.permission.SET_ALARM" />

    public void createAlarm(String message, int hour, int minutes) {
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, message)
                .putExtra(AlarmClock.EXTRA_HOUR, hour)
                .putExtra(AlarmClock.EXTRA_SKIP_UI , true)
                .putExtra(AlarmClock.EXTRA_MINUTES, minutes);


        if (intent.resolveActivity(getPackageManager()) != null)
            startActivity(intent);
    }

    public void setAlarm(View view) {
        int hour = 0;
        int minutes = 0;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            hour = picker.getHour();
            minutes = picker.getMinute();
        }else{
            hour = picker.getCurrentHour();
            minutes = picker.getCurrentHour();
        }



        createAlarm("Yoga Class", hour, minutes);
    }
}
