package org.example;
import java.util.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class SongServerTest {
    private SongServer songServer;

    @BeforeEach
    public void setUp() {
        songServer = new SongServer();
        songServer.addSong(new Song(0, "Imagine", "John Lennon", "Imagine", 3.05));
        songServer.addSong(new Song(1, "Bohemian Rhapsody", "Queen", "A Night at the Opera", 5.55));
        songServer.addSong(new Song(2, "Yesterday", "The Beatles", "Help!", 2.03));
    }

    @Test
    public void searchByIdFoundTest() {
        Song song = songServer.searchById(0);
        assertNotNull(song);
        assertEquals("Imagine", song.getTitle());
    }

    @Test
    public void searchByIdNotFoundTest() {
        Song song = songServer.searchById(8);
        assertNull(song);
    }

    @Test
    public void searchByTitleFoundTest() {
        List<Song> songs = songServer.searchByTitle("Imagine");
        assertEquals(1, songs.size());
    }

    @Test
    public void searchByTitleNotFoundTest() {
        List<Song> songs = songServer.searchByTitle("Starman");
        assertTrue(songs.isEmpty());
    }

    @Test
    public void searchByAlbumFoundTest() {
        List<Song> songs = songServer.searchByAlbum("Imagine");
        assertEquals(1, songs.size());
    }

    @Test
    public void searchByAlbumNotFoundTest() {
        List<Song> songs = songServer.searchByAlbum("Baroque Guitar");
        assertTrue(songs.isEmpty());
    }
}