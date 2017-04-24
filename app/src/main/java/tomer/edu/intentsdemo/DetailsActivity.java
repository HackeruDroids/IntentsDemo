package tomer.edu.intentsdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
}
