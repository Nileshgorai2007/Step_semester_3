package encapsulation.assignment_problems;

public class Playlist {
    private final int maxSize;
    private final String[] songs;
    private int count;

    public Playlist(int maxSize) {
        this.maxSize = maxSize;
        this.songs = new String[maxSize];
        this.count = 0;
    }

    public void addSong(String title) {
        if (count < maxSize) {
            songs[count++] = title;
        }
    }

    public String[] getSongs() {
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
        for (String s : p.getSongs()) {
            System.out.println(s);
        }
    }
}
