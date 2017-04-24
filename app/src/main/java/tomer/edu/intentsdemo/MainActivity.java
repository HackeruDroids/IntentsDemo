package tomer.edu.intentsdemo;

import android.content.Intent;
import android.net.Uri;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_USER_NAME = "UserName";

    EditText etName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName = (EditText) findViewById(R.id.etName);
    }

    public void toDetails(View view) {
        //1) Intent
        //Context...
        Intent detailsIntent = new Intent(this, DetailsActivity.class);

        //2) Put Some Extras...:
        //Send Data From Activity A To Activity B -> Using the Intent.putExtra(key, value)
        detailsIntent.putExtra(EXTRA_USER_NAME, etName.getText().toString());
        detailsIntent.putExtra("Sender", "MainActivity");
        detailsIntent.putExtra("Age", 24);

        //3) startActivity...
        startActivity(detailsIntent);
    }

    public void ynet(View view) {
        //Intent...

//        String u = "http://www.ynet.co.il/home/0,7340,L-8,00.html";
//        Uri uri = Uri.parse(u);
        Intent ynetIntent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("http://www.ynet.co.il/home/0,7340,L-8,00.html")
        );

        startActivity(ynetIntent);

        //startActivity...
    }

    public void dial(View view) {
        //Intent...
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:0507123012"));

        //startActivity...
        startActivity(intent);
    }

    public void setAlarm(View view) {
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);

        //put some extras...
        intent.putExtra(AlarmClock.EXTRA_HOUR, 13);
        intent.putExtra(AlarmClock.EXTRA_MINUTES, 23);
        intent.putExtra(AlarmClock.EXTRA_MESSAGE, "Play Soccer");

        startActivity(intent);
    }
}
