package com.yavdev.section13.MusicService;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private SongList songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new Album.SongList();
    }

    public boolean addSong(String title, double duration) {
        return this.songs.add(new Song(title, duration));
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList) {
        final Song song = this.songs.findSong(trackNumber);

        if(song != null) {
            playList.add(song);
            return true;
        }

        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playList) {
        final Song song = this.songs.findSong(title);

        if(song != null) {
            playList.add(song);
            return true;
        }

        return false;
    }

    public static class SongList {
        private ArrayList<Song> songs;

        private SongList() {
            this.songs = new ArrayList<>();
        }

        private boolean add(Song newSong) {
            if(this.findSong(newSong.getTitle()) == null) {
                return this.songs.add(newSong);
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

        private Song findSong(int trackNumber) {
            try {
                return this.songs.get(trackNumber - 1);
            } catch(IndexOutOfBoundsException e) {
                return null;
            }
        }
    }
}

