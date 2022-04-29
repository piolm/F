package com.example.f;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton button = findViewById(R.id.action_image);
        button.setImageDrawable(AppCompatResources.getDrawable(this, R.drawable.dababy));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    class AudioPlayer extends MediaPlayer {
        private MediaPlayer mPlayer;
        Context c;

        public AudioPlayer(Context c) {
            this.c = c;
        }

        public void start() {
            mPlayer = MediaPlayer.create(c, R.raw.sound);
            mPlayer.setOnCompletionListener(new OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stop();
                }
            });
            mPlayer.start();
        }


        public void stop() {
            if (mPlayer != null) {
                mPlayer.release();
                mPlayer = null;
            }
        }
    }
}