import java.util.Arrays;

public class Playlist {
    private final String[] songs;
    private int count;

    public Playlist(int capacity) {
        this.songs = new String[capacity];
        this.count = 0;
    }

    public void addSong(String song) {
        if (count < songs.length) {
            songs[count++] = song;
        }
    }

    // Defensive copy to prevent external mutation
    public String[] getSongs() {
        return Arrays.copyOf(songs, count);
    }

    public static void main(String[] args) {
        System.out.println("=== Assignment 2: The Playlist (Defensive Copy) ===");
        Playlist p = new Playlist(10);
        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();
        copy[0] = "Hacked";

        System.out.println("Modified copy[0]: " + copy[0]);
        System.out.println("Internal songs[0] remains safe: " + p.getSongs()[0]);
    }
}
