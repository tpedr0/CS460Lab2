package com.example.swipevideo;

import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Adapter class for managing video items in a RecyclerView.
 * This adapter creates ViewHolders and binds VideoItem data to them.
 */
public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder>{


    private List<VideoItem> videoItems;

    /**
     * Constructs a new VideoAdapter with the given list of video items.
     *
     * @param videoItems The list of VideoItem objects to be displayed.
     */
    public VideoAdapter(List<VideoItem> videoItems) {
        this.videoItems = videoItems;
    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VideoViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_container_video, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {
        holder.setVideoData(videoItems.get(position));
    }

    @Override
    public int getItemCount() {
        return videoItems.size();
    }

    /**
     * ViewHolder class for individual video items.
     * This class holds references to the views in the item layout and handles video playback.
     */
    static class VideoViewHolder extends RecyclerView.ViewHolder {
        TextView textVideoTitle, textVideoDescription, textVideoId;
        VideoView videoView;
        ProgressBar progressBar;
        boolean isPlaying = true;

        /**
         * Constructs a new VideoViewHolder.
         *
         * @param itemView The View object containing the layout for an individual video item.
         */
        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);
            videoView = itemView.findViewById(R.id.videoView);
            textVideoTitle = itemView.findViewById(R.id.textVideoTitle);
            textVideoDescription = itemView.findViewById(R.id.textVideoDescription);
            textVideoId = itemView.findViewById(R.id.textVideoId);
            progressBar = itemView.findViewById(R.id.videoProgressBar);

            videoView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event){
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    togglePlayPause();
                    return true;
                }
                return false;
            }
        });
        }

        /**
         * Sets the data for a video item to the views in this ViewHolder.
         *
         * @param videoItem The VideoItem object containing the data to be displayed.
         */
        void setVideoData(VideoItem videoItem){
            textVideoTitle.setText(videoItem.videoTitle);
            textVideoDescription.setText(videoItem.videoDescription);
            textVideoId.setText("ID: #" + videoItem.uniqueId);
            videoView.setVideoPath(videoItem.videoURL);

            videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    progressBar.setVisibility(View.GONE);
                    mp.start();

                    float videoRatio = mp.getVideoWidth() / (float) mp.getVideoHeight();
                    float screenRatio = videoView.getWidth() / (float) videoView.getHeight();

                    float scale = videoRatio / screenRatio;
                    if(scale >=1f){
                        videoView.setScaleX(scale);
                    } else {
                        videoView.setScaleY(1f / scale);
                    }
                }
            });
            videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mp.start();
                }
            });
        }

        /**
         * Toggles the play/pause state of the current video.
         */
        private void togglePlayPause(){
            if(isPlaying) {
                videoView.pause();
            } else {
                videoView.start();
            }
            isPlaying = !isPlaying;
        }
    }
}
