package oop.abstraction.interfaces.mytube;

import oop.abstraction.interfaces.mytube.impl.EmailServiceImpl;
import oop.abstraction.interfaces.mytube.impl.VideoDatabaseImpl;
import oop.abstraction.interfaces.mytube.impl.VideoEncoderImpl;

public class VideoProcessor {

    private final VideoEncoder videoEncoder;
    private final VideoDatabase videoDatabase;
    private final EmailService emailService;

    public VideoProcessor(VideoEncoder videoEncoder, VideoDatabase videoDatabase, EmailService emailService) {
        this.videoEncoder = videoEncoder;
        this.videoDatabase = videoDatabase;
        this.emailService = emailService;
    }

    public void process(Video video) {
        videoEncoder.encode(video);
        videoDatabase.store(video);
        emailService.sendEmail(video.getUserName());
    }
}
