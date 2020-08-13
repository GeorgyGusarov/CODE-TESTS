package GenericsAndCollections;

import java.io.*;
import java.util.*;

public class JukeBox2 {

    ArrayList<Song> songList = new ArrayList<Song>();

    public static void main(String[] args) {
        new JukeBox2().go();
    }

    public void go() {
        getSongs();
        System.out.println("До вызова .sort() " + songList);
        Collections.sort(songList);
        System.out.println("После вызова .sort() " + songList);
    }

    public void getSongs() {

        try {
            File file = new File("SongListMore.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line = null;
            while ((line = reader.readLine()) != null) {
                addSong(line);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void addSong(String lineToParse) {
        String[] tokens = lineToParse.split("/");

        Song nextSong = new Song(tokens[0], tokens[1], tokens[2], tokens[3]);
        songList.add(nextSong);
    }
}