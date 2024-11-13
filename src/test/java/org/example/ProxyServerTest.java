package org.example;
import java.util.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class ProxyServerTest {
    private ProxyServer proxyServer;
    private SongServer songServer;

    @BeforeEach
    public void setUp() {
        songServer = new SongServer();
        // Adding sample songs from your driver program
        songServer.addSong(new Song(0, "Alison", "Slowdive", "Souvlaki", 3.75));
        songServer.addSong(new Song(1, "Idioteque", "Radiohead", "Kid A", 5.08));
        proxyServer = new ProxyServer(songServer);
    }

    @Test
    public void searchByIdTest() {
        Song song = proxyServer.searchById(1);
        assertNotNull(song);
        assertEquals(1, song.getId());
        Song cachedSong = proxyServer.searchById(1);
        assertNotNull(cachedSong);
        assertEquals(song, cachedSong);
    }

    @Test
    public void searchByTitleTest() {
        List<Song> songs = proxyServer.searchByTitle("Alison");
        assertEquals(1, songs.size());
        List<Song> cachedSongs = proxyServer.searchByTitle("Alison");
        assertEquals(1, cachedSongs.size());
    }

    @Test
    public void searchByAlbumTest() {
        List<Song> songs = proxyServer.searchByAlbum("Kid A");
        assertEquals(1, songs.size());
        List<Song> cachedSongs = proxyServer.searchByAlbum("Kid A");
        assertEquals(1, cachedSongs.size());
    }
}