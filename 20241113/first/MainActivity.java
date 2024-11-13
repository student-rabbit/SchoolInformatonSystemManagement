package com.example.myapp;

import static android.net.Uri.*;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    VideoView video;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 음악 플레이: mp3, wave, midi
        MediaPlayer mp = MediaPlayer.create(this, R.raw.rabbit);
        mp.start();

        // 동영상: mp4
        video = findViewById(R.id.video);
        video.setVideoURI(parse("android.resource://"+getPackageName()+"/"+R.raw.student));
        video.start();
    }
}