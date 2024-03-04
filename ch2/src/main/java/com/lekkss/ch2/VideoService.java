package com.lekkss.ch2;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
// Spring Framework’s annotation denoting a class that needs to be picked up
// during
// component scanning and added to the application context
public class VideoService {

    private List<Video> videos = List.of(
            new Video("Need Help with spring Boot 3?"),
            new Video("This is an Example f me Learning"),
            new Video("A third line example"));

    public List<Video> getVideos() {
        return videos;
    }

    public Video create(Video newVideo) {
        List<Video> extend = new ArrayList<>(videos);
        extend.add(newVideo);
        this.videos = List.copyOf(extend);
        return newVideo;

    }

}
