package com.yavdev.section13.MusicService;

public class Song {
    private String title;
    private double duration;

    public Song(String title, double duration) {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

//    @Override
//    public boolean equals(Object obj) {
//        if(obj instanceof Song song) {
//            return this.title.equals(song.title);
//        }
//
//        return false;
//    }

    @Override
    public String toString() {
        return this.title + ": " + this.duration;
    }
}
