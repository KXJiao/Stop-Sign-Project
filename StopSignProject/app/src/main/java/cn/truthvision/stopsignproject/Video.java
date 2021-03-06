package cn.truthvision.stopsignproject;

import android.app.Activity;
import android.content.Intent;
import android.media.audiofx.BassBoost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Video extends Activity {
    private int RecOptions = 1;
    private int SaveOptions = 1;
    private int DBOptions = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        Intent i = getIntent();

        RecOptions = i.getIntExtra("Record",1);
        SaveOptions = i.getIntExtra("Save",1);
        DBOptions = i.getIntExtra("Database",1);

        Button nr = (Button) findViewById(R.id.start_recording);
        nr.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startRecording(view);
            }
        });

        Button sv = (Button) findViewById(R.id.button4);
        sv.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                openSavedVideos(view);
            }
        });

        Button settings = (Button) findViewById(R.id.button5);
        settings.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                openSettings(view);
            }
        });
    }

    private void openSettings(View view) {
        Intent i = new Intent(this, Main.class);

        i.putExtra("Record", RecOptions);
        i.putExtra("Save", SaveOptions);
        i.putExtra("Database", DBOptions);

        startActivity(i);
    }

    private void openSavedVideos(View view) {
        Intent i = new Intent(this, SavedVideo.class);

        startActivity(i);
    }

    private void startRecording(View view) {
        Intent i = new Intent(this, AutoRecording.class);

        startActivity(i);
    }
}
