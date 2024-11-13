package org.example;
import java.util.*;

public class ProxyServer implements SongService{
    SongServer songServer;
    private Map<Integer, Song> cacheById = new HashMap<Integer, Song>();
    private Map<String, List<Song>> cacheByTitle = new HashMap<>();
    private Map<String, List<Song>> cacheByAlbum = new HashMap<>();

    ProxyServer(SongServer songServer) {
        this.songServer = songServer;
    }

    public Song searchById(Integer songID){
        if (cacheById.containsKey(songID)) {
            System.out.println("\"Cache Hit.\"");
            return cacheById.get(songID);
        }
        Song song = songServer.searchById(songID);
        if (song != null) {
            System.out.println("\"Cache Miss.\"");
            cacheById.put(songID, song);
        }
        return song;
    }

    public List<Song> searchByTitle(String title){
        if (cacheByTitle.containsKey(title)) {
            System.out.println("\"Cache Hit.\"");
            return cacheByTitle.get(title);
        }
        System.out.println("\"Cache Miss.\"");
        List<Song> songs = songServer.searchByTitle(title);
        cacheByTitle.put(title, songs);
        return songs;
    }

    public List<Song> searchByAlbum(String album){
        if (cacheByAlbum.containsKey(album)) {
            System.out.println("\"Cache Hit.\"");
            return cacheByAlbum.get(album);
        }
        System.out.println("\"Cache Miss.\"");
        List<Song> songs = songServer.searchByAlbum(album);
        cacheByAlbum.put(album, songs);
        return songs;
    }
}

