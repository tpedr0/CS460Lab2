package com.example.swipevideo;

import java.util.concurrent.atomic.AtomicLong;

public class VideoItem {
    private static final AtomicLong ID_GENERATOR = new AtomicLong();
    public String uniqueId, videoURL, videoTitle, videoDescription;

    public VideoItem(String videoURL, String videoTitle, String videoDescription){
        this.uniqueId = String.valueOf(ID_GENERATOR.incrementAndGet());
        this.videoURL = videoURL;
        this.videoTitle = videoTitle;
        this.videoDescription = videoDescription;
    }
}
