package oop.abstraction.interfaces.mytube.impl;

import oop.abstraction.interfaces.mytube.Video;
import oop.abstraction.interfaces.mytube.VideoEncoder;

public class VideoEncoderImpl implements VideoEncoder {

    @Override
    public void encode(Video video) {
        System.out.println("Video encoded!");
    }
}
