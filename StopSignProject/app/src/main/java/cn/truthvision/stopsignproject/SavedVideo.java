package cn.truthvision.stopsignproject;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.support.v7.app.ActionBar.LayoutParams;

import java.io.File;

public class SavedVideo extends AppCompatActivity {

    private String[] videoArray = new String[20];
    private ListView listView;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_savedvid);

        Intent i = getIntent();

        /*listView = (ListView) findViewById(android.R.id.list);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, videoArray);
        listView.setAdapter(adapter);*/

        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "StopSignVidStore");


        LinearLayout ll = (LinearLayout)findViewById(R.id.linearLayout23);
        LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);

        File[] temp = mediaStorageDir.listFiles();
        for(int x = 0; x < mediaStorageDir.listFiles().length; x++){
            //Toast.makeText(this, temp[x].toURI() + "", Toast.LENGTH_LONG).show();
            Button myButton = new Button(this);
            myButton.setText(temp[x].getName()+"");
            final String uri = temp[x].toURI()+"";
            final String path = temp[x].getAbsolutePath()+"";
            myButton.setOnClickListener(new View.OnClickListener() {

                public void onClick(View view) {
                    viewVideo(view, path);
                }
            });

            ll.addView(myButton, lp);
        }


        Button settings = (Button) findViewById(R.id.settingsbutton3);
        settings.setOnClickListener(new View.OnClickListener(){
           @Override
            public void onClick(View view){
               openSettings(view);
           }
        });

    }
    
    public void openSettings(View view){
        Intent intent = new Intent(this, Main.class);
        startActivity(intent);
        //finish();
    }

    private void viewVideo(View v, String ur) {
        Intent intent = new Intent(this, VideoPlayer.class);
        intent.putExtra("URI", ur);
        startActivity(intent);
    }

}
