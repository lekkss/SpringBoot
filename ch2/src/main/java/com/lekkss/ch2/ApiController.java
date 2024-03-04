package com.lekkss.ch2;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
// annotation marks this as a Spring MVC
// controller that returns JSON
public class ApiController {

    private final VideoService videoService;

    public ApiController(VideoService videoService) {
        this.videoService = videoService;
    }

    @GetMapping("/api/videos")
    // public List<Video> getVideos() {
    // return videoService.getVideos();
    // }
    public JsonResponse<List<Video>> getVideos() {
        return new JsonResponse<List<Video>>(true, "videos fetched sucessfully", videoService.getVideos());
    }

    @PostMapping("/api/videos")
    public Video newVideo(@RequestBody Video newVideo) {
        return videoService.create(newVideo);
    }
}
