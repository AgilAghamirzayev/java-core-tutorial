package oop.abstraction.interfaces.mytube;

import oop.abstraction.interfaces.mytube.impl.EmailServiceImpl;
import oop.abstraction.interfaces.mytube.impl.VideoDatabaseImpl;
import oop.abstraction.interfaces.mytube.impl.VideoEncoderImpl;

public class Main {
    public static void main(String[] args) {
        VideoEncoder videoEncoder = new VideoEncoderImpl();
        VideoDatabase videoDatabase = new VideoDatabaseImpl();
        EmailService emailService = new EmailServiceImpl();

        Video video = new Video();
        video.setFileName("birthday.mp4");
        video.setTitle("Jennifer's birthday");
        video.setUser(new User("email@test.com", "Ali"));

        VideoProcessor processor = new VideoProcessor(videoEncoder, videoDatabase, emailService);
        processor.process(video);
    }
}
