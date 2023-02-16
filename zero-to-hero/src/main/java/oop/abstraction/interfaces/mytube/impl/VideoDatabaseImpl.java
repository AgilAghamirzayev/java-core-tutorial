package oop.abstraction.interfaces.mytube.impl;

import oop.abstraction.interfaces.mytube.Video;
import oop.abstraction.interfaces.mytube.VideoDatabase;

public class VideoDatabaseImpl implements VideoDatabase {

    @Override
    public void store(Video video) {
        System.out.println("Done");
    }
}
