package cn.truthvision.stopsignproject;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Main extends Activity {

    RadioButton a1;
    RadioButton a2;
    RadioButton a3;
    RadioButton b1;
    RadioButton b2;
    RadioButton c1;
    RadioButton c2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button record = (Button) findViewById(R.id.homebutton);
        record.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                beginRecord(v);
            }
        });

        Button mapb = (Button) findViewById(R.id.cloudbutton);
        mapb.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                openAdvSettings(v);
            }
        });


        //Convert rad button to id, somehow radgroup has no id
        a1 = (RadioButton) findViewById(R.id.radioButton);
        a2 = (RadioButton) findViewById(R.id.radioButton2);
        a3 = (RadioButton) findViewById(R.id.radioButton3);


        b1 = (RadioButton) findViewById(R.id.adddatabase);
        b2 = (RadioButton) findViewById(R.id.realtime);

        c1 = (RadioButton) findViewById(R.id.accessdb);
        c2 = (RadioButton) findViewById(R.id.noaccess);



    }

    private void openAdvSettings(View v) {
        Intent i = new Intent(this, AdvancedSettings.class);
        startActivity(i);
    }

    public void beginRecord(View v){
        Intent intent = new Intent(this, Home.class);

        int RecOptions = 1;
        int SaveOptions = 1;
        int DBOptions = 1;

        if(a1.isChecked())
            RecOptions = 1;
        else if(a2.isChecked())
            RecOptions = 2;
        else
            RecOptions = 3;

        if(b1.isChecked())
            SaveOptions = 1;
        else
            SaveOptions = 2;

        if(c1.isChecked())
            DBOptions = 1;
        else
            DBOptions = 2;

        intent.putExtra("Record", RecOptions);
        intent.putExtra("Save", SaveOptions);
        intent.putExtra("Database", DBOptions);
        startActivity(intent);

    }

    public void openVideo(View v){
        Intent intent = new Intent(this, SavedVideo.class);

        startActivity(intent);
    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){

    }


}
