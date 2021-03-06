package cn.truthvision.stopsignproject;

import android.app.Activity;
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
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SavedVideo extends Activity {

    private String[] videoArray = new String[20];
    private ListView listView;
    private ArrayAdapter<String> adapter;
    File[] frames;
    File[] temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_savedvid);

        Intent i = getIntent();

        /*listView = (ListView) findViewById(android.R.id.list);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, videoArray);
        listView.setAdapter(adapter);*/
        String root = Environment.getExternalStorageDirectory().toString();
        //File myDir = new File(root + "/Pictures/StopSignVidFrames");
        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "StopSignVidStore");

        LinearLayout ll = (LinearLayout)findViewById(R.id.linearLayout23);
        //LinearLayout ll2 = (LinearLayout) findViewById(R.id.linearLayout4);
        //LinearLayout timeLayout = (LinearLayout) findViewById(R.id.linearLayouttime);
        LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);

        //ll.addView(dataTable, lp);



        temp = mediaStorageDir.listFiles();


        if(mediaStorageDir.listFiles()!= null && mediaStorageDir.listFiles().length>0) {
            for (int x = 0; x < mediaStorageDir.listFiles().length; x++) {
                String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH-mm-ss").format(new Date());
                Button timeButton = new Button(this);
                timeButton.setText("" + timeStamp);
                Button myButton = new Button(this);
                myButton.setText(temp[x].getName() + "");
                final String path = temp[x].getAbsolutePath() + "";
                myButton.setOnClickListener(new View.OnClickListener() {

                    public void onClick(View view) {
                        viewVideo(view, path);
                    }
                });
                ll.addView(myButton, lp);
                //timeLayout.addView(timeButton, lp);
            }
        }
        /*for(int x=0; x < myDir.listFiles().length; x++) {
            Button button2 = new Button(this);
            button2.setText(frames[x].getName() + "");
            final String path = frames[x].getAbsolutePath() + "";
            button2.setOnClickListener(new View.OnClickListener(){

                public void onClick(View view){

                }
            });

            ll2.addView(button2, lp);

        }*/

        Button settings = (Button) findViewById(R.id.settingsbutton3);
        settings.setOnClickListener(new View.OnClickListener(){
           @Override
            public void onClick(View view){
               openSettings(view);
           }
        });

        Button vid = (Button) findViewById(R.id.button7);
        vid.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                openData(view);
            }
        });

    }
    
    public void openSettings(View view){
        Intent intent = new Intent(this, Main.class);
        startActivity(intent);
        //finish();
    }

    public void openData(View view){
        Intent intent = new Intent(this, SavedData.class);
        startActivity(intent);
        //finish();
    }

    private void viewVideo(View v, String ur) {
        Intent intent = new Intent(this, VideoPlayer.class);
        intent.putExtra("URI", ur);
        startActivity(intent);
    }

}
