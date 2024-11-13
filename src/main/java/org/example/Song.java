package org.example;

public class Song {
    private int id;
    private String title;
    private String artist;
    private String album;
    private double duration;

    public Song(int id, String title, String artist, String album, double duration) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.duration = duration;
    }

    public int getId(){
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getArtist() {
        return artist;
    }
    public String getAlbum() {
        return album;
    }
    public double getDuration() {
        return duration;
    }

    public void display(){
        System.out.println("Title: " + title + ", Artist: " + artist + ", Album: " + album + ", Duration: " + duration);
    }
}
