package org.example;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class SongTest {
    private Song song = new Song(1, "Imagine", "John Lennon", "Imagine", 3.05);

    @Test
    public void getIdTest() {
        assertEquals(1, song.getId());
    }

    @Test
    public void getTitleTest() {
        assertEquals("Imagine", song.getTitle());
    }

    @Test
    public void getArtistTest() {
        assertEquals("John Lennon", song.getArtist());
    }

    @Test
    public void getAlbumTest() {
        assertEquals("Imagine", song.getAlbum());
    }

    @Test
    public void getDurationTest() {
        assertEquals(3.05, song.getDuration());
    }
}