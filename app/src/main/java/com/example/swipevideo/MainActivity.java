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

/**
 * The main activity for the SwipeVideo application.
 * This activity sets up the user interface and initializes the video player.
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Called when the activity is first created.
     * This method initializes the UI, sets up the ViewPager2 for video swiping,
     * and populates it with VideoItem objects.
     *
     * @param savedInstanceState
     */
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
        videoItemsList.add(new VideoItem(
                "https://firebasestorage.googleapis.com/v0/b/fir-connection-f3fea.appspot.com/o/IMG_2332.mp4?alt=media&token=2569b9b4-7e9a-479c-8cb3-2ac85f34351e",
                "Scenery",
                "Nature"
        ));

        videoItemsList.add(new VideoItem(
                "https://firebasestorage.googleapis.com/v0/b/fir-connection-f3fea.appspot.com/o/IMG_3123.mp4?alt=media&token=21e56b7c-3f18-40c9-b2f7-bb1f0a3c8208",
                "Dog wants pizza",
                "He's mad!"
        ));

        videoItemsList.add(new VideoItem(
                "https://firebasestorage.googleapis.com/v0/b/fir-connection-f3fea.appspot.com/o/IMG_3213.mp4?alt=media&token=fef6af52-a379-411c-8884-c7ea79191011",
                "Seattle",
                "nice skies"
        ));

        videoViewPager.setAdapter(new VideoAdapter(videoItemsList));
    }
}