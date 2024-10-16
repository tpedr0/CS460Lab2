package com.example.swipevideo;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Represents a single video item in the application.
 * This class holds information about a video, including its URL, title, and description.
 */
public class VideoItem {
    private static final AtomicLong ID_GENERATOR = new AtomicLong();

    // Video info
    public String uniqueId, videoURL, videoTitle, videoDescription;

    /**
     * Constructs a new VideoItem with the given details.
     * A unique ID is automatically generated for each new VideoItem.
     *
     * @param videoURL The URL of the video file.
     * @param videoTitle The title of the video.
     * @param videoDescription A brief description of the video content.
     */
    public VideoItem(String videoURL, String videoTitle, String videoDescription){
        this.uniqueId = String.valueOf(ID_GENERATOR.incrementAndGet());
        this.videoURL = videoURL;
        this.videoTitle = videoTitle;
        this.videoDescription = videoDescription;
    }
}
