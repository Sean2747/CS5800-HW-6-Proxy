package org.example;
import java.util.*;

public class SongServer implements SongService {
    private List<Song> songs = new ArrayList<>();

    public void addSong(Song song){
        songs.add(song);
    }

    public Song searchById(Integer songID) {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {}

        for (Song song : songs) {
            if (song.getId() == songID) {
                return song;
            }
        }
        return null;
    }

    public List<Song> searchByTitle(String title){
        try {
            Thread.sleep(1000);
        } catch (Exception e) {}
        List<Song> result = new ArrayList<>();
        for (Song song : songs) {
            if (song.getTitle().equals(title)) {
                result.add(song);
            }
        }
        return result;
    }

    public List<Song> searchByAlbum(String album) {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {}
        List<Song> result = new ArrayList<>();
        for (Song song : songs) {
            if (song.getAlbum().equals(album)) {
                result.add(song);
            }
        }
        return result;
    }
}
