package cn.truthvision.stopsignproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.File;

public class VideoPlayer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);

        Intent i = getIntent();
        String s = i.getStringExtra("URI");



        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "StopSignVidStore");

        File[] temp = mediaStorageDir.listFiles();
//        for(int x = 0; x < mediaStorageDir.listFiles().length; x++){
//            Toast.makeText(this, temp[x].toURI() + "", Toast.LENGTH_LONG).show();
//        }





        VideoView mVideoView2 = (VideoView)findViewById(R.id.videoView);
        String uriPath2 = s;
        Uri uri2 = Uri.parse(uriPath2);
        mVideoView2.setVideoURI(uri2);
        mVideoView2.requestFocus();
        mVideoView2.start();

    }
}
