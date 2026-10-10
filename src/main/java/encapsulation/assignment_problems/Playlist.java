package encapsulation.assignment_problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Playlist {
    private final String[] songs;
    private int count;

    public Playlist(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("capacity must be positive");
        this.songs = new String[capacity];
        this.count = 0;
    }

    public void addSong(String title) {
        if (title == null) throw new IllegalArgumentException("title cannot be null");
        if (count >= songs.length) throw new IllegalStateException("Playlist is full");
        songs[count++] = title;
    }

    public String[] getSongs() {
        // Return a copy to prevent external modification
        String[] copy = new String[count];
        System.arraycopy(songs, 0, copy, 0, count);
        return copy;
    }

    public int getSongCount() {
        return count;
    }

    public static void main(String[] args) {
        Playlist p = new Playlist(10);
        p.addSong("Song A");
        p.addSong("Song B");
        String[] copy = p.getSongs();
        System.out.println("Copy first: " + copy[0]); // Song A
        // Modify copy - should not affect playlist
        copy[0] = "Hacked";
        System.out.println("After hack, playlist first: " + p.getSongs()[0]); // Still Song A
        System.out.println("Song count: " + p.getSongCount());
    }
}
