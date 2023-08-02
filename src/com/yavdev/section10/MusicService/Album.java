package com.yavdev.section10.MusicService;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public boolean addSong(String title, double duration) {
        if(this.findSong(title) == null) {
            return this.songs.add(new Song(title, duration));
        }

        return false;
    }

    private Song findSong(String title) {
        for (var song : this.songs) {
            if (song.getTitle().equals(title)) {
                return song;
            }
        }

        return null;
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList) {
        try {
            playList.add(this.songs.get(trackNumber - 1));
            return true;
        } catch(IndexOutOfBoundsException e) {
            return false;
        }
    }

    public boolean addToPlayList(String title, LinkedList<Song> playList) {
        final Song song = this.findSong(title);

        if(song != null) {
            playList.add(song);
            return true;
        }

        return false;
    }
}

