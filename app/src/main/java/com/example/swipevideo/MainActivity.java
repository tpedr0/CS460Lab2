package com.example.swipevideo;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        final ViewPager2 videoViewPager = findViewById(R.id.videoViewPager);

        List<VideoItem> videoItemsList = new ArrayList<>();
        VideoItem videoScenery = new VideoItem();
        videoScenery.videoURL = "https://firebasestorage.googleapis.com/v0/b/fir-connection-f3fea.appspot.com/o/IMG_2332.mp4?alt=media&token=2569b9b4-7e9a-479c-8cb3-2ac85f34351e";
        videoScenery.videoTitle = "Scenery";
        videoScenery.videoDescription = "Nature";
        videoItemsList.add(videoScenery);

        VideoItem videoDog = new VideoItem();
        videoDog.videoURL = "https://firebasestorage.googleapis.com/v0/b/fir-connection-f3fea.appspot.com/o/IMG_3123.mp4?alt=media&token=21e56b7c-3f18-40c9-b2f7-bb1f0a3c8208";
        videoDog.videoTitle = "Dog wants pizza";
        videoDog.videoDescription = "He's mad!";
        videoItemsList.add(videoDog);

        VideoItem videoSeattle = new VideoItem();
        videoSeattle.videoURL = "https://firebasestorage.googleapis.com/v0/b/fir-connection-f3fea.appspot.com/o/IMG_3213.mp4?alt=media&token=fef6af52-a379-411c-8884-c7ea79191011";
        videoSeattle.videoTitle = "Seattle";
        videoSeattle.videoDescription = "nice skies";
        videoItemsList.add(videoSeattle);

        videoViewPager.setAdapter(new VideoAdapter(videoItemsList));
    }
}