package org.example;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        SongServer songServer = new SongServer();
        songServer.addSong(new Song(0, "Alison", "Slowdive", "Souvlaki", 3.75));
        songServer.addSong(new Song(1, "Life on Mars?", "David Bowie", "Hunky Dory", 3.72));
        songServer.addSong(new Song(2, "Something", "The Beatles", "Abbey Road", 3.03));
        songServer.addSong(new Song(3, "Love Me", "Elvis Presley", "Elvis Presley", 2.53));
        songServer.addSong(new Song(4, "Scenic", "Ozean", "Ozean", 4.92));
        songServer.addSong(new Song(5, "Idioteque", "Radiohead", "Kid A", 5.08));
        songServer.addSong(new Song(6, "As the World Caves In", "Matt Maltese", "Bad Contestant", 3.67));
        songServer.addSong(new Song(7, "Machine Gun", "Slowdive", "Souvlaki", 4.48));
        songServer.addSong(new Song(8, "Souvlaki Space Station", "Slowdive", "Souvlaki", 5.89));
        songServer.addSong(new Song(9, "As the World Caves In", "Sarah Cothran", "As the World Caves In", 2.67));

        System.out.println("\nSearch by ID: ");
        ProxyServer proxyServer = new ProxyServer(songServer);
        proxyServer.searchById(1).display(); // Cache miss
        proxyServer.searchById(1).display(); // Cache hit

        System.out.println("\nSearch by title: ");
        List<Song> songsByTitle = proxyServer.searchByTitle("As the World Caves In");
        displaySongs(songsByTitle); // Cache miss
        songsByTitle = proxyServer.searchByTitle("As the World Caves In");
        displaySongs(songsByTitle); // Cache hit

        System.out.println("\nSearch by album: ");
        List<Song> songsByAlbum = proxyServer.searchByAlbum("Souvlaki");
        displaySongs(songsByAlbum); // Cache miss
        songsByAlbum = proxyServer.searchByAlbum("Souvlaki");
        displaySongs(songsByAlbum); // Cache hit
    }

    public static void displaySongs(List<Song> songs){
        for (Song song : songs) {
            song.display();
        }
    }
}